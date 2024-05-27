/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iamriven.joyeria;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Juan Antonio
 */
@Entity
@Table(name = "encantados")
@NamedQueries({
        @NamedQuery(name = "Encantados.findAll", query = "SELECT e FROM Encantados e"),
        @NamedQuery(name = "Encantados.findByIdNivel", query = "SELECT e FROM Encantados e WHERE e.encantadosPK.idNivel = :idNivel"),
        @NamedQuery(name = "Encantados.findByIdjoyeria", query = "SELECT e FROM Encantados e WHERE e.encantadosPK.idjoyeria = :idjoyeria"),
        @NamedQuery(name = "Encantados.findByNivel", query = "SELECT e FROM Encantados e WHERE e.nivel = :nivel"),
        @NamedQuery(name = "Encantados.findByPrecio", query = "SELECT e FROM Encantados e WHERE e.precio = :precio"),
        @NamedQuery(name = "Encantados.findByAp", query = "SELECT e FROM Encantados e WHERE e.ap = :ap"),
        @NamedQuery(name = "Encantados.findByAccuracy", query = "SELECT e FROM Encantados e WHERE e.accuracy = :accuracy"),
        @NamedQuery(name = "Encantados.findByEvasion", query = "SELECT e FROM Encantados e WHERE e.evasion = :evasion"),
        @NamedQuery(name = "Encantados.findByNombre", query = "SELECT e FROM Encantados e WHERE e.nombre = :nombre") })
public class Encantados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncantadosPK encantadosPK;
    @Basic(optional = false)
    @Column(name = "nivel")
    private int nivel;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "ap")
    private int ap;
    @Basic(optional = false)
    @Column(name = "accuracy")
    private int accuracy;
    @Basic(optional = false)
    @Column(name = "evasion")
    private int evasion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idjoyeria", referencedColumnName = "idjoyeria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Joyeria joyeria;

    public Encantados() {
        this.encantadosPK = new EncantadosPK();
    }

    public Encantados(EncantadosPK encantadosPK) {
        this.encantadosPK = encantadosPK;
    }

    public Encantados(EncantadosPK encantadosPK, int nivel, int precio, int ap, int accuracy, int evasion,
            String nombre) {
        this.encantadosPK = encantadosPK;
        this.nivel = nivel;
        this.precio = precio;
        this.ap = ap;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.nombre = nombre;
    }

    public Encantados(int idNivel, int idjoyeria) {
        this.encantadosPK = new EncantadosPK(idNivel, idjoyeria);
    }

    public EncantadosPK getEncantadosPK() {
        return encantadosPK;
    }

    public void setEncantadosPK(EncantadosPK encantadosPK) {
        this.encantadosPK = encantadosPK;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Joyeria getJoyeria() {
        return joyeria;
    }

    public void setJoyeria(Joyeria joyeria) {
        this.joyeria = joyeria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encantadosPK != null ? encantadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encantados)) {
            return false;
        }
        Encantados other = (Encantados) object;
        if ((this.encantadosPK == null && other.encantadosPK != null)
                || (this.encantadosPK != null && !this.encantadosPK.equals(other.encantadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iamriven.joyeria.Encantados[ encantadosPK=" + encantadosPK + " ]";
    }

}
