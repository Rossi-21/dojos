package com.rossi21.dojos.services;

import java.util.List;
import java.util.Optional;

import com.rossi21.dojos.models.Ninja;
import com.rossi21.dojos.repositories.NinjaRepository;

public class NinjaService {
	 // adding the travel repository as a dependency
    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // returns all the travel's
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a travel
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    // retrieves a travel
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	public Ninja updateTravel(Ninja n) {
		return ninjaRepository.save(n);
	}
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
