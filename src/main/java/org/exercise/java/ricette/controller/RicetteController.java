package org.exercise.java.ricette.controller;

import jakarta.validation.Valid;
import org.exercise.java.ricette.model.Ricetta;
import org.exercise.java.ricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ricette")
public class RicetteController {
    @Autowired
    private RicettaRepository ricettaRepository;

    @GetMapping
    public String ricette(Model model) {
        List<Ricetta> ricettaList = ricettaRepository.findAll();
        model.addAttribute("ricettaList", ricettaList);
        return ("/list");
    }

    @GetMapping("/show/{ricettaId}")
    public String show(@PathVariable("ricettaId") Integer id, Model model) {
        Optional<Ricetta> ricettaOptional = ricettaRepository.findById(id);
        if (ricettaOptional.isPresent()) {
            Ricetta ricettaFromDb = ricettaOptional.get();
            model.addAttribute("ricetta", ricettaFromDb);
            return "/details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("nuovaRicetta", new Ricetta());
        return "/form";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("nuovaRicetta") Ricetta ricettaForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/form";
        } else {
            ricettaRepository.save(ricettaForm);
            return "redirect:/ricette";
        }
    }
}
