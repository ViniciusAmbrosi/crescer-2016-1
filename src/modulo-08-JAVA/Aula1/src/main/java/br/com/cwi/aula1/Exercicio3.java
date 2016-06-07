package br.com.cwi.aula1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author vinicius.ambrosi
 */
public class Exercicio3 {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Data de Hoje: ").append(dateFormat.format(date));
        System.out.println(stringBuffer);
        
        System.out.println("Digite sua data de nascimento: (dd/mm/yyyy)");
        try (final Scanner scanner = new Scanner(System.in)) {
            String inputDateFormat = "dd/MM/yyyy";
            Date dataRecebida = null;
            dataRecebida = new SimpleDateFormat(inputDateFormat).parse(scanner.nextLine());
            Calendar c = Calendar.getInstance();
            c.setTime(dataRecebida);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String dia = "";
            switch(dayOfWeek)
            {
                case 1:
                    dia = "Domingo";
                    break;
                case 2:
                    dia = "Segunda";
                    break;
                case 3:
                    dia = "Terça";
                    break;
                case 4:
                    dia = "Quarta";
                    break;
                case 5:
                    dia = "Quinta";
                    break;
                case 6:
                    dia = "Sexta";
                    break;
                case 7:    
                    dia = "Sábado";
                    break;
            }
            System.out.println(dia);
        } catch (Exception e) {
            System.out.println("Data inserida foi inválida!");
        }
    }
}
