package br.com.cwi.tarefa4.interfaces;

import br.com.tarefa4.entity.PedidoItem;
import java.io.IOException;
import java.util.List;

/**
 * @author Vinicius
 */
public interface IPedidoItem {

    void insert(PedidoItem pedidoItem);

    void update(PedidoItem pedidoItem);

    void delete(PedidoItem pedidoItem);

    List<PedidoItem> listAll();

    List<PedidoItem> findBySituacao(boolean situacao);
    
    void exportarCsv(String caminho) throws IOException;
}
