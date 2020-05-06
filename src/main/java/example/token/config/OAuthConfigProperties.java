package example.token.config;

import example.token.model.ConfigClientModel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("jarvis.security.oauth")
public class OAuthConfigProperties {


    private String accesstokenuri;

    public Map<String, ConfigClientModel> client;


}
