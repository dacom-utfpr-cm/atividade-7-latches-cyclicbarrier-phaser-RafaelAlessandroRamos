/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade3;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class OneDimencionalStencilBarreiraCiclica extends Thread {

    double[] vetor;
    int iteracoes;
    int numThreads;
    int count_itera;

    CyclicBarrier doneBarrier;

    public OneDimencionalStencilBarreiraCiclica(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.count_itera = 0;
        this.doneBarrier = new CyclicBarrier(2, new EstouroBarreira(this));
    }

    @Override
    public void run() {
        while (this.count_itera <= this.iteracoes) {
            BarreiraCiclica_Divisor tarefa01 = new BarreiraCiclica_Divisor(1, this.vetor, this.doneBarrier);
            BarreiraCiclica_Divisor tarefa02 = new BarreiraCiclica_Divisor(2, this.vetor, this.doneBarrier);

            Thread thread1 = new Thread(tarefa01);
            Thread thread2 = new Thread(tarefa02);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(OneDimencionalStencilBarreiraCiclica.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.doneBarrier.reset();
        }
    }
}