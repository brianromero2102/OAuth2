package example.service;

import example.model.dto.RequestUser;
import example.model.dto.ResponseUser;
import reactor.core.publisher.Mono;

public interface PersonService {

    public Mono<ResponseUser> flowAuthenticate(RequestUser requestUser);
}
