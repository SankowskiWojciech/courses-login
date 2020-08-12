package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.subdomainuseraccess.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.subdomainuseraccess.SubdomainUserAccessEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdomainUserAccessRepository extends JpaRepository<SubdomainUserAccessEntity, SubdomainUserAccessEntityId> {
}
