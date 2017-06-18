package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.ObtientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by coren on 17/06/2017.
 */
public interface ObtientDAO extends JpaRepository<ObtientEntity, Integer> {
}
