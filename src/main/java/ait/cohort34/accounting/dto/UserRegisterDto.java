package ait.cohort34.accounting.dto;

import lombok.Getter;

@Getter
public class UserRegisterDto {
    private String clas;//? у Ярослава
    private String organizationName;
    private String fullName;
    private String login;
    private String password;
    private String email;
    private String website;
    private String phone;//?
    private String telegram;
    private Boolean isAgree;//?только front

}
