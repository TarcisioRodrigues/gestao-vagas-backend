package gestao_vagas.backend.modules.company.controllers;

import gestao_vagas.backend.modules.company.dto.AuthCompanyDTO;
import gestao_vagas.backend.modules.company.services.AuthCompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {
@Autowired
private AuthCompanyServices authCompanyServices;
    @PostMapping("/company")
    public ResponseEntity<Object > create(@RequestBody AuthCompanyDTO authCompanyDTO)  {
        try {
            var result= this.authCompanyServices.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }


    }
}

