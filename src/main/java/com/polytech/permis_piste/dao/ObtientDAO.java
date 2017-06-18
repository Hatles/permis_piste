package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.EstAssocieEntity;
import com.polytech.permis_piste.model.ObjectifEntity;
import com.polytech.permis_piste.model.ObtientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by coren on 17/06/2017.
 */
public interface ObtientDAO extends JpaRepository<ObtientEntity, Integer> {
}
