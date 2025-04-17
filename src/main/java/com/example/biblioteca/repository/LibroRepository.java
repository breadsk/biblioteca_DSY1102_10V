package com.example.biblioteca.repository;

import com.example.biblioteca.model.Libro;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;


@Repository
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    @PostConstruct
    public void init(){
        listaLibros.add(new Libro(1, "978-0134685991", "Effective Java", "Addison-Wesley", 2018, "Joshua Bloch"));
        listaLibros.add(new Libro(2, "978-1617294945", "Spring in Action", "Manning", 2020, "Craig Walls"));
        listaLibros.add(new Libro(3, "978-1491950357", "Designing Data-Intensive Applications", "O'Reilly Media", 2017, "Martin Kleppmann"));
        listaLibros.add(new Libro(4, "978-0132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro buscarLibroPorId(int id){

        for(Libro libro : listaLibros){
            if(libro.getId() == id) return libro;
        }
        return null;
    }

    public Libro buscarLibroPorIsnb(String isbn){        
        
        for(Libro libro : listaLibros){            
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    
    public Libro buscarLibroPorAutor(String autor){

        for(Libro libro : listaLibros){
            if(libro.getAutor().equals(autor)) return libro;
        }
        return null;
    }

    public Libro guardarLibro(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizarLibro(Libro lib){

        int id = 0;
        int idPosicion = 0;

        for(int i=0;i<listaLibros.size();i++){
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion,libro1);
        return libro1;
    }

    public void eliminarLibro(int id){

        //Alternativa 1
        Libro libro = buscarLibroPorId(id);
        if(libro != null){
            listaLibros.remove(libro);
        }
        
        //ALternativa 2
        int idPosicion = 0;
        for(int i = 0;i<listaLibros.size();i++){
            if(listaLibros.get(i).getId() == id){
                idPosicion = i;
                break;
            }
        }
        if(idPosicion > 0){
            listaLibros.remove(idPosicion);
        }

        listaLibros.removeIf((x) -> x.getId() == id);
    }

}
