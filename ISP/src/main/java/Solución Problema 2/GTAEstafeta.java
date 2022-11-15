/**
 * classe que representa o modelo de projeto
 */
package Model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GTAEstafeta extends GestTrazAqui implements IGTAEstafeta {

    
    /**
     * devolve um estafeta
     * @param code  estafeta code
     * @return      copia do estafeta
     */
    public Estafeta getEstafeta(String code) {
        return estafetas.get(code).clone();
    }

    /**
     * devolve numero de encomendas maximo que um estafeta pode transportar
     * @param transpCode    transpCode
     * @return              numero de encomendas
     */
    public int getEstafetaNumEnc(String transpCode) {
        return ((Transportadora)estafetas.get(transpCode)).getNumEncomendas();
    }

    /**
     * altera o estafeta
     * @param estafeta estasfeta
     */
    public void setEstafeta(Estafeta estafeta) {
        estafetas.replace(estafeta.getCode(), estafeta);
    }

    /**
     * adiciona entrada no map de estafetas
     * @param estafeta estafeta
     */
    public void addEstafeta(Estafeta estafeta) {
        estafetas.put(estafeta.getCode(), estafeta);
    }

    /**
     * adiciona encCode a um estafeta
     * @param code      estafeta code
     * @param encCode   encCode
     */
    public void addEncomendaEstafeta(String code, String encCode) {
        estafetas.get(code).addEncomenda(encCode);
    }

    /**
     * adiciona uma encCode a uma rota de entregas de uma transportadora
     * @param transpCode    transpCode
     * @param rota          encCode de rota
     */
    public void addEstafetaRota(String transpCode,String rota){
        ((Transportadora)estafetas.get(transpCode)).addRota(rota);
    }

    /**
     * devolve a rota de entregas de uma transportadora
     * @param transpCode transpCode
     * @return           list de codigos de encomendas
     */
    public Set<String> getEstafetaRota(String transpCode){
        return ((Transportadora)estafetas.get(transpCode)).getRota();
    }

    /**
     * devolve tamanho da rota de uma transportadora
     * @param transpCode    transpCode
     * @return              tamanho
     */
    public int getEstafetaRotaSize(String transpCode){
        return ((Transportadora)estafetas.get(transpCode)).getRotaSize();
    }

    /**
     * devolve tipo de estafeta
     * @param estCode   estCode
     * @return          tipo de estafeta
     */
    public String getEstafetaType(String estCode){
        return estafetas.get(estCode).getType();
    }

    /**
     * verifica se a rota do estafeta tem a encCode dada
     * @param estCode   estCode
     * @param encCode   encCode
     * @return          true se o estafeta contem a encCode na rota
     */
    public boolean containsEncRota(String estCode,String encCode){
        return ((Transportadora)estafetas.get(estCode)).containsRota(encCode);
    }

    /**
     * devolve o nome do estafeta
     * @param estCode   estafeta code
     * @return          nome
     */
    public String getEstafetaName(String estCode){
        return estafetas.get(estCode).getName();
    }

    /**
     * devolve coordenada do estafeta
     * @param code  estafeta code
     * @return      coordenada
     */
    public Coordenadas getEstafetaCoord(String code) {
        return estafetas.get(code).getGps();
    }

    /**
     * devolve classificação do estafeta
     * @param code  estafeta code
     * @return      classificação
     */
    public double getEstafetaClassificacao(String code) {
        return estafetas.get(code).getClassificacao();
    }

    /**
     * devolve notificações
     * @param code  estafeta code
     * @return      list de notificações
     */
    public List<Notificacao> getEstafetaNotificacoes(String code) {
        return estafetas.get(code).getNotificacoes();
    }

    /**
     * devolve numero de notificações
     * @param code  estafeta code
     * @return      numero de notificações
     */
    public int getEstafetaNumNotificacoes(String code) {
        return estafetas.get(code).getNumNotificacoes();
    }

    /**
     * adiciona uma notificação a um estafeta
     * @param estCode   estafetaCode
     * @param not       conteúdo notificação
     * @param type      tipo
     * @param code      encCode
     */
    public void addEstafetaNotificacao(String estCode, String not, int type, String code) {
        estafetas.get(estCode).addNotificacao(not, type, code);
    }

    /**
     * remove um encCode da rota de uma transportadora
     * @param transpCode    transpCode
     * @param enc           encCode
     */
    public void removeEstafetaEncRota(String transpCode,String enc) {
        ((Transportadora)estafetas.get(transpCode)).remEncRota(enc);
    }

    /**
     * limpa as notificações de um estafeta
     * @param code  estafeta code
     */
    public void limpaEstafetaNotificacoes(String code) {
        estafetas.get(code).limpaNotificacoes();
    }

    /**
     * devolve os codigos dos estafetas que podem entregar a encomenda
     * @param enc encCode
     * @return    list de codigos de estafeta
     */
    public List<String> possiveisEstafetas(String enc) {
        List<String> estafetaList;
        Coordenadas cr = lojas.get(encomendas.get(enc).getStoreCode()).getGps();
        Coordenadas cr2 = users.get(encomendas.get(enc).getUserCode()).getGps();
        boolean isMedic = encomendas.get(enc).isMedic();

        estafetaList = estafetas.values().stream().filter(e -> ((!isMedic || e.isMedic()) && e.isFree() && !e.isOccup() && (e.getGps().distancia(cr) < e.getRaio())
                                                                && (e.getGps().distancia(cr2) < e.getRaio())))
                                                                    .map(Estafeta::getCode).collect(Collectors.toList());

        return estafetaList;
    }

    /**
     * devolve codigos de encomendas que um estafeta pode transportar
     * @param transpCode transpCode
     * @return           lista de codigos de encomenda
     */
    public List<String> encomendasPossiveis(String transpCode){
        List<String> encList;
        Coordenadas cr = estafetas.get(transpCode).getGps();
        boolean isMedic = estafetas.get(transpCode).isMedic();
        double raio = estafetas.get(transpCode).getRaio();

        encList = encomendas.values().stream().filter(e -> ((!isMedic || e.isMedic()) && e.isAceiteLoja() && !e.isEntregue() && !((Transportadora)estafetas.get(transpCode)).containsRota(e.getEncCode())
                                                            && lojas.get(e.getStoreCode()).getGps().distancia(cr) < raio && users.get(e.getUserCode()).getGps().distancia(cr) < raio) && !e.isStandBy())
                                                            .map(Encomenda::getEncCode).collect(Collectors.toList());

        return encList;
    }

    
    /**
     * classificar um estafeta
     * @param pontuacao pontuação
     * @param code      estafeta code
     */
    public void classificarEstafeta(double pontuacao,String code){
        estafetas.get(code).atualizaClassificacao(pontuacao);
    }

    /**
     * verifica se o estafeta esta livre
     * @param code  estafeta code
     * @return      true se o estafeta esta livre
     */
    public boolean isEstafetaFree(String code) {
        return estafetas.get(code).isFree();
    }

    /**
     * altera o estado de um estafeta
     * @param code  estafeta code
     * @param free  estado
     */
    public void setEstafetaFree(String code, boolean free) {
        estafetas.get(code).setFree(free);
    }

    /**
     * devolve codigos de transportadoras com mais km percorridos
     * @return list de codigos de estafeta
     */
    public List<String> getTopTrans() {
        return this.estafetas.values().stream().filter(c -> c.getType().equals("Transportadora")).sorted().limit(10).map(c -> String.format("%3s %2s %40s %2s %5.2f",c.getCode(), "|", c.getName(), "|", c.getNumKm())).collect(Collectors.toList());
    }

    /**
     * retorna encomenda de um estafeta num intervalo de tempo
     * @param code  estafeta code
     * @param min   data min
     * @param max   data max
     * @return      list de encomendas
     */
    public List<Encomenda> getEncomendasEstafeta(String code, LocalDateTime min, LocalDateTime max) {
        List<Encomenda> list = new ArrayList<>();

        for (String c : estafetas.get(code).getEncomendas()) {
            list.add(encomendas.get(c).clone());
        }

        return list.stream().filter(e -> e.encData(min,max)).collect(Collectors.toList());
    }

    

    /**
     * verifica se o estafeta contem a encomenda dada
     * @param encCode   encCode
     * @param code      estafetaCode
     * @return          true se o estafeta contem o encCode
     */
    public boolean containsEncomendaEstafeta(String encCode, String code) {
        return estafetas.get(code).containsEncomenda(encCode);
    }

    /**
     * devolve encomenda por entregar em standBy
     * @param estCode   estafetaCode
     * @return          encCode
     */
    public String encomendaStandBy(String estCode){
        return estafetas.get(estCode).getEncomendas().stream().filter(enc -> !encomendas.get(enc).isEntregue()).findFirst().orElse("");
    }

    /**
     * remove encomenda da lista de encomendas de um estafeta
     * @param code      estafetaCode
     * @param encCode   encCode
     */
    public void removerEnc(String code,String encCode){
        estafetas.get(code).removeEnc(encCode);
        encomendas.get(encCode).setStandBy(false);
    }

    /**
     * altera estado do estafeta
     * @param code  estafeta code
     * @param occup estado
     */
    public void setEstafetaOccup(String code,boolean occup){
        estafetas.get(code).setOccup(occup);
    }

    /**
     * Método que verifica se um estafeta é do tipo médico
     *
     * @param estafetaCode  Código do estafeta
     * @return              Verdadeiro se for medic, falso caso contrário
     */
    public boolean isEstafetaMedic (String estafetaCode) {
        return estafetas.get(estafetaCode).isMedic();
    }

    /**
     * Método que altera a disponibilidade para entregar encomendas médicas
     *
     * @param estafetaCode      Código do estafeta
     */
    public void changeMedic(String estafetaCode) {
        estafetas.get(estafetaCode).setMedic(!isEstafetaMedic(estafetaCode));
    }

    
}
