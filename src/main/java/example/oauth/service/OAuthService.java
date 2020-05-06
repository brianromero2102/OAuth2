package example.oauth.service;

import reactor.core.publisher.Mono;

public interface OAuthService {

    Mono<String> getToken();
}
