package com.studuyjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author ylt
 */

@Entity
@Table(name = "sys_user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    //@JsonIgnoreProperties(value = { "users" })

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    public User(){}

    //region set get

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

    // endregion
}
