package example.token.api;

import example.token.model.TokenResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SSOApi {

    @FormUrlEncoded
    @POST("/auth/realms/master/protocol/openid-connect/token")
    public Call<TokenResponse> token(@Field("client_id") String clientId,
                                     @Field("client_secret") String clientSecret,
                                     @Field("scope") String scope,
                                     @Field("grant_type") String grantType);

    @FormUrlEncoded
    @POST("/auth/realms/master/protocol/openid-connect/logout")
    public Call<TokenResponse> logout(@Field("client_id") String clientId,
                                     @Field("client_secret") String clientSecret,
                                     @Header("Authorization") String authorization,
                                     @Field("refresh_token") String refresh_token);
}
