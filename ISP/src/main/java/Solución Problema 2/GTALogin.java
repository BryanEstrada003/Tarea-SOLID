/**
 * classe que representa o modelo de projeto
 */
package Model;


public class GTALogin extends GestTrazAqui implements IGTALogin{

    /**
     * devolve login
     * @param code loginCode
     * @return     login
     */
    public Login getLogin(String code) {
        return loginMap.get(code).clone();
    }

    /**
     * altera login
     * @param login login
     */
    public void setLogin(Login login) {
        loginMap.replace(login.getCode(), login);
    }

    /**
     * adiciona login
     * @param login login
     */
    public void addLogin(Login login) { loginMap.put(login.getCode(), login);}

    /**
     * verifica se o loginUser existe
     * @param code  loginCode
     * @return      true se existe
     */
    public boolean containsUser(String code) {
        return loginMap.containsKey(code);
    }

    /**
     * verifica se o login existe
     * @param code      loginCode
     * @param password  password
     * @return          true se existe
     */
    public boolean containsPassword(String code, String password) {
        return loginMap.get(code).getPassword().equals(password);
    }

    /**
     * verifica se o login existe
     * @param  name  login name
     * @param  type  tipo de conta
     * @return      true se existe
     */
    public boolean containsNameAndType(String name, String type) {
        return loginMap.values().stream().filter(c -> c.getNome().equals(name)).anyMatch(c -> c.getTipoConta().equals(type));
    }

    
}
