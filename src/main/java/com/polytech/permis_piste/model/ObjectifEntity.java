package com.polytech.permis_piste.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "objectif", schema = "permispiste", catalog = "")
public class ObjectifEntity {
    private Integer numobjectif;
    private String libobectif;
    private Collection<EstAssocieEntity> estAssociesByNumobjectif;
    private Collection<FixeEntity> fixesByNumobjectif;

    @Id
    @Column(name = "NUMOBJECTIF")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(Integer numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Basic
    @Column(name = "LIBOBECTIF")
    public String getLibobectif() {
        return libobectif;
    }

    public void setLibobectif(String libobectif) {
        this.libobectif = libobectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectifEntity that = (ObjectifEntity) o;

        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;
        if (libobectif != null ? !libobectif.equals(that.libobectif) : that.libobectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numobjectif != null ? numobjectif.hashCode() : 0;
        result = 31 * result + (libobectif != null ? libobectif.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "objectifByNumobjectif")
    public Collection<EstAssocieEntity> getEstAssociesByNumobjectif() {
        return estAssociesByNumobjectif;
    }

    public void setEstAssociesByNumobjectif(Collection<EstAssocieEntity> estAssociesByNumobjectif) {
        this.estAssociesByNumobjectif = estAssociesByNumobjectif;
    }

    @OneToMany(mappedBy = "objectifByNumobjectif")
    public Collection<FixeEntity> getFixesByNumobjectif() {
        return fixesByNumobjectif;
    }

    public void setFixesByNumobjectif(Collection<FixeEntity> fixesByNumobjectif) {
        this.fixesByNumobjectif = fixesByNumobjectif;
    }
}
