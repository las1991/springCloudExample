package com.las.learn.springcloud.ribbonClient;

import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RequestSpecificRetryHandler;
import com.netflix.client.RetryHandler;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author las
 * @date 19-5-10
 */
@Configuration
public class DefaultConfiguration {

    @Value("${ribbon.client.name}")
    private String name = "client";

    @Bean
    IClientConfig clientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(this.name);
        config.set(CommonClientConfigKey.ConnectTimeout, 1000);
        config.set(CommonClientConfigKey.ReadTimeout, 1000);
        config.set(CommonClientConfigKey.MaxAutoRetries, 0);
        config.set(CommonClientConfigKey.MaxAutoRetriesNextServer, 1);
        config.set(new CommonClientConfigKey<String>("retryableStatusCodes") {
        }, "404,400,403,500,502,503,504");
        return config;
    }

    @Bean
    public RetryHandler getRetryHandler(IClientConfig config) {
        RetryHandler handler = new RequestSpecificRetryHandler(true, true, new DefaultLoadBalancerRetryHandler(0, 1, true), config);
        return handler;
    }
}
