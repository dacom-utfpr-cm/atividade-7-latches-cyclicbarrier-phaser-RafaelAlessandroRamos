/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade3;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {
        double[] vetor = new double[]{1, 2, 2, 1};
        OneDimencionalStencilBarreiraCiclica oneDimencionalStencilBarreiraCiclica = new OneDimencionalStencilBarreiraCiclica(vetor, 500);
        oneDimencionalStencilBarreiraCiclica.start();

        try {
            oneDimencionalStencilBarreiraCiclica.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(vetor));
    }
}
