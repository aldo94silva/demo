package com.example.demo.Form;

import java.util.List;

import com.example.demo.Model.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DeficienciaForm {

@NotBlank(message = "Preencha o campo nome.")
    private String nome;

@NotNull(message = "Preencha o campo categoria")
    private Categoria categoria;
    private List<Categoria> listCategorias;

}
