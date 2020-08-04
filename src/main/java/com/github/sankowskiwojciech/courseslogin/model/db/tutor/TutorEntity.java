package com.github.sankowskiwojciech.courseslogin.model.db.tutor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TUTOR")
@EqualsAndHashCode
public class TutorEntity {

    @Id
    @Column(name = "EMAIL_ADDRESS", length = 50, unique = true, nullable = false, updatable = false)
    private String emailAddress;

    @Column(name = "ALIAS", length = 20, unique = true, nullable = false, updatable = false)
    private String alias;

    @Column(name = "FIRST_NAME", length = 15, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "PHONE_NUMBER", length = 9)
    private String phoneNumber;
}
