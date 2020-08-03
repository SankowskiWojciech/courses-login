package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.relations.OrganizationStudentRelationEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.relations.OrganizationStudentRelationEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationStudentRelationRepository extends JpaRepository<OrganizationStudentRelationEntity, OrganizationStudentRelationEntityId> {
}
