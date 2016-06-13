package br.com.cwi.tarefa4.interfaces;

import br.com.tarefa4.entity.Cliente;
import java.io.IOException;
import java.util.List;

/**
 * @author Vinicius
 */
public interface ICliente {

    void insert(Cliente cliente);

    void update(Cliente cliente);

    void delete(Cliente cliente);

    List<Cliente> listAll();

    List<Cliente> findNome(String nome);
    
    void exportarCsv(String caminho) throws IOException;
}
