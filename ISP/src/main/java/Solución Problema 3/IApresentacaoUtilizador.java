

import Model.Encomenda;

import java.util.List;

public interface IApresentacaoUtilizador {
    public void printMenuUtilizador();
    public void printEncomendas(String message, List<Encomenda> arr);
    public void printFatura(Encomenda enc);
    public void printErroEntrega();
    public void printEncomendaEntregueVol(String code, String nome, double tempo);
    public void printEncomendaEntregue(String code, String tipo, String nome, double preco, double tempo);
    public void printEncomendaAceite();
    public void printCompraCancelada();
    public void printPedirClassificar();
    public void printEncomendaStandBy(String code);
    public String pedirEncomenda();
}
