package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.relations.OrganizationTutorRelationEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.relations.OrganizationTutorRelationEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationTutorRelationRepository extends JpaRepository<OrganizationTutorRelationEntity, OrganizationTutorRelationEntityId> {
}
