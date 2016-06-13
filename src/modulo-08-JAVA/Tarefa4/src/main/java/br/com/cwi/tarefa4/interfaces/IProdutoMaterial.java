package br.com.cwi.tarefa4.interfaces;

import br.com.tarefa4.entity.ProdutoMaterial;
import java.io.IOException;
import java.util.List;

/**
 * @author Vinicius
 */
public interface IProdutoMaterial {

    void insert(ProdutoMaterial produtoMaterial);

    void update(ProdutoMaterial produtoMaterial);

    void delete(ProdutoMaterial produtoMaterial);

    List<ProdutoMaterial> listAll();

    List<ProdutoMaterial> findByQuantidade(double quantidade, boolean maior, boolean menor);

    void exportarCsv(String caminho) throws IOException;
}
