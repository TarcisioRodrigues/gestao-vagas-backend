package gestao_vagas.backend.modules.candidate.services;

import gestao_vagas.backend.exceptions.UserFoundException;
import gestao_vagas.backend.modules.candidate.dto.CandidateProfileDTO;
import gestao_vagas.backend.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateProfileDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserFoundException ("User not found");
        });

        var candidateDTO = CandidateProfileDTO.builder()
                .description(candidate.getDescription())
                .id(candidate.getId())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .username(candidate.getUsername())
                .build();

        return candidateDTO;
    }

}
