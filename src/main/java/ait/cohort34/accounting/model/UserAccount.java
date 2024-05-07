package ait.cohort34.accounting.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserAccount implements UserDetails {
    @Id
    private String login;
    private String avatar;
    private String password;
    private String fullName;
    private String email;
    private String website;
    private String phone;
    private String telegram;//возможность заменить на чат
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role = Role.USER;

    public UserAccount(String login,String avatar, String password, String fullName, String email, String website, String phone, String telegram) {
        this.login = login;
        this.avatar = avatar;
        this.password = password;
        this.fullName=fullName;
        this.email = email;
        this.website = website;
        this.phone = phone;
        this.telegram = telegram;
    }

    public boolean changeRole() {
        this.role = (this.role == Role.USER) ? Role.ADMINISTRATOR : Role.USER;
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.getLogin();
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
