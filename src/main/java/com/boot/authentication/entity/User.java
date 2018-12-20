package com.boot.authentication.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String userName;

    private String email;

//    @Column(length = 60)
//    private String password;
//
//    private boolean enabled;
//
//    private boolean isUsing2FA;
//
//    private String secret;

    //

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    /***********************************************************************************************
     *
     * Initially, when the User is registered, this enabled field will be set to false. During the
     * account verification process – if successful – it will become true.
     *
     * **********************************************************************************************/

    public User() {
        super();
//        this.secret = Base32.random();
//        this.enabled = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String username) {
        this.email = username;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(final String password) {
//        this.password = password;
//    }
//
//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(final Collection<Role> roles) {
//        this.roles = roles;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(final boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public Boolean getUsing2FA() {
//        return isUsing2FA;
//    }
//
//    public void setUsing2FA(boolean using2FA) {
//        this.isUsing2FA = using2FA;
//    }
//
//    public void setSecret(String secret) {
//        this.secret = secret;
//    }
//
//    public String getSecret() {
//        return secret;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        if (!email.equals(user.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}