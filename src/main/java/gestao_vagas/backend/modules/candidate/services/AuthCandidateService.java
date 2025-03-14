package gestao_vagas.backend.modules.candidate.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import gestao_vagas.backend.modules.candidate.dto.AuthCandidateRequestDTO;
import gestao_vagas.backend.modules.candidate.dto.AuthCandidateResponseDTO;
import gestao_vagas.backend.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCandidateService {
    @Value("${security.token.secret}")
    private String secretkey;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateRequestDTO) throws AuthenticationException {
        var candidate = candidateRepository.findByUsername(authCandidateRequestDTO.username()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/password incorrect");
        });
        var passwordMatches = this.passwordEncoder.matches(authCandidateRequestDTO.password(), candidate.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        var expiresIn=Instant.now().plus(Duration.ofMinutes(10));
        Algorithm algorithm = Algorithm.HMAC256(secretkey);
        var token = JWT.create().withIssuer("javagas").withClaim("roles", Arrays.asList("candidate")).withExpiresAt(expiresIn).withSubject(candidate.getId().toString()).sign(algorithm);
        var authCandidateResponse = AuthCandidateResponseDTO.builder().accessToken(token).expires_in(expiresIn.toEpochMilli()).build();
        return authCandidateResponse;
    }
}
