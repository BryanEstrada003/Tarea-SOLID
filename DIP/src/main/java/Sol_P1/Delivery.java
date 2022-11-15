/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sol_P1;

import java.time.LocalDateTime;

/**
 *
 * @author HOME
 */
public class Delivery extends Servicio implements IDelivery{
    private Pedido pedido;
    private int codigoPedido;
    private LocalDateTime fechaHora;
    private int codigoServicio;
    
    public Delivery(LocalDateTime fechaHora, int codigo, Pedido pedido, int codigoPedido) {
        this.fechaHora = fechaHora;
        this.codigoServicio = codigo;
        this.pedido = pedido;
        this.codigoPedido = codigoPedido;
    }
    
    //getters y setters

    @Override
    public void solicitarDelivery() {
        //operacion
    }
}
