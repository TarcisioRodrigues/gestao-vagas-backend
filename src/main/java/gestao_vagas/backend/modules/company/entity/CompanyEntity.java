package gestao_vagas.backend.modules.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço!")
    private String username;
    @Email(message = "O campo email deve conter um e-mail válido")
    private String email;
    @Length(min = 10, max = 100)
    private String password;
    private String website;
    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
