package com.polytech.permis_piste.model;

import javax.persistence.*;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "inscription", schema = "permispiste", catalog = "")
@IdClass(InscriptionEntityPK.class)
public class InscriptionEntity {
    private Integer numapprenant;
    private Integer numjeu;
    private ApprenantEntity apprenantByNumapprenant;
    private JeuEntity jeuByNumjeu;

    @Id
    @Column(name = "NUMAPPRENANT")
    public Integer getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(Integer numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Id
    @Column(name = "NUMJEU")
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

        InscriptionEntity that = (InscriptionEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "NUMAPPRENANT", nullable = false)
    public ApprenantEntity getApprenantByNumapprenant() {
        return apprenantByNumapprenant;
    }

    public void setApprenantByNumapprenant(ApprenantEntity apprenantByNumapprenant) {
        this.apprenantByNumapprenant = apprenantByNumapprenant;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", nullable = false)
    public JeuEntity getJeuByNumjeu() {
        return jeuByNumjeu;
    }

    public void setJeuByNumjeu(JeuEntity jeuByNumjeu) {
        this.jeuByNumjeu = jeuByNumjeu;
    }
}
