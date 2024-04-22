package com.huerta.errorhandler.request;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class UserRequest {

  private String email;
  private LocalDate birthday;
  private String gender;
  private String firstName;
  private String secondName;
  private String lastName;
}
