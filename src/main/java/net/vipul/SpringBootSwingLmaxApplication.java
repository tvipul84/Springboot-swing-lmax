package net.vipul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSwingLmaxApplication {
    @Value("${app.version}")
    private String appVersion;
    
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootSwingLmaxApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    public ChatFrame frame() {
        return new ChatFrame();
    }
}
