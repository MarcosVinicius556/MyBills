package com.dev.marcos.mybills.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "tb_user", indexes = {
    @Index( columnList = "id" )
} )
public class User implements UserDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "user_sequence" )
    @SequenceGenerator( name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1 )
    private long id;

    @Column( name = "name", length = 128 )
    private String name;

    @Column( name = "telephone", length = 24 )
    private String telephone;

    @Column( name = "username", length = 64 )
    private String userName;

    @Column( name = "pass", length = 64 )
    private String pass;

    @Column( name = "balance", precision = 4, scale = 2 )
    private BigDecimal balance;

    @OneToMany( fetch = FetchType.EAGER )
    private List<Bills> bills = new ArrayList<>();

    public User() {

    }

    public User(String name, String telephone, String userName, String pass) {
        this.name = name;
        this.telephone = telephone;
        this.userName = userName;
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
