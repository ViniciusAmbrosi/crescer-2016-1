package br.com.tarefa4.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Vinicius
 */
@Entity
@Table(name = "CIDADE")
public class Cidade implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCIDADE")
    @SequenceGenerator(name = "SQCIDADE", sequenceName = "SQCIDADE", allocationSize = 1)
    private Long idCidade;

    @Basic(optional = false)
    @Column(name = "NOME", length = 30)
    private String nome;

    @Basic(optional = false)
    @Column(name = "UF", length = 2)
    private String UF;

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
