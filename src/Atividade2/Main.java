/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade2;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {

        double[] vetor = new double[]{1, 2, 2, 1};
        CountDownLatch done = new CountDownLatch(1);
        OneDimencionalStencilLatch oneDimencionalStencilLatch = new OneDimencionalStencilLatch(vetor, 500, done);

        try {
            oneDimencionalStencilLatch.start();
            done.await();
            System.out.println(Arrays.toString(vetor));
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
