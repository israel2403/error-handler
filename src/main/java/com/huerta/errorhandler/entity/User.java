package com.huerta.errorhandler.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.huerta.errorhandler.request.UserRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@NoArgsConstructor
@Getter
@Setter
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String email;

  @Column
  private LocalDate birthday;

  @Column
  private String gender;

  @Column
  private String firstName;

  @Column
  private String secondName;

  @Column
  private String lastName;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime creationDate;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime updatedDate;

  @PrePersist
  protected void onCreate() {
    this.creationDate = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUPdate() {
    this.updatedDate = LocalDateTime.now();
  }

  public User(final UserRequest userRequest) {
    this.email = userRequest.getEmail();
    this.birthday = userRequest.getBirthday();
    this.gender = userRequest.getGender();
    this.firstName = userRequest.getFirstName();
    this.secondName = userRequest.getSecondName();
    this.lastName = userRequest.getLastName();
  }
}
