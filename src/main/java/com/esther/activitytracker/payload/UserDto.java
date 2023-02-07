package com.esther.activitytracker.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String firstname;
    private String lastname;
    private  String email;
    private String password;

}
