package br.com.cwi.tarefa4.interfaces;

import br.com.tarefa4.entity.Material;
import java.util.List;

/**
 * @author Vinicius
 */
public interface IMaterial {

    void insert(Material material);

    void update(Material material);

    void delete(Material material);

    List<Material> listAll();

    List<Material> findDescricao(String descricao);
}
