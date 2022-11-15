/**
 * classe que representa o modelo de projeto
 */
package Model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GTAUtilizador extends GestTrazAqui implements IGTAUtilizador {

    
    /**
     * Devolve o utilizador com um determinado código
     * @param userCode Código de utilizador
     * @return Utilizador
     */
    public Utilizador getUser(String userCode) {
        return users.get(userCode).clone();
    }

    /**
     * altera codigo de um utilizador
     * @param user userCode
     */
    public void setUser(Utilizador user) {
        users.replace(user.getCodigoUtilizador(), user);
    }

    /**
     * adiciona um utilizador
     * @param user utilizador
     */
    public void addUser(Utilizador user) {
        users.put(user.getCodigoUtilizador(), user);
    }

    /**
     * devolve uma notificação
     * @param code userCode
     * @return  Lista de notificacoes
     */
    public List<Notificacao> getUserNotificacoes(String code) {
        return users.get(code).getNotificacoes();
    }

    /**
     * devolve numero de notificações de um utilizador
     * @param code userCode
     * @return Numero de notificações
     */
    public int getUserNumNotificacoes(String code) {
        return users.get(code).getNumNotificacoes();
    }

    /**
     * adiciona uma notificação a um utilizador
     * @param code      userCode
     * @param not       conteúdo notificação
     * @param type      tipo de notificação
     * @param estCode   estafeta code
     */
    public void addUserNotificacao(String code, String not, int type, String estCode) {
        users.get(code).addNotificacao(not, type, estCode);
    }

    /**
     * verifica se a encomenda esta em stand-By
     * @param enc   encCode
     * @return      true se a encomenda estiver enm standBy
     */
    public boolean getUserEncStandBy(String enc){
        return users.get(encomendas.get(enc).getUserCode()).isEncStandBy(enc);
    }

    /**
     * devolve lista de encomendas em standBy em que o estafeta é uma transportadora
     * @param userCode  userCode
     * @return          list de codigos de encomendas
     */
    public Set<String> getUserStandByTransp(String userCode){
        Set<String> list = users.get(userCode).getStandBy().stream().collect(Collectors.toSet());
        if(list.size() == 0)
            return list;
        return list.stream().filter(enc -> estafetas.get(encomendas.get(enc).getTranspCode()).getType().equals("Transportadora"))
                            .collect(Collectors.toSet());
    }

    /**
     * limpa as notificações de um utilizador
     * @param code  userCode
     */
    public void limpaUserNotificacoes(String code) {
        users.get(code).limpaNotificacoes();
    }


    /**
     * devolve lista de encomendas de um user que ocorreram entre a data min e max
     * @param code userCode
     * @param type 1 voluntario, 2 transportadora, 3 total
     * @param min  data min
     * @param max  data max
     * @return     lista de encomendas
     */
    public List<Encomenda> getUserEncbyData(String code,int type, LocalDateTime min,LocalDateTime max) {
        List<Encomenda> list = new ArrayList<>();

        for (String c : users.get(code).getEncomendas()) {
            list.add(encomendas.get(c).clone());
        }
        if(type == 1)
            list = list.stream().filter(e -> e.isEntregue() && e.isVoluntario() && e.encData(min,max)).collect(Collectors.toList());
        else if(type == 2)
            list = list.stream().filter(e -> e.isEntregue() && e.isTransportadora() && e.encData(min,max)).collect(Collectors.toList());
        else
            list = list.stream().filter(e -> e.isEntregue() && e.encData(min,max)).collect(Collectors.toList());

        return list;
    }

    /**
     * Devolve status das encomendas de um utilizador
     * @param userCode userCode
     * @return         lista strings que representa encCode e status
     */
    public List<String> getUserEncStatus(String userCode){
        List<String> list = new ArrayList<>();
        String status;

        for (String encCode : users.get(userCode).getEncomendas()) {
            if(encomendas.get(encCode).isEntregue())
                status = "entregue";
            else if(encomendas.get(encCode).isStandBy())
                status = "Stand-By";
            else if(!encomendas.get(encCode).isAceiteLoja())
                status = "não aceite na loja";
            else
                status = "por entregar";

            list.add(String.format("%6s %2s %15s", encCode, ":",status));
        }
        return list;
    }

    /**
     * devolve list de codigos de encomenda de um user prontas para ser entregues
     * @param userCode  userCode
     * @return          list de codigos de encomenda
     */
    public List<String> getEncReady(String userCode){
        return users.get(userCode).getEncomendas().stream().filter(c -> encomendas.get(c).isAceiteLoja() && !encomendas.get(c).isEntregue()).collect(Collectors.toList());
    }

    /**
     * devolve os codigos dos 10 utilizadores que receberam mais encomendas
     * @return  lista de codigos de utilizador
     */
    public List<String> getTopUsers() {
        return users.values().stream().sorted().limit(10).map(c -> String.format("%3s %2s %45s %2s %3d",c.getCodigoUtilizador(), "|", c.getName(), "|", c.getEntregasSize())).collect(Collectors.toList());
    }

    /**
     * adiciona um encCode ao standBy de um utilizador e remove-a das encomendas
     * @param userCode  userCode
     * @param encCode   encCode
     */
    public void addUserStandBy(String userCode, String encCode) {
        users.get(userCode).addStandBy(encCode);
        users.get(userCode).removeEncomenda(encCode);
        encomendas.get(encCode).setStandBy(true);
    }

    /**
     * remove uma encomenda do standBy e adiciona-a às entregues de um utilizador
     * @param userCode userCode
     * @param encCode  encCode
     */
    public void removeUserStandBy(String userCode, String encCode) {
        users.get(userCode).removeStandBy(encCode);
        users.get(userCode).addEncomenda(encCode);
    }

    /**
     * Método que retira uma encomenda de StandBy
     *
     * @param encCode   Código da encomenda que vai ser alterada
     */
    public void removeEncStandBy(String encCode) {
        encomendas.get(encCode).setStandBy(false);
    }

    /**
     * Método que verifica se uma encomenda está em StandBy
     *
     * @param encCode   Código da encomenda que vai ser consultada
     * @return          Verdadeiro se a encomenda estiver em StandBy, falso caso contrário
     */
    public boolean isEncStandBy(String encCode) {
        return encomendas.get(encCode).isStandBy();
    }


    
}
