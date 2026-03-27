package com.vk.pit.kite.commons;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "kite")
public class KiteProperties {
    private String version;
    private String apiKey;
    private String apiSecret;
    private Host host;
    private Service service;

    @Data
    public static class Host {
        private String appHost;
        private String apiHost;
    }

    @Data
    public static class Service {
        private String loginUrl;
        private String profileUrl;
        private String sessionUrl;
    }
}
