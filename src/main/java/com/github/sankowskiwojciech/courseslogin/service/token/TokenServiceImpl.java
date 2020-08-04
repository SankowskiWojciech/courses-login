package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.service.token.transformer.LoginCredentialsEntityAndRsaPublicKeyToTokenEntity;
import com.github.sankowskiwojciech.courseslogin.service.token.transformer.TokenEntityAndPrivateKeyToToken;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.KeyPair;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    public Token generateToken(LoginCredentialsEntity loginCredentialsEntity) {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES512);
        TokenEntity tokenEntity = LoginCredentialsEntityAndRsaPublicKeyToTokenEntity.getInstance().apply(loginCredentialsEntity, keyPair.getPublic().getEncoded());
        Token token = TokenEntityAndPrivateKeyToToken.getInstance().apply(tokenEntity, keyPair.getPrivate());
        tokenEntity.setTokenValue(token.getTokenValue());
        tokenRepository.save(tokenEntity);
        return token;
    }
}
