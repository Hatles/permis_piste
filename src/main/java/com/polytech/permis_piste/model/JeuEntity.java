package com.polytech.permis_piste.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "jeu", schema = "permispiste", catalog = "")
public class JeuEntity {
    private Integer numjeu;
    private String libellejeu;
    private Collection<ApprenantEntity> apprenants;
    private Collection<MissionEntity> missions;

    public JeuEntity() {
    }

    public JeuEntity(Integer numjeu, String libellejeu) {
        this.numjeu = numjeu;
        this.libellejeu = libellejeu;
    }

    @Id
    @Column(name = "NUMJEU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(Integer numjeu) {
        this.numjeu = numjeu;
    }

    @Basic
    @Column(name = "LIBELLEJEU")
    public String getLibellejeu() {
        return libellejeu;
    }

    public void setLibellejeu(String libellejeu) {
        this.libellejeu = libellejeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeuEntity jeuEntity = (JeuEntity) o;

        if (numjeu != null ? !numjeu.equals(jeuEntity.numjeu) : jeuEntity.numjeu != null) return false;
        if (libellejeu != null ? !libellejeu.equals(jeuEntity.libellejeu) : jeuEntity.libellejeu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu != null ? numjeu.hashCode() : 0;
        result = 31 * result + (libellejeu != null ? libellejeu.hashCode() : 0);
        return result;
    }


    @ManyToMany(mappedBy = "jeux")
    public Collection<ApprenantEntity> getApprenants() {
        return apprenants;
    }

    public void setApprenants(Collection<ApprenantEntity> apprenants) {
        this.apprenants = apprenants;
    }

    @OneToMany(mappedBy = "jeu")
    public Collection<MissionEntity> getMissions() {
        return missions;
    }

    public void setMissions(Collection<MissionEntity> missions) {
        this.missions = missions;
    }
}
