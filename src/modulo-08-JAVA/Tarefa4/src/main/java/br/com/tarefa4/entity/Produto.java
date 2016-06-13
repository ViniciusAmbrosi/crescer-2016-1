package br.com.tarefa4.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vinicius
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private Long idProduto;

    @Basic(optional = false)
    @Column(name = "NOME", length = 50)
    private String nome;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATACADASTRO")
    private Date dataCadatro;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO", precision=12, scale=2)
    private double precoCusto;

    @Basic(optional = true)
    @Column(name = "PRECOVENDA", precision=12, scale=2)
    private double precoVenda;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private boolean situacao;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadatro() {
        return dataCadatro;
    }

    public void setDataCadatro(Date dataCadatro) {
        this.dataCadatro = dataCadatro;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    
}
