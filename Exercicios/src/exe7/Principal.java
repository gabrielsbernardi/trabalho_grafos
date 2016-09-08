/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Flávio Omar Losada e Gabriel da Silva Bernardi
 */
public class Principal {
    private static int[][] matrizAdjacencia;
    private static int cidade;
    private static String rota;
    private static int maxLinhas = 0;
        
    public static void main(String[] args) {
        informarArestasPorLinha();
        informarCidade();
        System.out.println(cidadesAdjacentes(cidade));
        System.out.println(maisEntradas());
        System.out.println(estradasMaoDupla(cidade));
        System.out.println(saidasDiretaParaCidadeK(cidade));
        System.out.println(isoladasSemEntradaSemSaida());
        informarRota();
        System.out.println(isRotaValida(rota));
    }
    
    private static void informarCidade() {
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o índice de uma cidade: ");
        cidade = Integer.parseInt(ler.nextLine());
    }
    
    private static void informarRota() {
        Scanner ler = new Scanner(System.in); 
        System.out.print("Informe uma rota separada por espaços: ");
        rota = ler.nextLine();
    }
    
    private static void informarArestasPorLinha() {
        String valorLinha = "";
        int numLinha = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Separe os valores da linha por espaço. Pressione \"Enter\" para cada nova linha da matriz.");
        do {
            System.out.print("Linha " + numLinha + ": ");
            valorLinha = ler.nextLine();
            if ("".equals(valorLinha.trim())) {
                System.err.println("Valor inválido!\n");
            } else {
                processarLinha(valorLinha, numLinha);
                numLinha++;
            }
        } while (maxLinhas > numLinha);
    }
    
    private static void processarLinha(String linha, int numLinha){
        String[] valoresLinha = linha.split(" ");
        if (numLinha == 0) {
            matrizAdjacencia = new int[valoresLinha.length][valoresLinha.length];
            maxLinhas = valoresLinha.length;
        } 
        for (int i = 0; i < valoresLinha.length; i++) {
            if (isNumber(valoresLinha[i])) {
                matrizAdjacencia[numLinha][i] = Integer.parseInt(valoresLinha[i]);
            } else {
                System.err.println("Valor inválido na linha " + numLinha);
                System.exit(0);
            }
        }
    }
    
    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    private static String cidadesAdjacentes(int cidade) {
        int estradaSaida = 0, estradaEntrada = 0;
        for (int i = 0; i < matrizAdjacencia[cidade].length; i++) {
            estradaSaida += matrizAdjacencia[cidade][i];
        }
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            estradaEntrada += matrizAdjacencia[i][cidade];
        }
        return "Entradas: " + estradaEntrada + "\nSaídas: " + estradaSaida;
    }
    
    private static String maisEntradas() {
        int[] colunas = new int[matrizAdjacencia.length];
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                colunas[j] += matrizAdjacencia[i][j];
            }           
        }
        int cidadeMaisEntrada = 0;
        for (int i = 1; i < colunas.length; i++) {
            if (colunas[cidadeMaisEntrada] < colunas[i]) {
                cidadeMaisEntrada = i;
            }
        }
        return "Cidade com mais entradas: " + cidadeMaisEntrada;
    }
    
    private static String estradasMaoDupla(int cidade) {
        ArrayList<Integer> cidadesAdjacentes = new ArrayList<Integer>();
        int cidadeSemMaoDupla = -1;
        for (int j = 0; j < matrizAdjacencia[cidade].length; j++) {
            if (matrizAdjacencia[cidade][j] > 0) {
                cidadesAdjacentes.add(j);
            }
        }
        for (Integer cidadeAdjacente : cidadesAdjacentes) {
            if (matrizAdjacencia[cidadeAdjacente][cidade] <= 0) {
                cidadeSemMaoDupla = cidadeAdjacente;
                break;
            }
        }
        return cidadeSemMaoDupla == -1 ? "Todas as ligações da cidade " + cidade + " são de mão dupla." : 
                               "A cidade " + cidadeSemMaoDupla + " não possui ligação de mão dupla com a cidade " + cidade;
    }
    
    private static String saidasDiretaParaCidadeK(int cidade) {
        String listaCidades = "";
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (matrizAdjacencia[i][cidade] > 0) {
                listaCidades += i + ", ";
            }
        }
        if (!"".equals(listaCidades)) {
            listaCidades = listaCidades.substring(0, listaCidades.length()-2);
        }
        return "Lista de cidades que possuem saídas diretas para a cidade " + cidade + ": " + listaCidades;
    }
    
    private static String isoladasSemEntradaSemSaida(){
        int[] saidas = new int[matrizAdjacencia.length];
        int[] entradas = new int[matrizAdjacencia.length];
        String cidadesIsoladas = "";
        String cidadesSemSaida = "";
        String cidadesSemEntrada = "";
        
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                saidas[i] += matrizAdjacencia[i][j];
                entradas[j] += matrizAdjacencia[i][j];
            }           
        }
        
        for (int i = 0; i < saidas.length; i++) {
            if (saidas[i] == 0 && entradas[i] == 0){
                cidadesIsoladas += i + ", ";
            }
            if (saidas[i] == 0 && entradas[i] > 0){
                cidadesSemSaida += i + ", ";
            }
            if (saidas[i] > 0 && entradas[i] == 0){
                cidadesSemEntrada += i + ", ";
            }
        }
        if (!"".equals(cidadesIsoladas)) {
            cidadesIsoladas = cidadesIsoladas.substring(0, cidadesIsoladas.length()-2);
        }
        if (!"".equals(cidadesSemSaida)) {
            cidadesSemSaida = cidadesSemSaida.substring(0, cidadesSemSaida.length()-2);
        }
        if (!"".equals(cidadesSemEntrada)) {
            cidadesSemEntrada = cidadesSemEntrada.substring(0, cidadesSemEntrada.length()-2);
        }
        
        return "Cidades isoladas: " + cidadesIsoladas
               + "\nCidades sem saída: " + cidadesSemSaida 
               + "\nCidades sem entrada: " + cidadesSemEntrada;
    }
    
    private static String isRotaValida(String rota) {
        String[] roteiro = rota.split(" ");
        for (int i = 0; i < roteiro.length-1; i++) {
            if (matrizAdjacencia[Integer.parseInt(roteiro[i])][Integer.parseInt(roteiro[i+1])] <= 0) {
                return "Não é possível realizar a rota informada: " + rota;
            }
        }
        return "A rota informada foi realizada com sucesso.";
    }
}
