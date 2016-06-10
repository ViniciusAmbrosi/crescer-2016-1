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
 *
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "AMIGO")
public class Amigo implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_AMIZADE")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIGO")
    @SequenceGenerator(name = "SEQ_AMIGO", sequenceName = "SEQ_AMIGO", allocationSize = 1)
    private Long idAmizade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO1")
    @Basic(optional = false)
    private Usuario usuario1;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO2")
    @Basic(optional = false)
    private Usuario usuario2;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIO_AMIZADE")
    private Date dataInicioAmizade;
}
