package org.backend.wizardry.springbootcrashcoursewithvega.configs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyWebConfig {
    private Log logger = LogFactory.getLog(this.getClass());
    @Bean(name = "rest_template_bean")
    public RestTemplate template(){
        logger.info("rest_template_bean created!");
        return new RestTemplate();
    }
}
