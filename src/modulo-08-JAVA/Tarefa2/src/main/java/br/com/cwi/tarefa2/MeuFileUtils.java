package br.com.cwi.tarefa2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Arrays;

/**
 *
 * @author dream
 */
public class MeuFileUtils {
    
    public static boolean ehDiretorio(File file)
    {
        if (file.exists()) 
        {
            if(file.isDirectory())
            {
                return true;
            }
            return false;
        }
        return true;
    }
    
    public static void mk (String nome) throws IOException{
        File f = new File(nome);
        f.createNewFile();
    }
    
    public static String rm (String nome)
    {
        File f = new File(nome);
        if(ehDiretorio(f))
        {
            return "Arquivo inválido.";
        }
        else
        {
            f.delete();
            return "Exclusão realizada com sucesso.";
        }
    }
    
    public static String ls (String nome){
        File f = new File(nome);
        if (f.exists()) 
        {
            if(f.isDirectory())
            {
                return Arrays.toString(f.list());
            }
            return f.getAbsoluteFile().toString();
        }
        return "Não existe arquivo ou diretório com esse nome";
    }
    
    public static String mv (String nome, String nome_novo) throws IOException{
        File fileSource = new File(nome);
        if(ehDiretorio(fileSource))
        {
            return "Arquivo Inválido.";
        }
        else
        {
            //outra ideia é utilizar do rename
            //myFile.renameTo(new File("/the/new/place"));
            Files.move(Paths.get(fileSource.getAbsolutePath()), Paths.get(nome_novo), REPLACE_EXISTING);
            return "Arquivo movido com sucesso";
        }
    }
    
    private static String removerBigas(String arquivo)
    {
        if(arquivo.startsWith("$"))
        {
            arquivo = arquivo.replace("$", "");
            if(arquivo.startsWith("{"))
            {
                arquivo = arquivo.replace("{", "");
                if(arquivo.endsWith("}"))
                {
                    arquivo = arquivo.replace("}", "");
                    return arquivo;
                }
                else
                {
                    return "Os parametros do comando devem terminar com }.";
                }
            }
            else
            {
                return "Os parametros do comando devem ser precedidos de { após $.";
            }
        }
        else
        {
            return "Os parametros do comando devem ser precedidos de $.";
        }
    }
    
    private static boolean validaComando(String comando, String retorno)
    {
        if(comando.contains(retorno))
        {
            return true;
        }
        return false; 
    }
                
    public static void main(String[] args) {
        if(args.length == 0)
        {
            System.out.println("Comando inválido!");
        }
        final String comando = args[0];
        String auxiliarValidacao = removerBigas(args[1]);
        if(validaComando(args[1], auxiliarValidacao))
        {
            final String caminho = auxiliarValidacao;
            
            try{
            switch(comando)
            {
                case "mk":
                    mk(caminho);
                    break;
                case "rm":
                    System.out.println(rm(caminho));
                    break;
                case "ls":
                    System.out.println(ls(caminho));
                    break;
                case "mv":
                    String[] caminhos = caminho.split(" ");
                    System.out.println(mv(caminhos[0], caminhos[1]));
                    break;
                default:
                    System.out.println("Esse comando não existe.");
                    break;
            }
            }catch(IOException e)
            {
                System.out.println("Operação Inválida.");
            }
        }
        else
        {
            System.out.println(auxiliarValidacao);
        }
    } 
}
