package com.las.learn.springcloud;

import com.las.learn.springcloud.ribbonClient.DefaultConfiguration;
import com.las.learn.springcloud.ribbonClient.PaymentConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.cloud.consul.discovery.ConsulRibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConditionalOnConsulEnabled
@AutoConfigureAfter(RibbonAutoConfiguration.class)
@RibbonClients(
        value = {
                @RibbonClient(value = "payment", configuration = PaymentConfiguration.class)
        },
        defaultConfiguration = {ConsulRibbonClientConfiguration.class, DefaultConfiguration.class})
public class RibbonConsulConfiguration {
}
