package com.polytech.permis_piste.model;

import javax.persistence.*;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "obtient", schema = "permispiste", catalog = "")
@IdClass(ObtientEntityPK.class)
public class ObtientEntity {
    private Integer numapprenant;
    private Integer numaction;
    private Integer numjeu;
    private Integer valeur;

    private ApprenantEntity apprenant;
    private ActionEntity action;
    private JeuEntity jeu;

    public ObtientEntity() {
    }

    public ObtientEntity(Integer numapprenant, Integer numaction, Integer numjeu, Integer valeur) {
        this.numapprenant = numapprenant;
        this.numaction = numaction;
        this.numjeu = numjeu;
        this.valeur = valeur;
    }

    @Id
    @Column(name = "NUMAPPRENANT")
    public Integer getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(Integer numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Id
    @Column(name = "NUMJEU")
    public Integer getNumjeu() {
        return numaction;
    }

    public void setNumjeu(Integer numjeu) {
        this.numjeu = numjeu;
    }

    @Basic
    @Column(name = "VALEUR")
    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObtientEntity that = (ObtientEntity) o;

        if (numapprenant != null ? !numapprenant.equals(that.numapprenant) : that.numapprenant != null) return false;
        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;
        if (numjeu != null ? !numjeu.equals(that.numjeu) : that.numjeu != null) return false;
        if (valeur != null ? !valeur.equals(that.valeur) : that.valeur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant != null ? numapprenant.hashCode() : 0;
        result = 31 * result + (numaction != null ? numaction.hashCode() : 0);
        result = 31 * result + (numjeu != null ? numjeu.hashCode() : 0);
        result = 31 * result + (valeur != null ? valeur.hashCode() : 0);
        return result;
    }

    @MapsId("numapprenant")
    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "NUMAPPRENANT", nullable = false)
    public ApprenantEntity getApprenant() {
        return apprenant;
    }

    public void setApprenant(ApprenantEntity apprenant) {
        this.apprenant = apprenant;
    }

    @MapsId("numaction")
    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", nullable = false)
    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }

    @MapsId("numjeu")
    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", nullable = false)
    public JeuEntity getJeu() {
        return jeu;
    }

    public void setJeu(JeuEntity jeu) {
        this.jeu = jeu;
    }
}
