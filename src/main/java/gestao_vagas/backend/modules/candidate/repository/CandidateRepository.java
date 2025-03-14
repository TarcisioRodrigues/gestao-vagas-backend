package gestao_vagas.backend.modules.candidate.repository;

import gestao_vagas.backend.modules.candidate.entity.CandidateEntity;
import gestao_vagas.backend.modules.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

    Optional<CandidateEntity> findByUsername(String username);
}
