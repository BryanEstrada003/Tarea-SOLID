package Model;

import java.util.List;
import java.util.Set;

public interface IGTAEncomenda {
    Encomenda getEncomenda(String encCode);
    void setEncomenda(Encomenda enc);
    void addEncomenda(Encomenda encomenda);
    Set<String> encomendasAceites();
    boolean isEncomendaAceite(String encCode);
    double precoEncomenda(String encCode,String transpCode);
    String getEncUser(String encCode);
    String getEncUserName(String encCode);
    String getEncTransp(String encCode);
    void sugerirTransp(String enc,String transpCode);
}
