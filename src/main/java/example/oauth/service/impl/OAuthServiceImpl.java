package example.oauth.service.impl;

import example.oauth.service.OAuthService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OAuthServiceImpl implements OAuthService {



    public Mono<String> getToken() {
        return null;
    }
}
