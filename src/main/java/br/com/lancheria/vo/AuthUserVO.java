package br.com.lancheria.vo;


import java.io.Serializable;
import java.security.Principal;
import java.util.List;

public class AuthUserVO implements Serializable, Principal {

    private static final long serialVersionUID = 3453003583495425296L;

    private String facebookId;
    private String name;
    private List<String> permissions;

    public AuthUserVO() {}

    public AuthUserVO(String facebookId, String name, List<String> permissions) {
        this.facebookId = facebookId;
        this.name = name;
        this.permissions = permissions;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
