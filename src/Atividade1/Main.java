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
public class Main {
    public static void main(String[] args) {
        double[] vetor = new double[]{1, 2, 2, 1};
        OneDimencionalStencilBasic oneDimencionalStencilBasic = new OneDimencionalStencilBasic(vetor, 500);
        oneDimencionalStencilBasic.run();
        System.out.println(Arrays.toString(vetor));
    }
}
