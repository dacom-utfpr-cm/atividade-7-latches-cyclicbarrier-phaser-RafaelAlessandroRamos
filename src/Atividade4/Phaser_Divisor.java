/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade4;

import java.util.concurrent.Phaser;

/**
 *
 * @author rafael
 */
public class Phaser_Divisor implements Runnable {

    int position;
    double[] vetor;
    Phaser phaserblock;

    public Phaser_Divisor(int position, double[] vetor, Phaser phaserblock) {
        this.position = position;
        this.vetor = vetor;
        this.phaserblock = phaserblock;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;
            this.vetor[this.position] = valor;
        }
        this.phaserblock.arrive();
    }
}

