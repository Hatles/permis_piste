package com.polytech.permis_piste.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "action", schema = "permispiste", catalog = "")
public class ActionEntity {
    private Integer numaction;
    private Integer actNumaction;
    private String libaction;
    private Integer scoremin;
    private ActionEntity action;
    private Collection<ActionEntity> actions;
    private Collection<ObjectifEntity> objectifs = new HashSet<>();
    private Collection<IndicateurEntity> indicateurs;
    private Collection<ObtientEntity> scores;
    private Boolean canDo = false;

    public ActionEntity() {
    }

    public ActionEntity(Integer numaction, Integer actNumaction, String libaction, Integer scoremin) {
        this.numaction = numaction;
        this.actNumaction = actNumaction;
        this.libaction = libaction;
        this.scoremin = scoremin;
    }

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "ACT_NUMACTION")
    public Integer getActNumaction() {
        return actNumaction;
    }

    public void setActNumaction(Integer actNumaction) {
        this.actNumaction = actNumaction;
    }

    @Basic
    @Column(name = "LIBACTION")
    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

    @Basic
    @Column(name = "SCOREMIN")
    public Integer getScoremin() {
        return scoremin;
    }

    public void setScoremin(Integer scoremin) {
        this.scoremin = scoremin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;
        if (actNumaction != null ? !actNumaction.equals(that.actNumaction) : that.actNumaction != null) return false;
        if (libaction != null ? !libaction.equals(that.libaction) : that.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(that.scoremin) : that.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction != null ? numaction.hashCode() : 0;
        result = 31 * result + (actNumaction != null ? actNumaction.hashCode() : 0);
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACT_NUMACTION", referencedColumnName = "NUMACTION", insertable = false, updatable = false)
    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }

    @OneToMany(mappedBy = "action")
    public Collection<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(Collection<ActionEntity> actions) {
        this.actions = actions;
    }

    @OneToMany(mappedBy = "action")
    public Collection<IndicateurEntity> getIndicateurs() {
        return indicateurs;
    }

    public void setIndicateurs(Collection<IndicateurEntity> indicateurs) {
        this.indicateurs = indicateurs;
    }

    @OneToMany(mappedBy = "action")
    public Collection<ObtientEntity> getScores() {
        return scores;
    }

    public void setScores(Collection<ObtientEntity> scores) {
        this.scores = scores;
    }

    @ManyToMany
    @JoinTable(name="est_associe",
            joinColumns=
            @JoinColumn(name="numaction", referencedColumnName="numaction"),
            inverseJoinColumns=
            @JoinColumn(name="numobjectif", referencedColumnName="numobjectif")
    )
    public Collection<ObjectifEntity> getObjectifs() { return objectifs; }

    public void setObjectifs(Collection<ObjectifEntity> objectifs) {
        this.objectifs = objectifs;
    }

    public ActionEntity addObjectif(ObjectifEntity objectif)
    {
        this.objectifs.add(objectif);
        return this;
    }

    @Transient
    public Boolean getCanDo() { return canDo;}

    public void setCanDo(Boolean canDo) { this.canDo = canDo; }

}
