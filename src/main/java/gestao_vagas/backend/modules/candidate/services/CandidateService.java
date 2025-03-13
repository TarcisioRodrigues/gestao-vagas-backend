package gestao_vagas.backend.modules.candidate.services;

import gestao_vagas.backend.exceptions.UserFoundException;
import gestao_vagas.backend.modules.candidate.entity.CandidateEntity;
import gestao_vagas.backend.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });
        var password =passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);


        return this.candidateRepository.save((candidateEntity));
    }
}
