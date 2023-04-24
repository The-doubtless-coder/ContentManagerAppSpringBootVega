package org.backend.wizardry.springbootcrashcoursewithvega;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.backend.wizardry.springbootcrashcoursewithvega.configs.SampleConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SampleConfigProperties.class)
public class SpringBootCrashCourseWithVegaApplication {
    private Log logger = LogFactory.getLog(this.getClass());

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run
                (SpringBootCrashCourseWithVegaApplication.class, args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.setProperty("spring.profiles.active","devil");
    }

}
