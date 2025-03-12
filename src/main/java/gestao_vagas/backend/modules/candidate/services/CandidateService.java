package gestao_vagas.backend.modules.candidate.services;

import gestao_vagas.backend.exceptions.UserFoundException;
import gestao_vagas.backend.modules.candidate.Entity.CandidateEntity;
import gestao_vagas.backend.modules.candidate.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });


        return this.candidateRepository.save((candidateEntity));
    }
}
