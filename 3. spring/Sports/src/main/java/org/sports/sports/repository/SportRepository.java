package org.sports.sports.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sports.sports.entity.Sport;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportRepository implements Repository<Sport> {
    private ArrayList<Sport> sportList;

    public List<Sport> add(Sport sport) {
        if (sportList == null)
            sportList = new ArrayList<>();

        sportList.add(sport);

        return sportList;
    }
    public List<Sport> getAll() {
        return sportList;
    }
    public Sport delete(String name) {
        var elementToRemove = sportList.stream().filter(s -> s.getName().equals(name));
        sportList = (ArrayList<Sport>) sportList.stream().filter(s -> !s.getName().equals(name)).toList();

        return (Sport) elementToRemove;
    }
    public Sport getByName(String name) {
        return sportList.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
