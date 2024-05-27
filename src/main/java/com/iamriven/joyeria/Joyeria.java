/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iamriven.joyeria;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Juan Antonio
 */
@Entity
@Table(name = "joyeria")
@NamedQueries({
    @NamedQuery(name = "Joyeria.findAll", query = "SELECT j FROM Joyeria j"),
    @NamedQuery(name = "Joyeria.findByIdjoyeria", query = "SELECT j FROM Joyeria j WHERE j.idjoyeria = :idjoyeria"),
    @NamedQuery(name = "Joyeria.findByNombre", query = "SELECT j FROM Joyeria j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Joyeria.findByTipo", query = "SELECT j FROM Joyeria j WHERE j.tipo = :tipo")})
public class Joyeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idjoyeria")
    private Integer idjoyeria;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joyeria")
    private Collection<Encantados> encantadosCollection;

    public Joyeria() {
    }

    public Joyeria(Integer idjoyeria) {
        this.idjoyeria = idjoyeria;
    }

    public Joyeria(Integer idjoyeria, String nombre, String tipo) {
        this.idjoyeria = idjoyeria;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getIdjoyeria() {
        return idjoyeria;
    }

    public void setIdjoyeria(Integer idjoyeria) {
        this.idjoyeria = idjoyeria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<Encantados> getEncantadosCollection() {
        return encantadosCollection;
    }

    public void setEncantadosCollection(Collection<Encantados> encantadosCollection) {
        this.encantadosCollection = encantadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjoyeria != null ? idjoyeria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joyeria)) {
            return false;
        }
        Joyeria other = (Joyeria) object;
        if ((this.idjoyeria == null && other.idjoyeria != null) || (this.idjoyeria != null && !this.idjoyeria.equals(other.idjoyeria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iamriven.joyeria.Joyeria[ idjoyeria=" + idjoyeria + " ]";
    }
    
}
