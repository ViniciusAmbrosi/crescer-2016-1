package br.com.cwi.aula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author vinicius.ambrosi
 */
public class Chat {
    public static BufferedReader getReader(String s) throws FileNotFoundException, IOException {
        File f = new File(s);
        f.createNewFile();
        return new BufferedReader (new FileReader(f));
    }
    
    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila, true));
    }
    
    public static void main(String[] args) {
        if(args.length == 0)
        {
            args = new String[]{"//10.0.100.102/cwitmp/carloshenrique/crescer.txt","Ben Hur"};
        }    
        final String s = args[0];
        
        new Thread(new Runnable() {
            @Override
            public void run(){
                BufferedReader bufferReader = null;
                try{
                   bufferReader = Chat.getReader(s); 
                   while(true)
                   {
                       String readLine = bufferReader.readLine();
                       if(readLine != null) {
                           System.out.println(readLine);
                       }else{
                           Thread.sleep(1000l);
                       }
                   }
                }catch(Exception e){
                    
                }finally{
                    try{
                        if(bufferReader == null)
                            bufferReader.close();
                    }catch(IOException e){}
                }
            }
        }).start();
        while(true)
        {
            System.out.println("Informe um valor: ");
            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();
            if(":q!".equals(nextLine))
                break;
            BufferedWriter bufferedWriter = null;
            try{
                bufferedWriter = getWriter(args[0]);
                Date dataMensagem = new Date();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String dataMensagemFormatada = formatter.format(dataMensagem.getTime());
                String mensagem = String.format("[%s] %s: %s", 
                        dataMensagemFormatada, args[1], nextLine); //ataMensagem.toString()
                bufferedWriter.write(mensagem);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }catch(Exception e){
            }finally{
                try{
                    if(bufferedWriter != null)
                        bufferedWriter.close();
                }catch(Exception e){}
            }
        }       
    }
}
