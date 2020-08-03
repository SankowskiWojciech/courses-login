package com.github.sankowskiwojciech.courseslogin.model.db.relations;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TutorStudentRelationEntityId implements Serializable {
    private long tutorId;
    private long studentId;
}
