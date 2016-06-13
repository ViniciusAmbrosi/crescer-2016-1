package br.com.cwi.tarefa4.interfaces;

import br.com.tarefa4.entity.Pedido;
import java.util.List;

/**
 * @author Vinicius
 */
public interface IPedido {

    void insert(Pedido pedido);

    void update(Pedido pedido);

    void delete(Pedido pedido);

    List<Pedido> listAll();

    List<Pedido> findBySituacao(boolean situacao);
}
