/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0102ex2;

/**
 *
 * @author Amand
 */
public class Lista {
    protected int val;
    protected Lista proximo;

    public int getVal() {
        return val;
    }

    public Lista getProximo() {
        return proximo;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setProximo(Lista proximo) {
        this.proximo = proximo;
    }
    
    
    public Lista(int val){
        this.val=val;
        this.proximo = null;
    }
    
    
    
}
