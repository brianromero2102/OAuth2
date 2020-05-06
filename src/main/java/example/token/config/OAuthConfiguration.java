package example.token.config;


import example.token.api.SSOApi;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.ipc.netty.http.client.HttpClient;

@Configuration
public class OAuthConfiguration {

    @Bean
    SSOApi ssoApi(
            @Value("${jarvis.security.oauth.accesstokenuri}") String apiBaseUrl,
            OkHttpClient.Builder builder) {

        return JarvisHttpClient.builder()
                             .baseUrl(apiBaseUrl)
                             .clientBuilder(new OkHttpClient.Builder())
                             .buildProxy(SSOApi.class);
    }
}