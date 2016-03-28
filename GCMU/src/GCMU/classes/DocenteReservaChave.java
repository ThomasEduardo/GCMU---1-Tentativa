/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.classes;

import java.sql.Date;

/**
 *
 * @author Milena
 */
public class DocenteReservaChave {
    
    
    private int id;
    private String horaDevolucao;
    private String horaPedido;
    private Date data;
    private Chaves chaves;
    private Docente docente;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the horaDevolucao
     */
    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    /**
     * @param horaDevolucao the horaDevolucao to set
     */
    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    /**
     * @return the horaPedido
     */
    public String getHoraPedido() {
        return horaPedido;
    }

    /**
     * @param horaPedido the horaPedido to set
     */
    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the chaves
     */
    public Chaves getChaves() {
        return chaves;
    }

    /**
     * @param chaves the chaves to set
     */
    public void setChaves(Chaves chaves) {
        this.chaves = chaves;
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
    
}
