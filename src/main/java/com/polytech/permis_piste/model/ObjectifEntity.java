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
    private String libobectif;
    private Collection<ActionEntity> actions = new HashSet<>();
    private Collection<MissionEntity> missions = new HashSet<>();

    public ObjectifEntity() {
    }

    public ObjectifEntity(Integer numobjectif, String libobectif) {
        this.numobjectif = numobjectif;
        this.libobectif = libobectif;
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
