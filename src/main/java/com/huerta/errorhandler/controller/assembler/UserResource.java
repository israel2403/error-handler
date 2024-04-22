package com.huerta.errorhandler.controller.assembler;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.huerta.errorhandler.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserResource extends RepresentationModel<UserResource> {

  private UUID id;
  private String email;
  private LocalDate birthday;
  private String gender;
  private String firstName;
  private String secondName;
  private String lastName;

  public UserResource(final UserDTO userDTO) {
    this(
      userDTO.getId(),
      userDTO.getEmail(),
      userDTO.getBirthday(),
      userDTO.getGender(),
      userDTO.getFirstName(),
      userDTO.getSecondName(),
      userDTO.getLastName()
    );
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result =
      prime * result + ((secondName == null) ? 0 : secondName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    UserResource other = (UserResource) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (email == null) {
      if (other.email != null) return false;
    } else if (!email.equals(other.email)) return false;
    if (birthday == null) {
      if (other.birthday != null) return false;
    } else if (!birthday.equals(other.birthday)) return false;
    if (gender == null) {
      if (other.gender != null) return false;
    } else if (!gender.equals(other.gender)) return false;
    if (firstName == null) {
      if (other.firstName != null) return false;
    } else if (!firstName.equals(other.firstName)) return false;
    if (secondName == null) {
      if (other.secondName != null) return false;
    } else if (!secondName.equals(other.secondName)) return false;
    if (lastName == null) {
      if (other.lastName != null) return false;
    } else if (!lastName.equals(other.lastName)) return false;
    return true;
  }
}
