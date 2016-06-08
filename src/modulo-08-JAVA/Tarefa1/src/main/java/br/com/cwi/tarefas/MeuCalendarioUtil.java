package br.com.cwi.tarefas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Vinicius Ambrosi
 */
public class MeuCalendarioUtil {
    
    public static String diaDeNascimento (Date data)
    {
        if(data == null)
            return "";
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        String dia = "";
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
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
        return dia;
    }
    
    public static String tempoDecorridoDesde(Date data)
    {
        if(data == null)
            return "";
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        int mesDataAntiga = c.get(Calendar.MONTH);
        int anoDataAntiga = c.get(Calendar.YEAR);
        int diaDataAntiga = c.get(Calendar.DATE);
        
        Date dataHoje = new Date();
        c.setTime(dataHoje);
        int mesDataHoje = c.get(Calendar.MONTH);
        int anoDataHoje = c.get(Calendar.YEAR);
        int diaDataHoje = c.get(Calendar.DATE);
        
        int difAno = anoDataHoje - anoDataAntiga;
        
        int auxDifMes = (mesDataHoje - mesDataAntiga);
        int difMes;
        if(auxDifMes < 0)
        {
            difAno--;
            difMes = 12 + auxDifMes;
        }
        else
            difMes = auxDifMes;
        
        int auxDifDia = (diaDataHoje - diaDataAntiga);
        int difDia;
        if(auxDifDia < 0)
        {
            c.set(difAno, difMes - 1, 1);
            int diaMaximoDaDif = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            difDia = diaMaximoDaDif + auxDifDia;
            difMes--;
        }
        else 
            difDia = auxDifDia;
            
        return String.format("%d ano(s), %d mes(es) e %d dia(s)", difAno, difMes, difDia);
    }
    
    public static void main(String[] args) {
        System.out.println("Escolha uma das seguintes operações.");
        System.out.println("1 - Ver dia da semana de determinada data; \n"
                         + "2 - Diferença de data com data corrente. \n");
        boolean inputErrado = true;
        try (final Scanner scanner = new Scanner(System.in)) {
            while(inputErrado)
            {
                String input = scanner.nextLine();
                String inputDateFormat = "dd/MM/yyyy";
                Date dataRecebida;
                switch(input)
                {
                    case "1":
                        System.out.println("Digite uma data para executar função! Ex: 12/12/1212");
                        dataRecebida  = new SimpleDateFormat(inputDateFormat).parse(scanner.nextLine());
                        System.out.println(diaDeNascimento(dataRecebida));
                        inputErrado = false;
                        break;
                    case "2":
                        System.out.println("Digite uma data para executar função! Ex: 12/12/1212");
                        dataRecebida  = new SimpleDateFormat(inputDateFormat).parse(scanner.nextLine());
                        System.out.println(tempoDecorridoDesde(dataRecebida));
                        inputErrado = false;
                        break;
                    default:
                        System.out.println("Opção inserida inválido, tente novamente.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Data inserida foi inválida!");
            e.printStackTrace();
        }
    }
}
