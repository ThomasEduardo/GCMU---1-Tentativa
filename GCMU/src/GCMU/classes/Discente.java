package GCMU.classes;

/**
 *
 * @author GCMU Essa classe representa um discente que autorizado pelo
 * administrador podera pegar chaves ou materiais
 */
public class Discente{
       
    private int matricula;
    private String curso;
    private String name;
    private String email;
    private String permissao;

    public Discente(int matricula, String curso, String name, String email, String permissao) {

        this.curso = curso;
        this.matricula = matricula;
        this.name = name;
        this.email = email;
        this.permissao = permissao;
    }

    public Discente() {
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
