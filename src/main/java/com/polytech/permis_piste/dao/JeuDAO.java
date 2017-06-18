package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by coren on 17/06/2017.
 */
public interface JeuDAO extends JpaRepository<JeuEntity, Integer> {
    JeuEntity findByLibellejeu(String lib);
}
