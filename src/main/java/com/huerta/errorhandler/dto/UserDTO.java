package com.huerta.errorhandler.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.huerta.errorhandler.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

  private UUID id;
  private String email;
  private LocalDate birthday;
  private String gender;
  private String firstName;
  private String secondName;
  private String lastName;

  public UserDTO(final User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.birthday = user.getBirthday();
    this.firstName = user.getFirstName();
    this.secondName = user.getSecondName();
    this.lastName = user.getLastName();
  }
}
