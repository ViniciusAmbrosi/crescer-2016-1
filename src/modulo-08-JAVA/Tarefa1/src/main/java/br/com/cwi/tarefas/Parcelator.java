/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefas;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author dream
 */
public class Parcelator {
    
    public static String obterParcelas(double valor, double taxaJuros, int qtdParcelas, Date primeiroVencimento)
    {
        if(valor <= 0 || taxaJuros < 0 || qtdParcelas < 0 || primeiroVencimento == null)
            return null;
        double juros = valor * (taxaJuros / 100);
        double valorPorParcela = (valor + juros) / qtdParcelas;
        StringBuilder stringBuilder = new StringBuilder();
        Locale locale = new Locale("pt", "BR");      
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String valorParcelaFormatado = currencyFormatter.format(valorPorParcela);
        
        Date dataParcela = primeiroVencimento;
        Calendar c = Calendar.getInstance();
        c.setTime(dataParcela);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        for (int i = 0; i < qtdParcelas; i++) 
        {
            String dataProximaParcela = formatter.format(c.getTime());
            c.add(Calendar.MONTH, 1);
            stringBuilder.append(String.format(("%s - %s \n"), dataProximaParcela, valorParcelaFormatado));
        }
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("08/12/2016");
        System.out.println(obterParcelas(2000, 10, 5, d));
        }catch(Exception e){System.out.println("Jabu");}
    }
}
