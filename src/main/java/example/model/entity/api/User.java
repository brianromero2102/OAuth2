package example.model.entity.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class User extends Person{

    @NotNull(message = "No debe ser nulo.")
    @NotBlank(message = "No debe ser vacio.")
    private String username;
    @NotNull(message = "No debe ser nulo.")
    @NotBlank(message = "No debe ser vacio.")
    private String digitalPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDigitalPassword() {
        return digitalPassword;
    }

    public void setDigitalPassword(String digitalPassword) {
        this.digitalPassword = digitalPassword;
    }
}
