package br.com.crescer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PESSOA")
    @SequenceGenerator(name="SEQ_PESSOA", sequenceName="SEQ_PESSOA", allocationSize=1)
    @Basic(optional= false)
    @Column(name="ID_PESSOA")
    private Long id;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name="DT_NASCIMENTO_PESSOA")
    private Date data;
    
    @Basic(optional=false)
    @Column(name="NM_PESSOA")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }
}


