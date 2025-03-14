package gestao_vagas.backend.modules.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateProfileDTO {

    private String description;
    private String username;
    private String name;
    private String email;
    private UUID id;
}
