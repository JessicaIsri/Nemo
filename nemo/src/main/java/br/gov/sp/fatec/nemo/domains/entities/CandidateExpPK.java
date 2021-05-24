package br.gov.sp.fatec.nemo.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateExpPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "fk_can_id")
    private Long candidateId;

    @Column(name = "fk_company_id")
    private Long companyId;

    @Column(name = "fk_post_id")
    private Long postId;

}