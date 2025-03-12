package gestao_vagas.backend.modules.candidate.Repository;

import gestao_vagas.backend.modules.candidate.Entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

}
