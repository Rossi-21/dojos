package com.rossi21.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rossi21.dojos.models.Dojo;
import com.rossi21.dojos.repositories.DojoRepository;

@Service
public class DojoService {
	 // adding the dojo repository as a dependency
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the dojo's
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
	public Dojo updateDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
