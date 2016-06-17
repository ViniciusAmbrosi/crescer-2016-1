package br.com.crescer.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PessoaService {
    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Vinicius Ambrosi");
        p.setData(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
}

