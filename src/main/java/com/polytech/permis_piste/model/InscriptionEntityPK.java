package com.polytech.permis_piste.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kifkif on 03/05/2017.
 */
public class InscriptionEntityPK implements Serializable {
    private Integer numapprenant;
    private Integer numjeu;

    @Column(name = "NUMAPPRENANT", insertable = false, updatable = false)
    @Id
    public Integer getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(Integer numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Column(name = "NUMJEU", insertable = false, updatable = false)
    @Id
    public Integer getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(Integer numjeu) {
        this.numjeu = numjeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntityPK that = (InscriptionEntityPK) o;

        if (numapprenant != null ? !numapprenant.equals(that.numapprenant) : that.numapprenant != null) return false;
        if (numjeu != null ? !numjeu.equals(that.numjeu) : that.numjeu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant != null ? numapprenant.hashCode() : 0;
        result = 31 * result + (numjeu != null ? numjeu.hashCode() : 0);
        return result;
    }
}
