package com.github.sankowskiwojciech.courseslogin.model.db.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TOKEN")
@EqualsAndHashCode
public class TokenEntity {

    @Id
    @Column(name = "ID", nullable = false, unique = true, updatable = false)
    private String id;

    @Setter
    @Column(name = "TOKEN_VALUE", length = 512, nullable = false, unique = true, updatable = false)
    private String tokenValue;

    @Column(name = "EMAIL_ADDRESS", length = 80, nullable = false, updatable = false)
    private String emailAddress;

    @Column(name = "RSA_PUBLIC_KEY", nullable = false, unique = true, updatable = false)
    private String rsaPublicKey;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "EXPIRATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime expirationDateTime;

    @Column(name = "IS_REVOKED", nullable = false)
    private boolean isRevoked;

    @Column(name = "REVOCATION_DATE_TIME")
    private LocalDateTime revocationDateTime;
}