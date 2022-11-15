/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sol_P1;

/**
 *
 * @author HOME
 */
public class Codigo {
    
    protected static int generarCodServicio() {
        int cod=(int)(Math.random()*(99999-10000)+10000);
        return cod;
    }
    
    protected static int generarCodPedido(){
    int codP=(int)(Math.random()*(9999-1000)+1000);
        return codP;
    }
    
}
