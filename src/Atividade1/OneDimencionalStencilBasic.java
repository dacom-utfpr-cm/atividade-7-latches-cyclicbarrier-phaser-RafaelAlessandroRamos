/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade1;

import java.util.Arrays;

/**
 *
 * @author rafael
 */
public class OneDimencionalStencilBasic implements Runnable {

    double[] vetor;
    int position;
    int iteracoes;

    public OneDimencionalStencilBasic(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.position = 0;
    }

    @Override
    public void run() {
        int count_itera = 0;
        while (count_itera <= (this.iteracoes)) {
            if (this.position == (this.vetor.length)) {
                this.position = 0;
            }
            if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
                double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;
                this.vetor[this.position] = valor;
            }
            this.position++;
            count_itera++;
        }
    }
}
