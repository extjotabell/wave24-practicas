package com.practicas.linkTracker.repository;

import com.practicas.linkTracker.entity.Link;
import com.practicas.linkTracker.entity.PasswordHashing;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class LinkRepository implements ICrudRepository<Link> {
    private final ArrayList<Link> links;

    public LinkRepository(ArrayList<Link> links) {
        this.links = links;
    }

    @Override
    public Link save(Link link) {
        var id = this.links.size();
        link.setLinkId(id);
        link.setRedirects(0);
        link.setValid(true);

        String salt = PasswordHashing.generateSalt();
        String hashedPassword = PasswordHashing.hashPassword(link.getPassword(), salt);
        link.setPassword(hashedPassword);
        link.setSalt(salt);

        if ( this.links.add(link) )
            return link;

        return null;
    }

    @Override
    public Link update(Link link) {
        var id = this.links.indexOf(link);

        if (id != -1 ) {
            this.links.set(id, link);
            return link;
        }

        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.links.removeIf(
                link -> link.getLinkId().equals(id)
        );
    }

    @Override
    public Optional<Link> findById(Integer id) {
        return this.links.stream().filter(
                link -> link.getLinkId().equals(id)
        ).findFirst();
    }

    @Override
    public ArrayList<Link> findAll() {
        return this.links;
    }

}
