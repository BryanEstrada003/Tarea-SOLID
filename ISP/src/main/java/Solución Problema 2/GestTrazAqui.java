/**
 * classe que representa o modelo de projeto
 */
package Model;

import java.io.Serializable;
import java.util.*;

public class GestTrazAqui implements Serializable {

    public Map<String, Utilizador> users;
    public Map<String, Loja> lojas;
    public Map<String, Estafeta> estafetas;
    public Map<String, Encomenda> encomendas;
    public Map<String, Produto> produtos;
    public Map<String, Login> loginMap;
    public int[] randomTraffic;
    public int[] randomWeather;
    public int[] randomQueue;

    public GestTrazAqui() {
        this.users = new HashMap<>();
        this.lojas = new HashMap<>();
        this.estafetas = new HashMap<>();
        this.encomendas = new HashMap<>();
        this.produtos = new HashMap<>();
        this.loginMap = new HashMap<>();
        this.randomTraffic = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6};
        this.randomWeather = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        this.randomQueue = new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 7, 8, 10};
    }
    
    /**
     * calcula tempo de entrega de uma encomenda
     * @param crE               coordenada estafeta
     * @param crL               coordenada loja
     * @param crU               coordenada utilizador
     * @param tempoFilaEspera   tempo em fila de espera da loja
     * @param queueSize         tamanho da fila de espera
     * @param velocidade        velocidade da transportadora
     * @return                  tempo
     */
    public double calculaTempo(Coordenadas crE,Coordenadas crL,Coordenadas crU,double tempoFilaEspera, int queueSize,double velocidade) {
        Random rand = new Random();
        int condicoesAtmosfericas = randomWeather[rand.nextInt(15)];
        int transito = randomTraffic[rand.nextInt(15) ];
        int numPessoasFila = randomQueue[rand.nextInt(12)];
        double tempo;
        if(tempoFilaEspera == -1) {
            tempo = rand.nextDouble() * 10 * numPessoasFila;
        }

        else {
            tempo = tempoFilaEspera * queueSize;
        }
        double dist = crE.distancia(crL) + crL.distancia(crU);
        tempo += (dist / velocidade) * 60;
        if(condicoesAtmosfericas == 2)
            tempo *= 1.2;
        else if(condicoesAtmosfericas == 3)
            tempo *= 1.5;
        else if(condicoesAtmosfericas == 4)
            tempo *= 2;

        if(transito == 2)
            tempo *= 1.2;
        else if(transito == 3)
            tempo *= 1.5;
        else if(transito == 4)
            tempo *= 2;
        else if(transito == 5)
            tempo *= 2.5;
        else if(transito == 6)
            tempo *= 3;

        return tempo;
    }

    /**
     * gera um loginCode
     * @param tipoConta tipo de conta
     * @return          codigo de login
     */
    public String generateCode(String tipoConta) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        char c = ' ';
        int randInt;

        c = tipoConta.toLowerCase().charAt(0);

        if (c != 'e')
            randInt = rand.nextInt(100);

        else
            randInt = rand.nextInt(10000);

        sb.append(c).append(randInt);

        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Controlador{").append("users=").append(users).append("\n");
        sb.append(", lojas=").append(lojas).append("\n");
        sb.append(", voluntarios=").append(estafetas).append("\n");
        sb.append(", encomendas=").append(encomendas).append("\n");
        sb.append('}');
        return sb.toString();
    }
}
