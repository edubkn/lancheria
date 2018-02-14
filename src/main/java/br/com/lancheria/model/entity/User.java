package br.com.lancheria.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eduardo on 05/02/2018.
 */
@Entity
@NamedEntityGraph(name = "User.detail", attributeNodes = @NamedAttributeNode("permissions"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String facebookId;
    private String name;
    @ManyToMany
    @JoinTable(name = "user_permission", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", nullable = false) })
    private Set<Permission> permissions;

    public User(){}

    public User(String facebookId) {
        this(null, facebookId, null);
    }

    private User(Long id, String facebookId, String name) {
        this.id = id;
        this.facebookId = facebookId;
        this.name = name;
    }

    public void addPermission(Permission permission) {
        if (this.permissions == null) {
            this.permissions = new HashSet<>();
        }
        this.permissions.add(permission);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
