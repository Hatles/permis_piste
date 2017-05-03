package com.polytech.permis_piste.model;

import javax.persistence.*;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "est_associe", schema = "permispiste", catalog = "")
@IdClass(EstAssocieEntityPK.class)
public class EstAssocieEntity {
    private Integer numaction;
    private Integer numobjectif;
    private ActionEntity actionByNumaction;
    private ObjectifEntity objectifByNumobjectif;

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Id
    @Column(name = "NUMOBJECTIF")
    public Integer getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(Integer numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstAssocieEntity that = (EstAssocieEntity) o;

        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;
        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction != null ? numaction.hashCode() : 0;
        result = 31 * result + (numobjectif != null ? numobjectif.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMACTION", referencedColumnName = "NUMACTION", nullable = false)
    public ActionEntity getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(ActionEntity actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }

    @ManyToOne
    @JoinColumn(name = "NUMOBJECTIF", referencedColumnName = "NUMOBJECTIF", nullable = false)
    public ObjectifEntity getObjectifByNumobjectif() {
        return objectifByNumobjectif;
    }

    public void setObjectifByNumobjectif(ObjectifEntity objectifByNumobjectif) {
        this.objectifByNumobjectif = objectifByNumobjectif;
    }
}
