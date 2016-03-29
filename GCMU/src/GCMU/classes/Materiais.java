package GCMU.classes;

/**
 *
 * @author GCMU Essa classe representa a entidade materiais que podera ser
 * reservado por um discente ou docente, sendo essa a responsavel por conter as
 * inorma��es dos materiais
 */
public class Materiais {

    private int id;
    private String tipo;
    private String status;
    private String observacao;
    private int numeroSala;
    private String nomeSala;
    private DocenteReservaMaterial docenteReserva;
    private Docente docente;
    private DiscenteReservaMaterial discenteReserva;
    private Discente discente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {

        return tipo;

    }

    public void setTipo(String tipo) {

        this.tipo = tipo;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public String getObservacao() {

        return observacao;

    }

    public void setObservacao(String observacao) {

        this.observacao = observacao;

    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    /**
     * @return the docenteReserva
     */
    public DocenteReservaMaterial getDocenteReserva() {
        return docenteReserva;
    }

    /**
     * @param docenteReserva the docenteReserva to set
     */
    public void setDocenteReserva(DocenteReservaMaterial docenteReserva) {
        this.docenteReserva = docenteReserva;
    }

    /**
     * @return the docente
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return the discenteReserva
     */
    public DiscenteReservaMaterial getDiscenteReserva() {
        return discenteReserva;
    }

    /**
     * @param discenteReserva the discenteReserva to set
     */
    public void setDiscenteReserva(DiscenteReservaMaterial discenteReserva) {
        this.discenteReserva = discenteReserva;
    }

    /**
     * @return the discente
     */
    public Discente getDiscente() {
        return discente;
    }

    /**
     * @param discente the discente to set
     */
    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

}
