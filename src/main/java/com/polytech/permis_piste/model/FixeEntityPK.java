package com.polytech.permis_piste.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kifkif on 03/05/2017.
 */
public class FixeEntityPK implements Serializable {
    private Integer nummission;
    private Integer numobjectif;

    @Column(name = "NUMMISSION", insertable = false, updatable = false)
    @Id
    public Integer getNummission() {
        return nummission;
    }

    public void setNummission(Integer nummission) {
        this.nummission = nummission;
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

        FixeEntityPK that = (FixeEntityPK) o;

        if (nummission != null ? !nummission.equals(that.nummission) : that.nummission != null) return false;
        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission != null ? nummission.hashCode() : 0;
        result = 31 * result + (numobjectif != null ? numobjectif.hashCode() : 0);
        return result;
    }
}
