package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Form.DeficienciaForm;

import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;



@Controller
public class DeficienciaController {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/deficiencia")
    public String index(Model model, @RequestParam("display") Optional<String> display){
    
        String finalDisplay = display.orElse("true");

        List<Deficiencia> deficiencias = deficienciaRepository.findByAtivo(Boolean.valueOf(finalDisplay));

        model.addAttribute("deficiencias", deficiencias);
        return "deficiencia/listar";
    }

    @GetMapping("/deficiencia/create")
    public String create(Model model) {
        DeficienciaForm deficienaForm = new DeficienciaForm();
        
        // List<Categoria> listCategorias = categoriaRepository.findAll();
        // DeficienciaForm.setlistCategorias(listCategorias);

        model.addAttribute("deficienaForm", deficienaForm);

        return "deficiencia/create";
    }

}
