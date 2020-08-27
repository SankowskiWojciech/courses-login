package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.TokenResponse;
import com.github.sankowskiwojciech.courseslogin.service.token.transformer.LoginCredentialsEntityAndRsaPublicKeyToTokenEntity;
import com.github.sankowskiwojciech.courseslogin.service.token.transformer.TokenEntityAndPrivateKeyToTokenResponse;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.KeyPair;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Transactional
    @Override
    public TokenResponse generateToken(LoginCredentialsEntity loginCredentialsEntity) {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES512);
        TokenEntity tokenEntity = LoginCredentialsEntityAndRsaPublicKeyToTokenEntity.getInstance().apply(loginCredentialsEntity, keyPair.getPublic().getEncoded());
        TokenResponse tokenResponse = TokenEntityAndPrivateKeyToTokenResponse.getInstance().apply(tokenEntity, keyPair.getPrivate());
        tokenEntity.setTokenValue(tokenResponse.getTokenValue());
        tokenRepository.save(tokenEntity);
        return tokenResponse;
    }
}
