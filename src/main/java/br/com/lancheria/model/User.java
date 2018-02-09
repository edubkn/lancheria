package br.com.lancheria.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eduardo on 05/02/2018.
 */
@Entity
@NamedEntityGraph(name = "User.detail", attributeNodes = @NamedAttributeNode("permissions"))
public class User {

    private static final long serialVersionUID = 1009543439831777570L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String facebookId;
    private String name;
    @ManyToMany
    @JoinTable(name = "user_permission", joinColumns = {
            @JoinColumn(name = "id_user", nullable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "id_permission", nullable = false) })
    private Set<Permission> permissions;

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
