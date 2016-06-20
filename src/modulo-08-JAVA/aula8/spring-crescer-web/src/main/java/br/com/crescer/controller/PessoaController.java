package br.com.crescer.controller;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.services.PessoaService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import oracle.net.aso.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vinicius.ambrosi
 */
@Controller
@RequestMapping("/Pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Pessoa p, Model model) {
        form(p, model);
        list(model);
        return "index";
    }

    public String form(Pessoa p, Model model){
        model.addAttribute("pessoa", p == null ? new Pessoa() : p);
        return "form-pessoa";
    }
    
    public String list(Model model) {
        model.addAttribute("pessoas", service.findAll());
        return "tabela-pessoa";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Pessoa p, Model model) {
        if(p.getData() == null) p.setData(new Date());
        service.save(p);
        return index(null, model); //atualizar lista
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(String id, Model model) {
        service.delete(Long.parseLong(id));
        return list(model); //atualizar lista
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Update")
    public String update(String id, Model model) {
        Pessoa p = service.findById(Long.parseLong(id));
        return form(p, model);
    }
}
