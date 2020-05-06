package example.token.business.impl;

import com.sun.org.apache.bcel.internal.ExceptionConst;
import example.token.api.SSOApi;
import example.token.business.OAuthService;
import example.token.config.OAuthConfigProperties;
import example.token.model.ConfigClientModel;
import example.token.model.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;


@Service
public class OAuthServiceImpl implements OAuthService {

    @Autowired
    private SSOApi api;

    @Autowired
    private OAuthConfigProperties properties;

    public TokenResponse getToken(String canal) throws IOException {

        if(properties.client.containsKey(canal)) {
            ConfigClientModel param = properties.client.get(canal);
            //try {
            Response<TokenResponse> response = api.token(param.getClient(),
                    param.getSecret(),
                    param.getScope(),
                    param.getGrantType())
                    .execute();
            if (response.code() == 200) {
                return response.body();
            } else {
                    /*JarvisException.builder()
                                         .systemCode("JA9991")
                                         .addDetail()
                                         .withComponent("jarvis-support-channel-cross-user-security-v1.0")
                                         .withDescription(response.errorBody().string())
                                         .push()
                                         .build();*/
                    return null;
            }
            /*}catch (JarvisException e){
                throw e;
            }catch (Exception e){
                throw JarvisException.builder().systemCode("JA9999").build();
            }*/
        }else{
            // throw JarvisException.builder().systemCode("JA9999").build();
            return null;
        }
    }

    public TokenResponse logout(String canal, String authorization, String refreshToken) throws IOException {
        if(properties.client.containsKey(canal)){
            ConfigClientModel param = properties.client.get(canal);
            //try{
                Response<TokenResponse> response =  api.logout( param.getClient(),
                                                                param.getSecret(),
                                                                authorization,
                                                                refreshToken)
                        .execute();
                if(response.code() >= 200 && response.code() <= 299){
                    return response.body();
                }else{
                    /*throw JarvisException.builder()
                            .systemCode("JA9991")
                            .addDetail()
                            .withComponent("jarvis-support-channel-cross-user-security-v1.0")
                            .withDescription(response.errorBody().string())
                            .push()
                            .build();*/
                    return null;
                }
            /*}catch (JarvisException e){
                throw e;
            }catch (Exception e){
                throw JarvisException.builder().systemCode("JA9999").build();
            }*/
        }else{
            //throw JarvisException.builder().systemCode("JA9999").build();
            return null;
        }

    }
}
