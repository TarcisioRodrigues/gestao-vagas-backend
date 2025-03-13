package gestao_vagas.backend.modules.company.repository;

import gestao_vagas.backend.modules.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
    Optional<CompanyEntity> findByUsername(String username);

}
