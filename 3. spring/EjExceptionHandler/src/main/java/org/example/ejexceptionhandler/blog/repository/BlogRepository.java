package org.example.ejexceptionhandler.blog.repository;

import org.example.ejexceptionhandler.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<EntradaBlog> entradaBlogList = new ArrayList<EntradaBlog>();
    public BlogRepository() {

    }

    @Override
    public Optional<EntradaBlog> findById(Long id) {
        return entradaBlogList.stream().filter(entradaBlog -> Objects.equals(id, entradaBlog.getId())).findFirst();
    }
}
