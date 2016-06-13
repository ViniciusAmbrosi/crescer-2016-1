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
@Table(name = "PEDIDOITEM")
public class PedidoItem implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDOITEM")
    @SequenceGenerator(name = "SQPEDIDOITEM", sequenceName = "SQPEDIDOITEM", allocationSize = 1)
    private Long idPedidoItem;

    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;

    @Basic(optional = false)
    @Column(name = "QUANTIDADE", precision=12, scale=3)
    private double quantidade;

    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO", precision=12, scale=2)
    private double precoUnitario;

    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private boolean situacao;

    @Basic(optional = true)
    @ManyToOne(optional = true)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    public Long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(Long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
