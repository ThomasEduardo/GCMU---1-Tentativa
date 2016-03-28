package GCMU.classes;

/**
 *
 * @author GCMU Essa classe representa um docente que autorizado pelo
 * administrador podera pegar chaves ou materiais
 */
public class Docente {

    private String cargo;
    private int suap;
    private String name;
    private String email;
    private String permissao;

    public Docente(String cargo, int suap, String name, String email, String permissao) {

        this.cargo = cargo;
        this.suap = suap;
        this.name = name;
        this.email = email;
        this.permissao = permissao;
    }

    public Docente() {
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the suap
     */
    public int getSuap() {
        return suap;
    }

    /**
     * @param suap the suap to set
     */
    public void setSuap(int suap) {
        this.suap = suap;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

}
