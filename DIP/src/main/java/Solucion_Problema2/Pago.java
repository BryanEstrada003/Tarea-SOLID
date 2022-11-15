/**
 * Sistema contiene las clases del proyecto.
 */
package Solucion_Problema2;
import Sol_P1.Cliente;
import Sol_P1.Servicio;
import java.util.Scanner;

public class Pago {
    Cliente cliente;
    Servicio servicio;

    public static void elegirTipoPago(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Efectivo \n2. Tarjeta \nIngrese que tipo de pago va a realizar: ");
        String tp = sc.nextLine();
        switch(tp){
            case "1":
                IEfectivo ie= null;
                //operaciones
                break;
            case "2":
                ITarjeta it= null;
                //operaciones
                break;
        }
    }
}
