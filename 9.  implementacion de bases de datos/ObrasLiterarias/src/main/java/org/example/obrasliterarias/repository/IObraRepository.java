package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra, Long> {

    //Retornar las obras de un autor dado por el usuario.
    List<Obra> findByAutor(String autor);

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    List<Obra> findByNombreContaining(String nombre);
}
