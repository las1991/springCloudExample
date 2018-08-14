package com.las.learn.springcloud;

import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RequestSpecificRetryHandler;
import com.netflix.client.RetryHandler;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancedRetryPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DefaultRibbonClientConfiguration {

    @Value("${ribbon.client.name}")
    private String name;

    @Bean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(this.name);
        config.set(CommonClientConfigKey.ConnectTimeout, DefaultClientConfigImpl.DEFAULT_CONNECT_TIMEOUT);
        config.set(CommonClientConfigKey.ReadTimeout, DefaultClientConfigImpl.DEFAULT_READ_TIMEOUT);
        config.set(CommonClientConfigKey.MaxAutoRetries, 1);
        config.set(CommonClientConfigKey.MaxAutoRetriesNextServer, 1);
        config.set(RibbonLoadBalancedRetryPolicy.RETRYABLE_STATUS_CODES, "400,500,502,503");
        return config;
    }

    @Bean
    public RetryHandler getRetryHandler(@Autowired(required = false) IClientConfig config) {
        RetryHandler handler = new RequestSpecificRetryHandler(true, true, new DefaultLoadBalancerRetryHandler(0, 1, true), config);
        return handler;
    }
}
