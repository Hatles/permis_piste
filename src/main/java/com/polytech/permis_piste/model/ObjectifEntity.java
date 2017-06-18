package com.polytech.permis_piste.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "objectif", schema = "permispiste", catalog = "")
public class ObjectifEntity {
    private Integer numobjectif;
    private String libobjectif;
    private Collection<ActionEntity> actions = new HashSet<>();
    private Collection<MissionEntity> missions = new HashSet<>();

    public ObjectifEntity() {
    }

    public ObjectifEntity(Integer numobjectif, String libobjectif) {
        this.numobjectif = numobjectif;
        this.libobjectif = libobjectif;
    }

    @Id
    @Column(name = "NUMOBJECTIF")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(Integer numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Basic
    @Column(name = "LIBOBJECTIF")
    public String getLibobjectif() {
        return libobjectif;
    }

    public void setLibobjectif(String libobectif) {
        this.libobjectif = libobectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectifEntity that = (ObjectifEntity) o;

        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;
        if (libobjectif != null ? !libobjectif.equals(that.libobjectif) : that.libobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numobjectif != null ? numobjectif.hashCode() : 0;
        result = 31 * result + (libobjectif != null ? libobjectif.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "objectifs")
    public Collection<MissionEntity> getMissions() {
        return missions;
    }

    public void setMissions(Collection<MissionEntity> missions) {
        this.missions = missions;
    }

    @ManyToMany(mappedBy = "objectifs")
    public Collection<ActionEntity> getActions() { return actions; }

    public void setActions(Collection<ActionEntity> actions) {
        this.actions = actions;
    }

    public ObjectifEntity addAction(ActionEntity action) {
        this.actions.add(action);
        return this;
    }
}
