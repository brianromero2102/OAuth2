package example.model.entity.db;

public class UserEntity {

    private String username;
    private String personId;
    private boolean flagEnrollment;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public boolean isFlagEnrollment() {
        return flagEnrollment;
    }

    public void setFlagEnrollment(boolean flagEnrollment) {
        this.flagEnrollment = flagEnrollment;
    }
}
