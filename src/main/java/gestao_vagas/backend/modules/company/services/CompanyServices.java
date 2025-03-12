package gestao_vagas.backend.modules.company.services;

import gestao_vagas.backend.exceptions.UserFoundException;
import gestao_vagas.backend.modules.company.entity.CompanyEntity;
import gestao_vagas.backend.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyServices {
    @Autowired
    CompanyRepository companyRepository;
    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });


        return this.companyRepository.save((companyEntity));
    }
}
