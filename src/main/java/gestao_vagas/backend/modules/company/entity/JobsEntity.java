package gestao_vagas.backend.modules.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity(name = "jobs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descrpiton;
    @NotBlank(message = "Esse campo é obrigatório")
    private String level;
    private String benefits;

    @ManyToOne
    @JoinColumn(name = "company_id",insertable = false ,updatable = false)
    private CompanyEntity company;
    @Column(name="company_id",nullable = false)
    private UUID companyId;




}
