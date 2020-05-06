package example.token.model;

public class ConfigClientModel {
    private String secret;
    private String client;
    private String grantType;
    private String scope;

    public ConfigClientModel() {
    }

    public ConfigClientModel(String secret, String client, String grantType, String scope) {
        this.secret = secret;
        this.client = client;
        this.grantType = grantType;
        this.scope = scope;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
