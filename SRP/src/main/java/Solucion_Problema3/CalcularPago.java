/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

/**
 *
 * @author HOME
 */
public class CalcularPago {
    /**
    * Método que cálcula y muestra el valor a pagar de un servicio.
    * @param tp Tipo de pago que realizara.
     * @param s
    */
    protected void calcularValorPagar(tipoPago tp, Servicio s){
        double numAleatorio =Math.random()*10;
        double valorTotalPagar= 0;
        if (tp.equals(tipoPago.EFECTIVO)){
            valorTotalPagar=numAleatorio;
        }else if (tp.equals(tipoPago.TARJETA)){
            valorTotalPagar=numAleatorio*1.1;
        
        }
        
    }
    
    /**
    * Método que cálcula y muestra el valor a pagar de un servicio.
    * @param valorTotalPagar Valor total a pagar por los platos.
    * @param tp Tipo de pago que realizara.
    */
    protected void calcularValorPagar(double valorTotalPagar,tipoPago tp, Servicio s){
        double precioEntrega =Math.random()*5;
        if (tp.equals(tipoPago.EFECTIVO)){
            valorTotalPagar+=precioEntrega;
        }else if (tp.equals(tipoPago.TARJETA)){
            valorTotalPagar=(valorTotalPagar+precioEntrega)*1.1;
        }
        s.setValorapagar(valorTotalPagar);
    }
}
