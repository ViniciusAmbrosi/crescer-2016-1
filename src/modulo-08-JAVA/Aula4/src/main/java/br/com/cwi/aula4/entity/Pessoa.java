package br.com.cwi.aula4.entity;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Pessoa")
@NamedQueries({
@NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
@NamedQuery(name = "Pessoa.findByName", query ="SELECT p FROM Pessoa p WHERE p.nmPessoa LIKE :nmPessoa")
})
public class Pessoa implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
    private Long idPessoa;

    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nmPessoa;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nmPessoa = nome;
    }

    public String getNome() {
        return nmPessoa;
    }

    public Long getId() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

}
