package gestao_vagas.backend.modules.candidate.contollers;

import gestao_vagas.backend.modules.candidate.entity.CandidateEntity;
import gestao_vagas.backend.modules.candidate.services.CandidateService;
import gestao_vagas.backend.modules.candidate.services.ProfileCandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @Autowired
    private ProfileCandidateService profileCandidateService;
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = candidateService.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var idCandidate=request.getAttribute("candidate_id");
 try{
     var profile=this.profileCandidateService.execute(UUID.fromString(idCandidate.toString()));
     return ResponseEntity.ok().body(profile);
 } catch (Exception e) {
     return ResponseEntity.badRequest().body(e.getMessage());
 }
    }

}
