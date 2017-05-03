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
    private Collection<AppartientEntity> appartientsByNumjeu;
    private Collection<InscriptionEntity> inscriptionsByNumjeu;
    private Collection<MissionEntity> missionsByNumjeu;

    @Id
    @Column(name = "NUMJEU")
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

    @OneToMany(mappedBy = "jeuByNumjeu")
    public Collection<AppartientEntity> getAppartientsByNumjeu() {
        return appartientsByNumjeu;
    }

    public void setAppartientsByNumjeu(Collection<AppartientEntity> appartientsByNumjeu) {
        this.appartientsByNumjeu = appartientsByNumjeu;
    }

    @OneToMany(mappedBy = "jeuByNumjeu")
    public Collection<InscriptionEntity> getInscriptionsByNumjeu() {
        return inscriptionsByNumjeu;
    }

    public void setInscriptionsByNumjeu(Collection<InscriptionEntity> inscriptionsByNumjeu) {
        this.inscriptionsByNumjeu = inscriptionsByNumjeu;
    }

    @OneToMany(mappedBy = "jeuByNumjeu")
    public Collection<MissionEntity> getMissionsByNumjeu() {
        return missionsByNumjeu;
    }

    public void setMissionsByNumjeu(Collection<MissionEntity> missionsByNumjeu) {
        this.missionsByNumjeu = missionsByNumjeu;
    }
}
