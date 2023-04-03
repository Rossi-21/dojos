package com.rossi21.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rossi21.dojos.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	List<Ninja> findByFirst_NameContaining(String search);
	Long countByFirst_NameContaining(String search);
	Long deleteByFirst_NameStartingWith(String search);
}
