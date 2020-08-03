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
@IdClass(OrganizationTutorRelationEntityId.class)
@Table(name = "ORGANIZATION_TUTOR_RELATION")
@EqualsAndHashCode
public class OrganizationTutorRelationEntity {

    @Id
    private long organizationId;

    @Id
    private long tutorId;
}
