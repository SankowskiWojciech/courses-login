package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.relations.TutorStudentRelationEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.relations.TutorStudentRelationEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorStudentRelationRepository extends JpaRepository<TutorStudentRelationEntity, TutorStudentRelationEntityId> {
}
