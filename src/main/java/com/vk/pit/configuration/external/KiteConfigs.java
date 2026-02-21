package com.vk.pit.configuration.external;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "kite")
public class KiteConfigs {
    private int version;
    private String apiKey;
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
