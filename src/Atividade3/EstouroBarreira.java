/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade3;

/**
 *
 * @author rafael
 */
public class EstouroBarreira implements Runnable {

    OneDimencionalStencilBarreiraCiclica code;

    public EstouroBarreira(OneDimencionalStencilBarreiraCiclica classe) {
        this.code = classe;
    }

    @Override
    public void run() {
        this.code.count_itera++;
    }
}
