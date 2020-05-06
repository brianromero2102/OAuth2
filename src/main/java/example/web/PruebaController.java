package example.web;

import example.model.dto.RequestUser;
import example.model.dto.ResponseUser;
import example.oauth.service.OAuthService;
import example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController()
@Validated
public class PruebaController {

    @Autowired
    private PersonService personService;

    @Autowired
    OAuthService oAuthService;

    @PostMapping( path= "authenticate")
    public Mono<ResponseUser> getPerson(@RequestBody @Valid RequestUser requestUser) {
        return personService.flowAuthenticate(requestUser);
    }

    @GetMapping( path="token")
    public Mono<String> getToken() {

        return oAuthService.getToken();
    }
}
