package com.github.sankowskiwojciech.courseslogin.model.db.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "USER_CREDENTIALS")
public class UserCredentialsEntity {

    @Id
    @Column(name = "EMAIL_ADDRESS", length = 48, nullable = false, unique = true, updatable = false)
    private String emailAddress;

    @Column(name = "ENCRYPTED_PASSWORD", length = 80, nullable = false)
    private String encryptedPassword;
}
