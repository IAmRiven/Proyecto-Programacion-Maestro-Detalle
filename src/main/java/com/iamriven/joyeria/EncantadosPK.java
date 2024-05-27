/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iamriven.joyeria;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juan Antonio
 */
@Embeddable
public class EncantadosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idNivel")
    private int idNivel;
    @Basic(optional = false)
    @Column(name = "idjoyeria")
    private int idjoyeria;

    public EncantadosPK() {
    }

    public EncantadosPK(int idNivel, int idjoyeria) {
        this.idNivel = idNivel;
        this.idjoyeria = idjoyeria;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdjoyeria() {
        return idjoyeria;
    }

    public void setIdjoyeria(int idjoyeria) {
        this.idjoyeria = idjoyeria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idNivel;
        hash += (int) idjoyeria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncantadosPK)) {
            return false;
        }
        EncantadosPK other = (EncantadosPK) object;
        if (this.idNivel != other.idNivel) {
            return false;
        }
        if (this.idjoyeria != other.idjoyeria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iamriven.joyeria.EncantadosPK[ idNivel=" + idNivel + ", idjoyeria=" + idjoyeria + " ]";
    }
    
}
