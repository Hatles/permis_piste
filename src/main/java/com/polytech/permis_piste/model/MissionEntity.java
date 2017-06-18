package com.polytech.permis_piste.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "mission", schema = "permispiste", catalog = "")
public class MissionEntity {
    private Integer nummission;
    private Integer numjeu;
    private String libmission;
    private Collection<ObjectifEntity> objectifs = new HashSet<>();
    private JeuEntity jeu;

    public MissionEntity() {
    }

    public MissionEntity(Integer nummission, Integer numjeu, String libmission) {
        this.nummission = nummission;
        this.numjeu = numjeu;
        this.libmission = libmission;
    }

    @Id
    @Column(name = "NUMMISSION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getNummission() {
        return nummission;
    }

    public void setNummission(Integer nummission) {
        this.nummission = nummission;
    }

    @Basic
    @Column(name = "NUMJEU")
    public Integer getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(Integer numjeu) {
        this.numjeu = numjeu;
    }

    @Basic
    @Column(name = "LIBMISSION")
    public String getLibmission() {
        return libmission;
    }

    public void setLibmission(String libmission) {
        this.libmission = libmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (nummission != null ? !nummission.equals(that.nummission) : that.nummission != null) return false;
        if (numjeu != null ? !numjeu.equals(that.numjeu) : that.numjeu != null) return false;
        if (libmission != null ? !libmission.equals(that.libmission) : that.libmission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission != null ? nummission.hashCode() : 0;
        result = 31 * result + (numjeu != null ? numjeu.hashCode() : 0);
        result = 31 * result + (libmission != null ? libmission.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(name="fixe",
            joinColumns=
            @JoinColumn(name="nummission", referencedColumnName="nummission"),
            inverseJoinColumns=
            @JoinColumn(name="numobjectif", referencedColumnName="numobjectif")
    )
    public Collection<ObjectifEntity> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(Collection<ObjectifEntity> objectifs) {
        this.objectifs = objectifs;
    }

    public MissionEntity addObjectif(ObjectifEntity objectif)
    {
        this.objectifs.add(objectif);
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", nullable = false, insertable = false, updatable = false)
    public JeuEntity getJeu() {
        return jeu;
    }

    public void setJeu(JeuEntity jeu) {
        this.jeu = jeu;
    }
}
