package br.com.crescer.repository;

import br.com.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 * @author vinicius.ambrosi
 */

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
    
}
