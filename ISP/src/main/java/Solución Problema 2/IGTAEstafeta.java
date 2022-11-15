package Model;

import java.util.List;
import java.util.Set;

public interface IGTAEstafeta {
    void removeEstafetaEncRota(String transpCode,String enc);
    void addEstafetaRota(String transpCode,String rota);
    List<String> possiveisEstafetas(String enc);
    Estafeta getEstafeta(String code);
    void setEstafeta(Estafeta estafeta);
    void addEstafeta(Estafeta estafeta);
    int getEstafetaNumEnc(String transpCode);
    String getEstafetaType(String estCode);
    String getEstafetaName(String estCode);
    int getEstafetaRotaSize(String transpCode);
    Set<String> getEstafetaRota(String transpCode);
}
