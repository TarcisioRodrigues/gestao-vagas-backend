package gestao_vagas.backend.modules.company.controllers;

import gestao_vagas.backend.modules.company.entity.JobsEntity;
import gestao_vagas.backend.modules.company.services.JobsServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    JobsServices jobsServices;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody JobsEntity jobsEntity) {
        try {
            var result = jobsServices.execute(jobsEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
