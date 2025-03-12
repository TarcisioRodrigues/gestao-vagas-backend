package gestao_vagas.backend.modules.company.repository;

import gestao_vagas.backend.modules.company.entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobsRepository extends JpaRepository<JobsEntity, UUID> {

}
