package ait.cohort34.accounting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "login")
@Table(name = "users")
public class UserAccount {

    @Id
    private String login;
    private String password;
    private String organizationName;
    private String fullName;
    private String clas;//? у Ярослава
    private String email;
    private String website;
    private String phone;//?
    private String telegram;
    private Role role= Role.USER; // задаю начальную роль пользователя

    public UserAccount(String login, String password, String organizationName, String fullName, String clas, String email, String website, String phone, String telegram) {
        this.login = login;
        this.password = password;
        this.organizationName=organizationName;
        this.fullName=fullName;
        this.clas = clas;
        this.email = email;
        this.website = website;
        this.phone = phone;
        this.telegram = telegram;
    }

    public boolean changeRole() {
        this.role = (this.role == Role.USER) ? Role.ADMINISTRATOR : Role.USER;
        return true;
    }
}
