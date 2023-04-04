package com.rossi21.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rossi21.dojos.models.Dojo;
import com.rossi21.dojos.models.Ninja;
import com.rossi21.dojos.services.DojoService;
import com.rossi21.dojos.services.NinjaService;


@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	

	@RequestMapping("/ninjas/new")
    public String index(Model model, @ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo) {
    	List<Ninja> ninjas = ninjaService.allNinjas();
    	List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojos", dojos);
        return "ninja.jsp";
	    }
	
	@PostMapping("/ninjas/create")
    public String create(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
        	model.addAttribute("dojos", dojos);
        	System.out.println(result);
            return "ninja.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }
}
