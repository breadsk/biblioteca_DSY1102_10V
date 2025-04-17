package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;


    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroService.obtenerLibros();
    }
    
    @GetMapping("{id}")
    public Libro buscarLibroPorId(@PathVariable int id) {
         return libroService.buscarLibroPorId(id);
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarLibroPorIsbn(@PathVariable String isbn) {
         return libroService.buscarLibroPorIsbn(isbn);
    }

    @GetMapping("/autor/{autor}")
    public Libro buscarLibroPorAutor(@PathVariable String autor) {
         return libroService.buscarLibroPorAutor(autor);
    }

    @PostMapping
    public Libro guardaLibro(@RequestBody Libro libro) {    
        return libroService.guardarLibro(libro);
    }
    
    

}
