/**
 * classe que representa o modelo de projeto
 */
package Model;

import java.util.*;

public class GTALoja extends GestTrazAqui implements IGTALoja {
    
    /**
     * devolve list de codigos de lojas
     * @return  list de codigos de lojas
     */
    public List<String> getLojas() {
        List<String> lojas = new ArrayList<>();

        for (Loja l: this.lojas.values())
            lojas.add(l.getStoreCode() + ": " + l.getStoreName());

        return lojas;
    }

    /**
     * devolve um loja
     * @param storeCode store code
     * @return          loja
     */
    public Loja getLoja(String storeCode) {
        return lojas.get(storeCode).clone();
    }

    /**
     * altera loja
     * @param loja  loja
     */
    public void setLoja(Loja loja) {
        lojas.replace(loja.getStoreCode(), loja);
    }

    /**
     * adiciona mapEntry nas lojas
     * @param loja loja
     */
    public void addLoja(Loja loja) {
        lojas.put(loja.getStoreCode(), loja);
    }

    /**
     * adiciona encCode a uma loja
     * @param enc   encCode
     */
    public void addEncLoja(String enc) {
        lojas.get(encomendas.get(enc).getStoreCode()).addEncomenda(enc);
    }

    /**
     * devolve codigos de encomenda da loja
     * @param storeCode storeCode
     * @return          list de codigos de encomenda
     */
    public Set<String> getEncLoja(String storeCode){
        return lojas.get(storeCode).getEncomendas();
    }

    /**
     * adiciona produto a uma loja
     * @param storeCode storeCode
     * @param produtos  list de codigos de produtos
     */
    public void addProdLoja(String storeCode, List<String> produtos) {
        lojas.get(storeCode).addProdList(produtos);
    }

    /**
     * devolve coordenadas de uma loja
     * @param storeCode store code
     * @return          coordenada
     */
    private Coordenadas getStoreCoord(String storeCode) {
        return lojas.get(storeCode).getGps();
    }

    /**
     * devolve coordenadas de uma loja a partir de uma encomenda
     * @param encCode encCode
     * @return        coordenada
     */
    public Coordenadas getStoreCoordFromEnc(String encCode) {
        return getStoreCoord(encomendas.get(encCode).getStoreCode());
    }


    /**
     * verifica se a loja existe
     * @param storeCode store code
     * @return          true se loja existes
     */
    public boolean containsLoja(String storeCode) {
        return lojas.containsKey(storeCode);
    }

    /**
     * verifica se o produto exisrte na loja
     * @param storeCode storecode
     * @param prodCode  prodCode
     * @return          true se o produto existe
     */
    public boolean containsProdutoLoja(String storeCode, String prodCode) {
        return lojas.get(storeCode).containsProd(prodCode);
    }

    /**
     * verifica se a loja tem informação sobre a lista de espera
     * @param storeCode store code
     * @return          true se a loja tem info
     */
    public boolean hasQueueInfoLoja(String storeCode) {
        return lojas.get(storeCode).isHasQueueInfo();
    }

    /**
     * altera tempo da fila de espera
     * @param storeCode store code
     * @param time      tempo
     */
    public void setStoreQueueTime(String storeCode, double time) {
        lojas.get(storeCode).setQueueTime(time);
    }

    /**
     * altera o número de pessoas em fila de espera
     * @param storeCode store code
     * @param time      tempo
     */
    public void setStoreQueueSize(String storeCode, int time) {
        lojas.get(storeCode).setQueueSize(time);
    }

    /**
     * devolve notificações de uma loja
     * @param code  store code
     * @return      list de notificações
     */
    public List<Notificacao> getLojaNotificacoes(String code) {
        return lojas.get(code).getNotificacoes();
    }

    /**
     * devolve numero de notificações de uma loja
     * @param code  store code
     * @return      numero
     */
    public int getLojaNumNotificacoes(String code) {
        return lojas.get(code).getNumNotificacoes();
    }

    /**
     * adiciona notificação a uma loja
     * @param code      store code
     * @param not       conteúdo da notificação
     * @param type      tipo
     * @param estCode   estafeta code
     */
    public void addLojaNotificacao(String code, String not, int type, String estCode) {
        lojas.get(code).addNotificacao(not, type, estCode);
    }

    /**
     * limpa a lista de notificações de uma loja
     * @param code  store code
     */
    public void limpaLojaNotificacoes(String code) {
        lojas.get(code).limpaNotificacoes();
    }

}
