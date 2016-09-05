/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe6;

/**
 *
 * @author Flávio Omar Losada e Gabriel da Silva Bernardi
 */
public class ValidarGrafo {
    private int[][] grafo;
    
    public ValidarGrafo(int[][] grafo) {
        this.grafo = grafo;
    } 
    
    /**
     * 
     * @return String contendo o tipo do grafo
     */
    public String tipoDoGrafo(){
        StringBuilder retorno = new StringBuilder();
        retorno.append("O grafo informado contém as seguinte caracteríticas: ")
        .append(this.isDirigido())
        .append(", ")
        .append(this.isSimples())
        .append(", ")
        .append(this.isRegular())
        .append(", ")
        .append(this.isCompleto())
        .append(" e ")
        .append(this.isNulo())
        .append(".");
        return retorno.toString();
    }
    
    private String isDirigido(){
        return "";
    }
    
    private String isSimples(){
        return "";
    }
    
    private String isRegular(){
        return "";
    }
    
    private String isCompleto(){
        return "";
    }
    private String isNulo(){
        return "";
    }
    
    /**
     * 
     * @return String com a quantidade e o conjunto de arestas
     */
    public String arestasDoGrafo(){
        return "";
    }
    
    /**
     * 
     * @return String identificando o grau de cada vértice e por fim, a sequência de graus
     */
    public String grausDoVertice(){
        return "";
    }
    
    private void percorrerGrafo(){
        for (int linha = 0; linha < grafo.length; linha++) {
            for (int coluna = 0; coluna < grafo.length; coluna++) {
//                int[] is = grafo[coluna];
            }
//            int[] is = grafo[linha];
        }
    }
}
