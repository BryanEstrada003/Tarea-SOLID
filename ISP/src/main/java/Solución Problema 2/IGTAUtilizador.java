package Model;

import java.util.List;
import java.util.Set;

public interface IGTAUtilizador {
    Utilizador getUser(String userCode);
    void setUser(Utilizador user);
    List<String> getUserEncStatus(String userCode);
    boolean getUserEncStandBy(String enc);
    Set<String> getUserStandByTransp(String userCode);
    void addUser(Utilizador user);
   
}
