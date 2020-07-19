package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;
import com.github.sankowskiwojciech.courseslogin.service.token.transformer.EmailAddressAndRsaPublicKeyToTokenEntity;
import com.github.sankowskiwojciech.courseslogin.service.token.transformer.TokenEntityAndPrivateKeyToJwsToken;
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
    public JwsToken generateJwsToken(String emailAddress) {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES512);
        TokenEntity tokenEntity = EmailAddressAndRsaPublicKeyToTokenEntity.getInstance().apply(emailAddress, keyPair.getPublic().getEncoded());
        JwsToken jwsToken = TokenEntityAndPrivateKeyToJwsToken.getInstance().apply(tokenEntity, keyPair.getPrivate());
        tokenEntity.setTokenValue(jwsToken.getToken());
        tokenRepository.save(tokenEntity);
        return jwsToken;
    }
}
