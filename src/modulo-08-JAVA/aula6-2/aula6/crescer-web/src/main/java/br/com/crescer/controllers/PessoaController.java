package br.com.crescer.controllers;

import br.com.crescer.controllers.abstracts.AbstractController;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.service.PessoaService;
import br.com.crescer.utils.FacesUtils;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class PessoaController extends AbstractController<Pessoa, PessoaService> {

    @EJB
    private PessoaService pessoaService;

    @Override
    public PessoaService getService() {
        return pessoaService;
    }

    @PostConstruct
    public void init() {
        this.setEntity(new Pessoa());
        this.listAll();
    }

    public String save() {
        super.saveOrUpdate();
        FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro incluido com sucesso!", ""));
        return "consultar_pessoa";
    }

    public String delete() {
        super.remove();
        FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro removido com sucesso!", ""));
        return "consultar_pessoa";
    }
}
