/**
 * classe que representa o modelo de projeto
 */
package Model;

import java.util.*;
import java.util.stream.Collectors;

public class GTAEncomenda extends GestTrazAqui implements IGTAEncomenda{
    
    /**
     * devolve encomenda
     * @param encCode   encCode
     * @return          encomenda
     */
    public Encomenda getEncomenda(String encCode) {
        return encomendas.get(encCode).clone();
    }

    /**
     * altera encomenda
     * @param enc   encCode
     */
    public void setEncomenda(Encomenda enc) {
        encomendas.replace(enc.getEncCode(), enc);
    }

    /**
     * adiciona encomenda
     * @param encomenda encomenda
     */
    public void addEncomenda(Encomenda encomenda) {
        users.get(encomenda.getUserCode()).addEncomenda(encomenda.getEncCode());
        encomendas.put(encomenda.getEncCode(), encomenda);
    }

    /**
     * verifica se a encomenda existe
     * @param encCode   enc code
     * @return          true se existe
     */
    public boolean containsEncomenda(String encCode) {
        return encomendas.containsKey(encCode);
    }

   

    /**
     * entrega encomenda
     * @param encCode       encCode
     * @param estafetaCode  estafetaCode
     */
    public void entregarEncomenda(String encCode,String estafetaCode) {
        Encomenda enc = encomendas.get(encCode);
        Estafeta e = estafetas.get(estafetaCode);
        Loja l = lojas.get(enc.getStoreCode());
        Coordenadas cr = lojas.get(enc.getStoreCode()).getGps();

        enc.setTranspCode(estafetaCode);
        enc.setEntregue(true);
        enc.setPreco(precoEncomenda(encCode,estafetaCode));
        enc.setTempoEntrega(calculaTempo(e.getGps(),l.getGps(),users.get(enc.getUserCode()).getGps(),l.getQueueTime(), l.getQueueSize(),e.getVelocidade()));
        e.setEnc(encCode);
        e.addNumKm(e.getGps().distancia(cr) + l.getGps().distancia(users.get(enc.getUserCode()).getGps()));
        enc.setStandBy(false);
    }

    /**
     * altera o transpCode de uma encomenda
     * @param enc           encCode
     * @param transpCode    transpCode
     */
    public void sugerirTransp(String enc,String transpCode){
        encomendas.get(enc).setTranspCode(transpCode);
    }

    /**
     * devolve lista de encomendas aceite
     * @return list de codigos de encomenda
     */
    public Set<String> encomendasAceites() {
        Set<String> res = new HashSet<>();

        encomendas.values().stream().map(Encomenda::clone).filter(Encomenda::isAceiteLoja).map(Encomenda::getEncCode).forEach(res::add);
        return res;
    }

    /**
     * verifica se a encomenda foi aceite
     * @param encCode   encCode
     * @return          true se foi aceite
     */
    public boolean isEncomendaAceite(String encCode) {
        return encomendasAceites().contains(encCode);
    }

    /**
     * calcula preço de encomenda
     * @param encCode       encCode
     * @param transpCode    transpCode
     * @return              preço
     */
    public double precoEncomenda(String encCode,String transpCode) {
        if(estafetas.get(transpCode).getType().equals("Voluntario"))
            return 0;

        Encomenda enc = getEncomenda(encCode);
        double dist = estafetas.get(transpCode).getGps().distancia(lojas.get(enc.getStoreCode()).getGps())
                + lojas.get(enc.getStoreCode()).getGps().distancia(users.get(enc.getUserCode()).getGps());
        return  ((Transportadora)estafetas.get(transpCode)).getTaxaKm() * dist + enc.getWeight() * ((Transportadora)estafetas.get(transpCode)).getTaxaPeso();
    }

    /**
     * devolve user que fez a encomenda
     * @param encCode   encCode
     * @return          userCode
     */
    public String getEncUser(String encCode){
        return encomendas.get(encCode).getUserCode();
    }

    /**
     * devolve transp que entregou uma encomenda
     * @param encCode   encCode
     * @return          transpCode
     */
    public String getEncTransp(String encCode){
        return encomendas.get(encCode).getTranspCode();
    }

    /**
     * devolve tempo de entrega da encomenda
     * @param encCode   encCode
     * @return          tempo
     */
    public double getEncTime(String encCode){
        return encomendas.get(encCode).getTempoEntrega();
    }

    /**
     * devolve o nome da loja da encomenda
     * @param encCode   encCode
     * @return          Loja
     */
    public String getEncStoreName(String encCode){
        return lojas.get(encomendas.get(encCode).getStoreCode()).getStoreName();
    }

    /**
     * devolve o preço de entrega da encomenda
     * @param encCode   encCode
     * @return          tempo
     */
    public double getEncPrice(String encCode){
        return encomendas.get(encCode).getPreco();
    }

    /**
     * devolve nome do utilizador que fez a encomenda
     * @param encCode   encCode
     * @return          username
     */
    public String getEncUserName(String encCode){
        return users.get(encomendas.get(encCode).getUserCode()).getName();
    }

    /**
     * devolve as encomendas não aceite numa loja
     * @param storeCode storeCode
     * @return          list de codigos de encomenda
     */
    public List<String> encomendasNaoAceitesLoja(String storeCode) {
        return encomendas.values().stream().filter(c -> c.getStoreCode().equals(storeCode)).filter(c-> !c.isAceiteLoja()).map(Encomenda::getEncCode).collect(Collectors.toList());
    }

    /**
     * remove uma encomenda
     * @param encCode   encCode
     */
    public void removeEncomenda(String encCode) {
        String userCode = getEncUser(encCode);
        users.get(userCode).removeEncomenda(encCode);
        encomendas.remove(encCode);
    }

    /**
     * devolve uma lista de produtos
     * @return   list de codigos de produtos
     */
    public List<String> randomListaProdutos() {
        List<String> prods = produtos.values().stream().map(Produto::getProdCode).collect(Collectors.toList());

        Random rand = new Random();
        int size = prods.size();
        int totalItems = rand.nextInt((2*size)/3 - size/2) + size/2;
        int randomIndex;

        while(prods.size() != totalItems) {
            randomIndex = rand.nextInt(prods.size());
            prods.remove(randomIndex);
        }

        return prods;
    }

    /**
     * Método que devolve a informação da encomenda
     * @param encomendas    Lista de códigos das encomendas
     * @return              Lista com a informação das encomendas
     */
    public List<String> getEncInfo(List<String> encomendas) {
       return encomendas.stream().map(e -> e + " -> " + getEncStoreName(e) + " " + String.format("%.2f", getEncPrice(e)) + "€").collect(Collectors.toList());
    }

    

}
