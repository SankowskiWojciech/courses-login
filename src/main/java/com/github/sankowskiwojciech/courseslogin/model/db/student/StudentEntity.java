package com.github.sankowskiwojciech.courseslogin.model.db.student;

import com.github.sankowskiwojciech.courseslogin.model.db.parent.ParentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "STUDENT")
@EqualsAndHashCode
public class StudentEntity {

    @Id
    @Column(name = "STUDENT_ID", nullable = false, unique = true, updatable = false)
    private long studentId;

    @Column(name = "FIRST_NAME", length = 15, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", length = 50, unique = true, nullable = false, updatable = false)
    private String emailAddress;

    @Column(name = "PHONE_NUMBER", length = 9)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private ParentEntity parent;
}
