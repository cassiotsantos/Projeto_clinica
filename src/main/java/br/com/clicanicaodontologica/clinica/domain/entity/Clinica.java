package br.com.clicanicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name= "clinicas")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany
    @JoinTable(
            name = "clinicaDentistas",
            joinColumns = @JoinColumn(name = "id_dentista"),
            inverseJoinColumns = @JoinColumn(name = "id_clinica"),
            foreignKey =
            @ForeignKey(name = "fk_clinica_dentista"))
    private Set<Dentista> clinicaDentista;
    private String name;
    @Column(length = 20)
    private String cnpj;
    private String razaoSocial;
    private Instant criadoEm;
    private String descricao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_endereco",
                referencedColumnName = "id",
                foreignKey =
                @ForeignKey(name ="fk_endereco_clinica"))
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato" ,
                referencedColumnName = "id",
                foreignKey =
                @ForeignKey(name = "fk_contato_clinica"))
    private Contato contato;

}
