package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra, Long> {

    //Retornar las obras de un autor dado por el usuario.
    List<Obra> findByAutor(String autor);

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    List<Obra> findByNombreContaining(String nombre);

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario
    List<Obra> findByCantidadPaginasGreaterThan(Integer cantidadPaginas);

    //Retornar las obras de una misma editorial
    List<Obra> findByEditorial(String editorial);

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    List<Obra> findByAnioPublicacionBefore(Integer anioPublicacion);

    List<Obra> findByAnioPublicacionAfter(Integer anioPublicacion);
}
