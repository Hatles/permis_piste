package com.polytech.permis_piste.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "apprenant", schema = "permispiste", catalog = "")
public class ApprenantEntity {
    private Integer numapprenant;
    private String nomapprenant;
    private String prenomapprenant;
    private Collection<JeuEntity> jeux;
    private Collection<ObtientEntity> scores;

    public ApprenantEntity() {
    }

    public ApprenantEntity(String nomapprenant, String prenomapprenant) {
        this.nomapprenant = nomapprenant;
        this.prenomapprenant = prenomapprenant;
    }

    public ApprenantEntity(Integer numapprenant, String nomapprenant, String prenomapprenant) {
        this.numapprenant = numapprenant;
        this.nomapprenant = nomapprenant;
        this.prenomapprenant = prenomapprenant;
    }

    @Id
    @Column(name = "NUMAPPRENANT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(Integer numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Basic
    @Column(name = "NOMAPPRENANT")
    public String getNomapprenant() {
        return nomapprenant;
    }

    public void setNomapprenant(String nomapprenant) {
        this.nomapprenant = nomapprenant;
    }

    @Basic
    @Column(name = "PRENOMAPPRENANT")
    public String getPrenomapprenant() {
        return prenomapprenant;
    }

    public void setPrenomapprenant(String prenomapprenant) {
        this.prenomapprenant = prenomapprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (numapprenant != null ? !numapprenant.equals(that.numapprenant) : that.numapprenant != null) return false;
        if (nomapprenant != null ? !nomapprenant.equals(that.nomapprenant) : that.nomapprenant != null) return false;
        if (prenomapprenant != null ? !prenomapprenant.equals(that.prenomapprenant) : that.prenomapprenant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant != null ? numapprenant.hashCode() : 0;
        result = 31 * result + (nomapprenant != null ? nomapprenant.hashCode() : 0);
        result = 31 * result + (prenomapprenant != null ? prenomapprenant.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(
            name="inscription",
            joinColumns = @JoinColumn( name="numapprenant"),
            inverseJoinColumns = @JoinColumn( name="numjeu")
    )
    public Collection<JeuEntity> getJeux() {
        return jeux;
    }

    public void setJeux(Collection<JeuEntity> jeux) {
        this.jeux = jeux;
    }

    @OneToMany(mappedBy = "apprenant")
    public Collection<ObtientEntity> getScores() {
        return scores;
    }

    public void setScores(Collection<ObtientEntity> scores) {
        this.scores = scores;
    }
}
