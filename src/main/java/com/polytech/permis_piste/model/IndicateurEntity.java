package com.polytech.permis_piste.model;

import javax.persistence.*;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "indicateur", schema = "permispiste", catalog = "")
public class IndicateurEntity {
    private Integer numindic;
    private Integer numaction;
    private Integer poids;
    private ActionEntity actionByNumaction;

    @Id
    @Column(name = "NUMINDIC")
    public Integer getNumindic() {
        return numindic;
    }

    public void setNumindic(Integer numindic) {
        this.numindic = numindic;
    }

    @Basic
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "POIDS")
    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicateurEntity that = (IndicateurEntity) o;

        if (numindic != null ? !numindic.equals(that.numindic) : that.numindic != null) return false;
        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;
        if (poids != null ? !poids.equals(that.poids) : that.poids != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numindic != null ? numindic.hashCode() : 0;
        result = 31 * result + (numaction != null ? numaction.hashCode() : 0);
        result = 31 * result + (poids != null ? poids.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", nullable = false, insertable = false, updatable = false)
    public ActionEntity getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(ActionEntity actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }
}
