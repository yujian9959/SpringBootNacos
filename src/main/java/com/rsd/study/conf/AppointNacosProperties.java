package com.rsd.study.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AppointNacosProperties {

    @Value("${project.name.data1}")
    public String data1;

    @Value("${project.name.data2}")
    public String data2;

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }
}
