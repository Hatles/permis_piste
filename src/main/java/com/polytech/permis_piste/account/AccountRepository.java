package com.polytech.permis_piste.account;

import com.polytech.permis_piste.model.ApprenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findOneByEmail(String email);

	@Query("select count(a) > 0 from Account a where a.email = :email")
	boolean exists(@Param("email") String email);
/*
	@Query("delete from Account a where a.apprenant = :apprenantEntity")
	void deleteByApprenant(ApprenantEntity apprenantEntity);*/
	void deleteAccountByApprenant(ApprenantEntity apprenantEntity);

}