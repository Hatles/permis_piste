package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.FixeEntity;
import com.polytech.permis_piste.model.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by coren on 17/06/2017.
 */
public interface FixeDAO extends JpaRepository<FixeEntity, Integer> {
}
