package Model;


public interface IGTALogin {
    Login getLogin(String code);
    void setLogin(Login login);
    void addLogin(Login login);
    boolean containsPassword(String code, String password);
    boolean containsNameAndType(String name, String type);
   
}
