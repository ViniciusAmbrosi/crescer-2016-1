package br.com.crescer;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author vinicius.ambrosi
 */
@ManagedBean(name = "pessoa")
@ViewScoped
public class PessoaMB implements Serializable {

    private Pessoa pessoa;

    @PostConstruct
    public void init() {
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void processa(Pessoa pessoa) {
        Singleton.getINSTANCE().getList().add(pessoa);
    }

    public List<Pessoa> getList() {
        return Singleton.getINSTANCE().getList();
    }

}
