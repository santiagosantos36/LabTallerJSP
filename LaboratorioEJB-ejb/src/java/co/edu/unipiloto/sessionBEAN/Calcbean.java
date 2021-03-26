/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.sessionBEAN;

import javax.ejb.Stateless;

/**
 *
 * @author santi
 */
@Stateless
public class Calcbean implements CalcbeanLocal {

    @Override
    public Integer sumar(int var1, int var2) {
        return var1+var2;
    }
    
    @Override
    public Integer multiplicacion(int var1, int var2) {
        return var1*var2;
    }

    @Override
    public Integer resta(int var1, int var2) {
        return var1-var2;
    }

    @Override
    public Integer dividir(int var1, int var2) {
        return var1/var2;
    }

    @Override
    public Integer modulo(int var1, int var2) {
        return var1%var2;
    }

    @Override
    public Integer cuadrado(int var1, int var2) {
        return (int)Math.pow(var1, var2);
    }
    
    
    
  
    

    
}