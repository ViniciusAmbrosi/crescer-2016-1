/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author dream
 */
public class MeuReaderUtils {
    
    public static String lerArquivo(String nome) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        if(nome.endsWith(".txt") || nome.endsWith(".sql")){
                Reader reader = null;
                BufferedReader bufferReader = null;
            try {
                reader = new FileReader(nome);
                bufferReader = new BufferedReader(reader);
                String line = null;
                while ((line = bufferReader.readLine()) != null) {
                    stringBuilder.append(line);
                    //stringBuilder.append("\n");
                }
                return stringBuilder.toString();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "Arquivo não existe!";
                
            } finally{
                try{
                    if(bufferReader != null){
                        bufferReader.close();
                    }
                    if(reader != null){
                        reader.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }   
        }
        return "Formato de aqruivo solicitado é incompatível, tente novamente.";
    }
}
