package org.sports.sports.service;

import org.sports.sports.entity.Sport;
import org.sports.sports.repository.SportRepository;

import java.util.List;

public class SportService {
    SportRepository SPORT_REPOSITORY = new SportRepository();

    List<Sport> res = SPORT_REPOSITORY.add(new Sport("Football", 1000));
    List<Sport> res2 = SPORT_REPOSITORY.add(new Sport("Baseball", 2));
    List<Sport> res3 = SPORT_REPOSITORY.add(new Sport("Basketball", 3));

    public List<Sport> getAll() {
        return SPORT_REPOSITORY.getAll();
    }
    public Sport getByName(String name) {
        return SPORT_REPOSITORY.getByName(name);
    }

}
