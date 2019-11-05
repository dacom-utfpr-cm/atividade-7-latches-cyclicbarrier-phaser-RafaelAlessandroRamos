/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade4;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {
        double[] vetor = new double[]{1, 65, 65, 1};
        OneDimencionalStencilPhaser oneDimencionalStencilPhaser = new OneDimencionalStencilPhaser(vetor, 5000);
        oneDimencionalStencilPhaser.start();

        try {
            oneDimencionalStencilPhaser.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(vetor));
    }
}
