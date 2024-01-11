package com.example.blog.repositories.implementations;

import com.example.blog.entities.EntradaBlog;
import com.example.blog.exceptions.customExceptions.UnableToCreateException;
import com.example.blog.repositories.interfaces.CrudRepository;
import com.example.blog.utils.UserAction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepository implements CrudRepository<EntradaBlog> {

    private static List<EntradaBlog> entradas = List.of(
            new EntradaBlog(1L, "Primer post", "Juan", null),
            new EntradaBlog(2L, "Segundo post", "Juan", null),
            new EntradaBlog(3L, "Tercer post", "Juan", null),
            new EntradaBlog(4L, "Cuarto post", "Juan", null),
            new EntradaBlog(5L, "Quinto post", "Juan", null)
    );

    @Override
    public EntradaBlog findById(Long id) {
        return entradas.stream()
                .filter(entradaBlog -> entradaBlog.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        if(entradaBlog.getId() == null) {
            entradaBlog.setId(entradaBlog.getNewContador());
        }

        if(findById(entradaBlog.getId()) != null){
            throw new UnableToCreateException("Entrada ya existe", UserAction.CREATE, EntradaBlog.class, "El ID ya existe");
        }

        entradas.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradas;
    }
}
