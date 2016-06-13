package br.com.tarefa4.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Vinicius
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCLIENTE")
    @SequenceGenerator(name = "SQCLIENTE", sequenceName = "SQCLIENTE", allocationSize = 1)
    private Long idCliente;

    @Basic(optional = false)
    @Column(name = "NOME", length = 50)
    private String nome;

    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL", length = 50)
    private String razaoSocial;

    @Basic(optional = true)
    @Column(name = "ENDERECO", length = 35)
    private String endereco;

    @Basic(optional = true)
    @Column(name = "BAIRRO", length = 30)
    private String bairro;

    @Basic(optional = true)
    @ManyToOne(optional = true)
    @JoinColumn(name = "IDCIDADE")
    private Cidade cidade;

    @Basic(optional = true)
    @Column(name = "CEP", precision=8, scale=0)
    private int CEP;

    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private boolean situacao;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    
}
