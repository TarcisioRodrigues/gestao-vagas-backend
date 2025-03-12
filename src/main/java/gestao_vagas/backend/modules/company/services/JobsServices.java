package gestao_vagas.backend.modules.company.services;

import gestao_vagas.backend.modules.company.entity.JobsEntity;
import gestao_vagas.backend.modules.company.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsServices {

    @Autowired
    JobsRepository jobsRepository;

    public JobsEntity execute(JobsEntity jobsEntity) {


        return this.jobsRepository.save((jobsEntity));
    }
}
