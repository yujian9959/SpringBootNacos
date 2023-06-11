package com.rsd.study.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class NacosDynamicProperties {


    @Value("${project.name}")
    private String projectName;


    public String getProjectName() {
        return projectName;
    }
}
