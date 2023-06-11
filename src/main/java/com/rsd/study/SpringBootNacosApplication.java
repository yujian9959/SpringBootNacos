package com.rsd.study;

import com.rsd.study.conf.AppointNacosProperties;
import com.rsd.study.conf.NacosDynamicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raoyaodong
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootNacosApplication {

    @Autowired
    private NacosDynamicProperties nacosDynamicProperties;
    @Autowired
    private AppointNacosProperties appointNacosProperties;
    @Value("${spring.application.name}")
    public String applicationName;

    public static void main(String[] args) {
        // SpringApplication.run(SpringBootNacosApplication.class, args);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootNacosApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("project.name");
        String userAge = applicationContext.getEnvironment().getProperty("project.org");
        System.err.println("project.name :" + userName + "; project.org: " + userAge);

    }

    @RestController
    public class EchoController {
        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
    }

    @RestController
    public class NacosProperties {
        @GetMapping(value = "/properties")
        public String echo() {
            System.out.println("applicationName: " + applicationName);
            return nacosDynamicProperties.getProjectName();
        }
    }

    @RestController
    public class AppointNacosPropertiesController {
        @GetMapping(value = "/appointProperties/{data}")
        public String echo(@PathVariable String data) {
            if ("data1".equals(data)) {
                return appointNacosProperties.getData1();
            }
            return appointNacosProperties.getData2();
        }
    }
}
