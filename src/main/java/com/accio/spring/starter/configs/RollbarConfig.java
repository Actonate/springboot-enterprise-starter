package com.accio.spring.starter.configs;

        import com.rollbar.notifier.Rollbar;
        import com.rollbar.notifier.config.Config;
        import com.rollbar.spring.webmvc.RollbarSpringConfigBuilder;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration()
@EnableWebMvc
@ComponentScan({

// UPDATE TO YOUR PROJECT PACKAGE
        "com.accio.spring.starter",
        "com.rollbar.spring"

})
public class RollbarConfig {

    @Value("${rollbar.accesstoken}")
    private String rollbarAccessToken;

    @Value("${spring.profiles.active}")
    private String springActiveProfile;

    /**
     * Register a Rollbar bean to configure App with Rollbar.
     */
    @Bean
    public Rollbar rollbar() {
        return new Rollbar(getRollbarConfigs(rollbarAccessToken));
    }

    private Config getRollbarConfigs(String accessToken) {

        // Reference ConfigBuilder.java for all the properties you can set for Rollbar
        return RollbarSpringConfigBuilder.withAccessToken(accessToken)
                .environment(springActiveProfile)
                .build();
    }
}