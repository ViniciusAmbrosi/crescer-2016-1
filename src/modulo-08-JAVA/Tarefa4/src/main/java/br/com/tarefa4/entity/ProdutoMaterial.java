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
@Table(name = "PRODUTOMATERIAL")
public class ProdutoMaterial implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long idProdutoMaterial;

    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDMATERIAL")
    private Material material;

    @Basic(optional = true)
    @Column(name = "QUANTIDADE", precision=12, scale=3)
    private double quantidade;

    public Long getIdProdutoMaterial() {
        return idProdutoMaterial;
    }

    public void setIdProdutoMaterial(Long idProdutoMaterial) {
        this.idProdutoMaterial = idProdutoMaterial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
