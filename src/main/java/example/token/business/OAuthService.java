package example.token.business;

import example.token.model.TokenResponse;

import java.io.IOException;

public interface OAuthService {

    public TokenResponse getToken(String canal) throws IOException;

    public TokenResponse logout(String canal, String authorization, String refreshToken) throws IOException;
}
