package ait.cohort34.accounting.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String clas;//чтобы было, как у Ярослава
    private String organizationName;
    private String fullName;
    private String login;
    private String email;
    private String website;
    private String phone;
    private String telegram;
    private String role;

}
