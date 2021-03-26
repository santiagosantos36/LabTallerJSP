/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.sessionBEAN;

import javax.ejb.Local;

/**
 *
 * @author santi
 */
@Local
public interface CalcbeanLocal {

    Integer sumar(int val1, int val2);

    Integer multiplicacion(int var1, int var2);

    Integer resta(int var1, int var2);

    Integer dividir(int var1, int var2);

    Integer modulo(int var1, int var2);

    Integer cuadrado(int var1, int var2);
    
}

