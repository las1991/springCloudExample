package com.las.learn.springcloud;

import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RequestSpecificRetryHandler;
import com.netflix.client.RetryHandler;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static com.netflix.client.config.DefaultClientConfigImpl.DEFAULT_CONNECT_TIMEOUT;
import static com.netflix.client.config.DefaultClientConfigImpl.DEFAULT_READ_TIMEOUT;
import static org.springframework.cloud.netflix.ribbon.RibbonLoadBalancedRetryPolicy.RETRYABLE_STATUS_CODES;

@Configuration
public class LoadBalancerConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IClientConfig ribbonClientConfig() {
//        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
//        config.set(CommonClientConfigKey.ConnectTimeout, DEFAULT_CONNECT_TIMEOUT);
//        config.set(CommonClientConfigKey.ReadTimeout, DEFAULT_READ_TIMEOUT);
//        config.set(RETRYABLE_STATUS_CODES, "500,502,503");
//        return config;
//    }

    @Bean
    public RetryHandler getRetryHandler(@Autowired(required = false) IClientConfig config) {
        return new RequestSpecificRetryHandler(true, true, new DefaultLoadBalancerRetryHandler(), config);
    }
}
