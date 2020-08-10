package com.github.sankowskiwojciech.courseslogin.service.tokenvalidation;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidTokenException;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TokenValidationServiceImpl implements TokenValidationService {

    private final TokenRepository tokenRepository;

    @Override
    public void validateToken(TokenValidationInput tokenValidationInput) {
        TokenEntity tokenEntity = readTokenByTokenValue(tokenValidationInput.getTokenValue());
        validateIfTokenIsIssuedForProvidedUser(tokenEntity.getUserEmailAddress(), tokenValidationInput.getUserEmailAddress());
        validateIfTokenIsNotRevoked(tokenEntity.getRevocationDateTime());
        validateIfTokenIsNotExpired(tokenEntity.getExpirationDateTime());
    }

    private TokenEntity readTokenByTokenValue(String tokenValue) {
        return tokenRepository.findByTokenValue(tokenValue).orElseThrow(InvalidTokenException::new);
    }

    private void validateIfTokenIsIssuedForProvidedUser(String userEmailAddressFromToken, String providedUserEmailAddress) {
        if (!providedUserEmailAddress.equals(userEmailAddressFromToken)) {
            throw new InvalidTokenException();
        }
    }

    private void validateIfTokenIsNotRevoked(LocalDateTime revocationDateTime) {
        if (revocationDateTime != null) {
            throw new InvalidTokenException();
        }
    }

    private void validateIfTokenIsNotExpired(LocalDateTime expirationDateTime) {
        if (expirationDateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidTokenException();
        }
    }
}
