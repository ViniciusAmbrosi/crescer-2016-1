package br.com.cwi.tarefa4.interfaces;

import java.util.List;
import br.com.tarefa4.entity.Cidade;
import java.io.IOException;

/**
 * @author Vinicius
 */
public interface ICidade {
    void insert(Cidade cidade);

    void update(Cidade cidade);

    void delete(Cidade cidade);

    List<Cidade> listAll();

    List<Cidade> findNome(String nome);
    
    void exportarCsv(String caminho) throws IOException;
}
