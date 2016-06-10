package br.com.cwi.aula4.entity;

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
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    private Long idUsuario;
    
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;
}
