package gestao_vagas.backend.modules.company.controllers;

import gestao_vagas.backend.modules.candidate.dto.AuthCandidateRequestDTO;
import gestao_vagas.backend.modules.candidate.services.AuthCandidateService;
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
@RequestMapping("/candidate")
public class AuthCandidateController {
    @Autowired
    private AuthCandidateService authCandidateService;
    @PostMapping("/auth")
    public ResponseEntity<Object > create(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO)  {
        try {
            var result= this.authCandidateService.execute(authCandidateRequestDTO);
            return ResponseEntity.ok().body(result);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }


    }
}


