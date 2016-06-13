package br.com.tarefa4.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vinicius
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDO")
    @SequenceGenerator(name = "SQPEDIDO", sequenceName = "SQPEDIDO", allocationSize = 1)
    private Long idPedido;

    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATAPEDIDO")
    private Date dataPedido;

    @Basic(optional = true)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATAENTREGA")
    private Date dataEntrega;

    @Basic(optional = false)
    @Column(name = "VALORPEDIDO", precision=12, scale=2)
    private double valorPedido;

    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private boolean situacao;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    
}
