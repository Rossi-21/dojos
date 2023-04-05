package com.rossi21.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rossi21.dojos.models.Dojo;
import com.rossi21.dojos.services.DojoService;
import com.rossi21.dojos.services.NinjaService;

@Controller
public class DojoController {

	@Autowired
	DojoService dojoService;
	NinjaService ninjaService;
	
	@RequestMapping("/dojos/new")
    public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
    	List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "index.jsp";
    }
	
    @PostMapping("/dojos/create")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }
    
    @RequestMapping("/dojos/{id}")
	public String dojo(Model model, @PathVariable("id")Long id) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
}
