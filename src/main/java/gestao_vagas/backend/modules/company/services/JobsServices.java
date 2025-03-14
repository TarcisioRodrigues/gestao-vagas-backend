package gestao_vagas.backend.modules.company.services;

import gestao_vagas.backend.modules.company.dto.CreateJobDTO;
import gestao_vagas.backend.modules.company.entity.JobsEntity;
import gestao_vagas.backend.modules.company.repository.JobsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobsServices {

    @Autowired
    JobsRepository jobsRepository;

    public JobsEntity execute(JobsEntity jobEntity) {


        return this.jobsRepository.save((jobEntity));
    }


}
