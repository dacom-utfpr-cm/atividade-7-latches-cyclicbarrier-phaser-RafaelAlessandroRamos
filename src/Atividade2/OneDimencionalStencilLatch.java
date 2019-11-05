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
public class OneDimencionalStencilLatch extends Thread {

    double[] vetor;
    int iteracoes;
    int numThreads;

    CountDownLatch doneSignal;
    CountDownLatch done;

    public OneDimencionalStencilLatch(double[] vetor, int iteracoes, CountDownLatch done) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.done = done;
        this.doneSignal = new CountDownLatch(2);
    }

    @Override
    public void run() {
        int count_itera = 0;

        while (count_itera <= this.iteracoes) {
            try {

                Letch_Divisor thread01 = new Letch_Divisor(1, this.vetor, this.doneSignal);
                Letch_Divisor thread02 = new Letch_Divisor(2, this.vetor, this.doneSignal);

                thread01.start();
                thread02.start();

                this.doneSignal.await();
                count_itera++;
                this.doneSignal = new CountDownLatch(2);

            } catch (InterruptedException ex) {
                Logger.getLogger(OneDimencionalStencilLatch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.done.countDown();
    }
}