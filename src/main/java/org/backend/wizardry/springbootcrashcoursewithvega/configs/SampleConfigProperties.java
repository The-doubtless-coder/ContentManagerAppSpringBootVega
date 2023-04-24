package org.backend.wizardry.springbootcrashcoursewithvega.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public class SampleConfigProperties {
    private String name;
    private String home;
    private String school;

    public SampleConfigProperties(String name, String home, String school) {
        this.name = name;
        this.home = home;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
