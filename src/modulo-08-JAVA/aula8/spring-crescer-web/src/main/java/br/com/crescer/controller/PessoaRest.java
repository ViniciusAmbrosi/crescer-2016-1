package br.com.crescer.controller;

import br.com.crescer.services.PessoaService;
import br.com.crescer.entity.Pessoa;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vinicius.ambrosi
 */
@RestController()
@RequestMapping("/rest")
public class PessoaRest {

    @Autowired
    PessoaService service;

    @RequestMapping(value = "/data")
    public Date date() {
        return new Date();
    }

    @ResponseBody
    @RequestMapping("/pessoa")
    public Iterable<Pessoa> list() {
        return service.findAll();
    }
}
