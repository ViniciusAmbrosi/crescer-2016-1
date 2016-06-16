package br.com.crescer.controllers;

import br.com.crescer.controllers.abstracts.AbstractController;
import br.com.crescer.entity.Cidade;
import br.com.crescer.service.CidadeService;
import br.com.crescer.utils.FacesUtils;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author vinicius.ambrosi
 */
@ManagedBean
@ViewScoped
public class CidadeController extends AbstractController<Cidade, CidadeService> {
    
    @EJB
    private CidadeService cidadeService;

    @Override
    public CidadeService getService() {
        return cidadeService;
    }

    @PostConstruct
    public void init() {
        this.setEntity(new Cidade());
        this.listAll();
    }

    public String save() {
        super.saveOrUpdate();
        FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro incluido com sucesso!", ""));
        return "consultar_cidade";
    }

    public String delete(Long id) {
        super.remove();
        FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro removido com sucesso!", ""));
        return "consultar_cidade";
    }
}
