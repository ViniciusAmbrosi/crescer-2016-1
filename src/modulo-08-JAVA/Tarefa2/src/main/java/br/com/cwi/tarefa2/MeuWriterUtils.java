/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author dream
 */
public class MeuWriterUtils {
    
    public static String escreverNoArquivo(String nome, List<String> conteudo) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        if(nome.endsWith(".txt")){
                Writer writer = null;
                BufferedWriter bufferWriter = null;
            try {
                writer = new FileWriter(nome);
                bufferWriter = new BufferedWriter(writer);
                for(String line : conteudo){
                    bufferWriter.write(line);
                    bufferWriter.newLine();
                    bufferWriter.flush();
                    stringBuilder.append(line);
                    stringBuilder.append("/n");
                }
                return stringBuilder.toString();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "Arquivo não existe!";
                
            } finally{
                try{
                    if(bufferWriter != null){
                        bufferWriter.close();
                    }
                    if(writer != null){
                        writer.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }   
        }
        return "Formato de aqruivo solicitado é incompatível, tente novamente.";
    }
}

