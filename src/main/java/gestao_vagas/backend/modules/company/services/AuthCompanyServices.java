package gestao_vagas.backend.modules.company.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import gestao_vagas.backend.modules.company.dto.AuthCompanyDTO;
import gestao_vagas.backend.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyServices {
    @Value("${security.token.secret}")
    private String secretkey;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company=this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(()->{
            throw new UsernameNotFoundException("Company not found");
        });

        var passwordMatches=this.passwordEncoder.matches(authCompanyDTO.getPassword(),company.getPassword());

        if(!passwordMatches){
           throw new AuthenticationException();
        }
        Algorithm algorithm=Algorithm.HMAC256(secretkey );
        var token=  JWT.create().withIssuer("javagas").withSubject(company.getId().toString()).sign(algorithm);
        return  token;
    }
}
