package com.polytech.permis_piste.model;

import javax.persistence.*;

/**
 * Created by kifkif on 03/05/2017.
 */
@Entity
@Table(name = "fixe", schema = "permispiste", catalog = "")
@IdClass(FixeEntityPK.class)
public class FixeEntity {
    private Integer nummission;
    private Integer numobjectif;
    private MissionEntity missionByNummission;
    private ObjectifEntity objectifByNumobjectif;

    @Id
    @Column(name = "NUMMISSION")
    public Integer getNummission() {
        return nummission;
    }

    public void setNummission(Integer nummission) {
        this.nummission = nummission;
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

        FixeEntity that = (FixeEntity) o;

        if (nummission != null ? !nummission.equals(that.nummission) : that.nummission != null) return false;
        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission != null ? nummission.hashCode() : 0;
        result = 31 * result + (numobjectif != null ? numobjectif.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMMISSION", referencedColumnName = "NUMMISSION", nullable = false)
    public MissionEntity getMissionByNummission() {
        return missionByNummission;
    }

    public void setMissionByNummission(MissionEntity missionByNummission) {
        this.missionByNummission = missionByNummission;
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
