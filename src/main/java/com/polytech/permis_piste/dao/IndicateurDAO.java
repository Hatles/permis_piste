package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.IndicateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kifkif on 18/06/2017.
 */
public interface IndicateurDAO extends JpaRepository<IndicateurEntity, Integer> {
}
