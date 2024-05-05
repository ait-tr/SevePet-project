package ait.cohort34.accounting.dto;

import lombok.Getter;

@Getter
public class UserEditDto {
    private String organizationName;
    private String fullName;
//    private String telegram;
//    private String email; разрешим пользователю менять еще и эти поля
//    private String website;
//    private String phone;
}
