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
@Table(name = "MATERIAL")
public class Material implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private Long idMaterial;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO", length = 50)
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO", precision=15, scale=5)
    private double pesoLiquido;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO", precision=12, scale=2)
    private double precoCusto;

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    
}
