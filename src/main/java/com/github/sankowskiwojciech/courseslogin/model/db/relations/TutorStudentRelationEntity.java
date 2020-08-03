package com.github.sankowskiwojciech.courseslogin.model.db.relations;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(TutorStudentRelationEntityId.class)
@Table(name = "TUTOR_STUDENT_RELATION")
@EqualsAndHashCode
public class TutorStudentRelationEntity {
    @Id
    private long tutorId;

    @Id
    private long studentId;
}
