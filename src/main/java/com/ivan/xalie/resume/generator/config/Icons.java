package com.ivan.xalie.resume.generator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "template")
@Data
public class Icons {
    private List<Icon> icons;

    public Icon get(String name) {
        return icons.stream().filter(icon -> icon.getName().equals(name)).findFirst().orElseThrow();
    }

    @Data
    public static class Icon {
        private String name;
        private String link;
    }
}
