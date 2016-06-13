package br.com.cwi.tarefa4.interfaces;

import br.com.tarefa4.entity.Produto;
import java.util.List;

/**
 * @author Vinicius
 */
public interface IProduto {

    void insert(Produto produto);

    void update(Produto produto);

    void delete(Produto produto);

    List<Produto> listAll();

    List<Produto> findNome(String nome);
}
