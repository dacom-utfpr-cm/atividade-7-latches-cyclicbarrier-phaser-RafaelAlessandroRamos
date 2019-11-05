/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade2;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author rafael
 */
public class Letch_Divisor extends Thread {

    int position;
    double[] vetor;
    CountDownLatch doneSignal;

    public Letch_Divisor(int position, double[] vetor, CountDownLatch doneSignal) {
        this.position = position;
        this.vetor = vetor;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;
            this.vetor[this.position] = valor;
        }
        this.doneSignal.countDown();
    }
}
