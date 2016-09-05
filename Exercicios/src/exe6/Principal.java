/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe6;

import java.util.Scanner;

/**
 *
 * @author Flávio Omar Losada e Gabriel da Silva Bernardi
 */
public class Principal {
    private static Scanner ler = new Scanner(System.in);
    private static ValidarGrafo vg;
    
    public static void main(String[] args) {
        System.out.print("Informe a ordem do grafo: ");
        int ordem = ler.nextInt();
        vg = new ValidarGrafo(new int[ordem][ordem]);
        informarArestas();
    }

    private static void informarArestas() {
        
    }
}
