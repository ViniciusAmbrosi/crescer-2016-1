package br.com.cwi.tarefas;

import java.util.Scanner;

/**
 * @author Vinicius Ambrosi
 */
public class MeuStringUtil {
    public static boolean isEmpty(String palavra)
    {
        if(palavra == null)
            return true;
        return palavra.trim().length() == 0;
    }
    public static int contarVogais(String palavra)
    {
        if(isEmpty(palavra))
            return 0;
        String[] letras = letras = palavra.split("");
        String[] vowels = {"a","e","i","o","u"};
        int contadorVogais = 0;
        for(String letra : letras)
        {
            if(letra.equals(vowels[0]) || 
               letra.equals(vowels[1]) || letra.equals(vowels[2]) || 
               letra.equals(vowels[3]) || letra.equals(vowels[4]))
            {   
                contadorVogais++;
            }
        }
        return contadorVogais;
    }
    public static String inverterString (String palavra) 
    {
        if(isEmpty(palavra))
            return "";
        String[] letras = palavra.split("");
        int ultimoValor = letras.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <= ultimoValor; i++)
        {
            stringBuilder.append(letras[ultimoValor - i]);
        }
        return stringBuilder.toString();
    }
    public static boolean isPalindromo (String palavra)
    {
        if(isEmpty(palavra))
            return false;
        String[] letras = palavra.split("");
        int ultimoValor = letras.length - 1;
        for(int i = 0; i <= ultimoValor; i++)
        {
            if(letras[i].equals(letras[ultimoValor - i]))
                continue;
            else
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Escolha uma das seguintes operações.");
        System.out.println("1 - Verificar se string é vazia; \n"
                         + "2 - Contar vogais de uma palavra; \n"
                         + "3 - Inverter uma string;  \n"
                         + "4 - Verificar se palavra é palíndromo.");
        boolean inputErrado = true;
        try (final Scanner scanner = new Scanner(System.in)) {
            while(inputErrado)
            {
                String input = scanner.nextLine();
                String retorno = "";
                String palavraRecebida = "";
                switch(input)
                {
                    case "1":
                        System.out.println("Digite uma palavra para executar função!");
                        palavraRecebida  = scanner.nextLine();
                        retorno = isEmpty(palavraRecebida) ? "String é vazia." : "String não é vazia.";
                        System.out.println(retorno);
                        inputErrado = false;
                        break;
                    case "2":
                        System.out.println("Digite uma palavra para executar função!");
                        palavraRecebida  = scanner.nextLine();
                        System.out.println(contarVogais(palavraRecebida));
                        inputErrado = false;
                        break;
                    case "3":
                        System.out.println("Digite uma palavra para executar função!");
                        palavraRecebida  = scanner.nextLine();
                        System.out.println(inverterString(palavraRecebida));
                        inputErrado = false;
                        break;
                    case "4":
                        System.out.println("Digite uma palavra para executar função!");
                        palavraRecebida  = scanner.nextLine();
                        retorno = isPalindromo(palavraRecebida) ? "Palavra é um palíndromo." : "Palavra não é um palíndromo.";
                        System.out.println(retorno);
                        inputErrado = false;
                        break;
                    default:
                        System.out.println("Opção inserida inválido, tente novamente.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
