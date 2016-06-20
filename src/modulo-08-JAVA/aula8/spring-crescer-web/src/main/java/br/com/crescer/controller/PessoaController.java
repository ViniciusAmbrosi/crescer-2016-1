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
    public String list(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("pessoas", service.findAll());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Pessoa p, Model model) {
        p.setData(new Date());
        service.save(p);
        return list(model); //atualizar lista
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(String id) {
        service.delete(Long.parseLong(id));
    }
}
