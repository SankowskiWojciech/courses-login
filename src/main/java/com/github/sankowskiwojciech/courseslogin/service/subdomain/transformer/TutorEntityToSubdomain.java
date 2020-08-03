package com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.SubdomainType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TutorEntityToSubdomain implements Function<TutorEntity, Subdomain> {

    private static final TutorEntityToSubdomain INSTANCE = new TutorEntityToSubdomain();

    @Override
    public Subdomain apply(TutorEntity tutorEntity) {
        return new Subdomain(tutorEntity.getTutorId(), SubdomainType.TUTOR);
    }

    public static TutorEntityToSubdomain getInstance() {
        return INSTANCE;
    }
}
