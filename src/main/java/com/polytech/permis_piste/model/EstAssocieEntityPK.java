package com.polytech.permis_piste.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kifkif on 03/05/2017.
 */
public class EstAssocieEntityPK implements Serializable {
    private Integer numaction;
    private Integer numobjectif;

    @Column(name = "NUMACTION", insertable = false, updatable = false)
    @Id
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Column(name = "NUMOBJECTIF", insertable = false, updatable = false)
    @Id
    public Integer getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(Integer numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstAssocieEntityPK that = (EstAssocieEntityPK) o;

        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;
        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction != null ? numaction.hashCode() : 0;
        result = 31 * result + (numobjectif != null ? numobjectif.hashCode() : 0);
        return result;
    }
}
