package br.com.cwi.tarefa4.utils;

import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.Cliente;
import br.com.tarefa4.entity.Material;
import br.com.tarefa4.entity.Pedido;
import br.com.tarefa4.entity.PedidoItem;
import br.com.tarefa4.entity.Produto;
import br.com.tarefa4.entity.ProdutoMaterial;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class CSVUtils {

    public static List<String> gerarCsvCidade(List<Cidade> cidades, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDCIDADE;NOME;UF");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (Cidade cidade : cidades) {
                bufferWriter.write(String.format("%s;%s;%s", cidade.getIdCidade().toString(),
                        cidade.getNome(), cidade.getUF()));
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> gerarCsvCliente(List<Cliente> clientes, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDCLIENTE;NOME;RAZAOSOCIAL;ENDERECO;BAIRRO;IDCIDADE;CEP;SITUACAO");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (Cliente cliente : clientes) {
                bufferWriter.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s",
                        cliente.getIdCliente().toString(), cliente.getNome(), cliente.getRazaoSocial(),
                        cliente.getEndereco(), cliente.getBairro(), cliente.getCidade().getIdCidade(),
                        cliente.getCEP(), cliente.isSituacao()));
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> gerarCsvMaterial(List<Material> materiais, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDMATERIAL;DESCRICAO;PESOLIQUIDO,PRECOCUSTO");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (Material material : materiais) {
                bufferWriter.write(String.format("%s;%s;%s;%s", material.getIdMaterial(), material.getDescricao(),
                        material.getPesoLiquido(), material.getPrecoCusto()));
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> gerarCsvPedido(List<Pedido> pedidos, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDPEDIDO;IDCLIENTE;DATAPEDIDO,DATAENTREGA;VALORPEDIDO;SITUACAO");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (Pedido pedido : pedidos) {
                bufferWriter.write(String.format("%s;%s;%s;%s;%s;%s", pedido.getIdPedido(),
                        pedido.getCliente().getIdCliente(), pedido.getDataPedido().toString(),
                        pedido.getDataEntrega().toString(), pedido.getValorPedido(), pedido.isSituacao()));

                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> gerarCsvPedidoItem(List<PedidoItem> pedidosItens, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDPEDIDOITEM;IDPEDIDO;QUANTIDADE;PRECOUNITARIO;SITUACAO;IDPRODUTO");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (PedidoItem pedidoItem : pedidosItens) {
                bufferWriter.write(String.format("%s;%s;%s;%s;%s;%s", pedidoItem.getIdPedidoItem(),
                        pedidoItem.getPedido().getIdPedido(), pedidoItem.getQuantidade(),
                        pedidoItem.getPrecoUnitario(), pedidoItem.isSituacao(), pedidoItem.getProduto().getIdProduto()));
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> gerarCsvProduto(List<Produto> produtos, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDPRODUTO;NOME;DATACADASTRO;PRECOCUSTO;PRECOVENDA;SITUACAO");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (Produto produto : produtos) {
                bufferWriter.write(String.format("%s;%s;%s;%s;%s;%s", produto.getIdProduto(),
                        produto.getNome(), produto.getDataCadatro().toString(), produto.getPrecoCusto(),
                        produto.getPrecoVenda(), produto.isSituacao()));
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> gerarCsvProdutoMaterial(List<ProdutoMaterial> produtosMateriais, String caminho) throws IOException {
        try (Writer writer = new FileWriter(caminho);
                BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("IDPRODUTOMATERIAL;IDPRODUTO;IDMATERIAL;QUANTIDADE");
            bufferWriter.newLine();
            bufferWriter.flush();
            for (ProdutoMaterial produtoMaterial : produtosMateriais) {
                bufferWriter.write(String.format("%s;%s;%s;%s", produtoMaterial.getIdProdutoMaterial(),
                        produtoMaterial.getProduto().getIdProduto(), produtoMaterial.getMaterial().getIdMaterial(),
                        produtoMaterial.getQuantidade()));
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
