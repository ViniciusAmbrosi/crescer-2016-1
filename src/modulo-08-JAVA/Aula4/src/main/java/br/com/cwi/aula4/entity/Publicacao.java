package br.com.cwi.aula4.entity;

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
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "PUBLICACAO")
public class Publicacao implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACAO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    private Long idPublicacao;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_PUBLICACAO")
    private Date dataPublicacao;
}
