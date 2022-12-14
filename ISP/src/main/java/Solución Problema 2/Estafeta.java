/**
 * classe que representa um estafeta
 */
package Model;

import java.io.Serializable;
import java.util.*;

public class Estafeta implements Comparable<Estafeta>, Serializable {

    private String code;
    private String name;
    private String type;
    private Coordenadas gps;
    private double raio;
    private double velocidade;
    private double numKm;
    private boolean isFree;
    private boolean isMedic;
    private boolean occup;
    private double classificacao;
    private int numCla;
    private Set<String> encomendas;
    private List<Notificacao> notificacoes;

    //--------------------------------------------------------------Construtores--------------------------------------------------------------------------\\

    public Estafeta() {
        this.code = "";
        this.name = "";
        this.type = "";
        this.gps = new Coordenadas();
        this.raio = 0d;
        this.velocidade = 0d;
        this.numKm = 0d;
        this.isFree = false;
        this.isMedic = false;
        this.occup = false;
        this.classificacao = 0d;
        this.numCla = 0;
        this.encomendas = new TreeSet<>();
        this.notificacoes = new ArrayList<>();
    }

    public Estafeta(String voluntaryCode, String name, Coordenadas gps, double raio, double velocidade, double numKm, boolean isFree, boolean isMedic, double classificacao, int numCla, String type,boolean occup, List<Notificacao> notificacoes) {
        this.code = voluntaryCode;
        this.name = name;
        this.type = type;
        this.gps = gps.clone();
        this.raio = raio;
        this.velocidade = velocidade;
        this.numKm = numKm;
        this.classificacao = classificacao;
        this.numCla = numCla;
        this.isFree = isFree;
        this.occup = occup;
        this.isMedic = isMedic;
        this.encomendas = new TreeSet<>();
        this.notificacoes = new ArrayList<>();
    }

    public Estafeta(Estafeta v) {
        this.code = v.getCode();
        this.name = v.getName();
        this.type = v.getType();
        this.gps = v.getGps();
        this.raio = v.getRaio();
        this.velocidade = v.getVelocidade();
        this.numKm = v.getNumKm();
        this.isFree = v.isFree();
        this.isMedic = v.isMedic();
        this.classificacao = v.getClassificacao();
        this.numCla = v.getNumCla();
        setEncomendas(v.getEncomendas());
        setNotificacoes(v.getNotificacoes());
    }

    //--------------------------------------------------------------Getters e Setters--------------------------------------------------------------------------\\

    /**
     * Devolve c??digo
     *
     * @return C??digo
     */
    public String getCode() {
        return code;
    }

    /**
     * Devolve tipo de estafeta
     * @return Tipo de estafeta
     */
    public String getType() {
        return type;
    }

    /**
     * Altera o c??digo
     * @param code C??digo
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Devolve nome
     * @return Nome
     */
    public String getName() {
        return name;
    }

    /**
     * Devolve gps
     * @return Gps
     */
    public Coordenadas getGps() {
        return gps.clone();
    }

    /**
     * Altera o gps
     * @param gps Gps
     */
    public void setGps(Coordenadas gps) {
        this.gps.setLatitude(gps.getLatitude());
        this.gps.setLongitude(gps.getLongitude());
    }

    /**
     * Devolve raio
     * @return Raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * Altera o raio
     * @param raio Raio
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }

    /**
     * Devolve a velocidade
     * @return Velocidade
     */
    public double getVelocidade() {
        return velocidade;
    }

    /**
     * Altera a velocidade
     * @param velocidade Velocidade
     */
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Devolve o n??mero de quil??metros
     * @return N??mero de quil??metros
     */
    public double getNumKm() {
        return numKm;
    }

    /**
     * Altera o n??mero de quil??metros
     * @param numKm N??mero de quil??metros
     */
    public void setNumKm(double numKm) {
        this.numKm = numKm;
    }

    /**
     * Atualizar o n??mero de quil??metros
     * @param numKm n??mero de quil??metros
     */
    public void addNumKm(double numKm) {
        this.numKm += numKm;
    }

    /**
     * Indica se est?? dispon??vel
     * @return True se est?? dispon??vel, false caso contr??rio
     */
    public boolean isFree() {
        return isFree;
    }

    /**
     * Alterar o estado de disponibilidade
     * @param free Estado de disponibilidade
     */
    public void setFree(boolean free) {
        isFree = free;
    }

    /**
     * Indica se transporta encomendas m??dicas
     * @return True se transporta encomendas m??dicas, false caso contr??rio
     */
    public boolean isMedic() {
        return isMedic;
    }

    /**
     * Altera a informa????o que indica se o estafeta transporta encomendas m??dicas
     * @param medic True ou false se transporta ou n??o encomendas m??dicas, respetivamente
     */
    public void setMedic(boolean medic) {
        isMedic = medic;
    }

    /**
     * Devolve a classifica????o
     * @return Classifica????o
     */
    public double getClassificacao() {
        return classificacao;
    }

    /**
     * Altera a classifica????o
     * @param classificacao Classifica????o
     */
    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * Devolve o n??mero de classifica????es
     * @return N??mero de classifica????es
     */
    public int getNumCla() {
        return numCla;
    }

    /**
     * Incrementa o n??mero de classifica????es
     */
    public void incNumCla() {
        this.numCla ++;
    }

    /**
     * Retorna a lista dos registos
     * @return Lista de registos
     */
    public List<String> getEncomendas() {
        return new ArrayList<>(encomendas);
    }

    /**
     * Altera a lista de registos
     * @param enc Lista de registos
     */
    public void setEncomendas(List<String> enc) {
        this.encomendas = new TreeSet<>(enc);
    }

    /**
     * Adicionar uma encomenda aos registos e incrementa o n??mero de encomendas
     * @param enc C??digo de encomenda
     */
    public void setEnc(String enc) {
        this.encomendas.add(enc);
        if(this.getType().equals("Transportadora"))
            ((Transportadora)this).setNumEncomendas();
    }

    /**
     * Remove uma encomenda dos registos
     * @param encCode C??digo de encomenda
     */
    public void removeEnc(String encCode){
        encomendas.remove(encCode);
    }

    /**
     * Retorna um booleano que indica se o estafeta est?? ocupado ou n??o
     * @return occup
     */
    public boolean isOccup() {
        return occup;
    }

    /**
     * Altera a informa????o que indica se est?? ocupado
     * @param occup Booleano que indica se est?? ocupado
     */
    public void setOccup(boolean occup) {
        this.occup = occup;
    }

    /**
     * Altera o tipo de estafeta
     * @param type Tipo
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Devolve a lista de notifica????es
     * @return Lista de notifica????es
     */
    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    /**
     * Altera a lista de notifica????es
     * @param notificacoes Lista de notifica????es
     */
    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = new ArrayList<>();
        this.notificacoes.addAll(notificacoes);
    }

    /**
     * Devolve o n??mero de notifica????es
     * @return N??mero de notifica????es
     */
    public int getNumNotificacoes() {
        return notificacoes.size();
    }

    /**
     * Adiciona uma notifica????o
     * @param not       Conte??do da notifica????o
     * @param type      Tipo de notifica????o
     * @param estCode   C??digo de estafeta
     */
    public void addNotificacao(String not, int type, String estCode) {
        notificacoes.add(new Notificacao(not, type, estCode));
    }

    /**
     * Remove um notifica????o
     * @param not Conte??do de notifica????o
     */
    public void removeNotificacao(String not) {
        notificacoes.remove(not);
    }

    //--------------------------------------------------------------toString, equals e clone--------------------------------------------------------------------------\\

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(type);
        sb.append("{estafetaCode='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", gps=").append(gps);
        sb.append(", raio=").append(raio);
        sb.append(", velocidade=").append(velocidade);
        sb.append(", isFree=").append(isFree);
        sb.append(", isMedic=").append(isMedic);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", \nregisterV=").append(encomendas);
        sb.append('}').append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Estafeta that = (Estafeta) o;
        return Double.compare(that.raio, raio) == 0 &&
                Double.compare(that.velocidade, velocidade) == 0 &&
                isFree == that.isFree &&
                isMedic == that.isMedic &&
                Double.compare(that.classificacao, classificacao) == 0 &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gps, that.gps) &&
                Objects.equals(encomendas, that.encomendas);
    }

    public Estafeta clone() {
        return new Estafeta(this);
    }

    public int compareTo(Estafeta e) {
        if(this.numKm > e.getNumKm())
            return -1;
        else if(this.numKm < e.getNumKm())
            return 1;
        else
            return 0;
    }

    //--------------------------------------------------------------Outros m??todos--------------------------------------------------------------------------\\

    /**
     * Atualiza a classifica????o
     * @param classificacao Classifica????o
     */
    public void atualizaClassificacao(double classificacao) {
        setClassificacao((getClassificacao() * getNumCla() + classificacao) / (getNumCla() + 1));
        incNumCla();
    }

    /**
     * Adiciona uma encomenda
     * @param encCode C??digo de encomenda
     */
    public void addEncomenda(String encCode) {
        encomendas.add(encCode);
    }

    /**
     * Devolve um booleano que indica se os registos cont??m uma encomenda
     * @param encCode   C??digo da encomenda
     * @return          True se cont??m a encomenda, false caso contr??rio
     */
    public boolean containsEncomenda(String encCode) {
        return encomendas.contains(encCode);
    }

    /**
     * Limpa a lista de notifica????es
     */
    public void limpaNotificacoes() {
        notificacoes = new ArrayList<>();
    }
}
