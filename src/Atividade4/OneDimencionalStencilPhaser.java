/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade4;

import java.util.Arrays;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class OneDimencionalStencilPhaser extends Thread {

    double[] vetor;
    int iteracoes;
    int numThreads;

    Phaser phaserblock;

    public OneDimencionalStencilPhaser(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.phaserblock = new Phaser(2);
    }

    @Override
    public void run() {
        int count_itera = 0;
        while (count_itera <= this.iteracoes) {
            Phaser_Divisor tarefa01 = new Phaser_Divisor(1, vetor, phaserblock);
            Phaser_Divisor tarefa02 = new Phaser_Divisor(2, vetor, phaserblock);
            Thread thread1 = new Thread(tarefa01);
            Thread thread2 = new Thread(tarefa02);
            thread1.start();
            thread2.start();
            this.phaserblock.awaitAdvance(this.phaserblock.getPhase());
            count_itera++;
        }
    }
}