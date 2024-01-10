package org.covid19.covid19.reposirtory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.covid19.covid19.entity.Symptom;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SymptomRepository implements CrudRepository<Symptom> {
    List<Symptom> symptoms = new ArrayList<>();

    public Symptom findSymptomByName(String name) {
        return symptoms
             .stream()
             .filter(symptom -> symptom.getName().equals(name))
             .findFirst()
             .orElseThrow(null);
    }

    @Override
    public List<Symptom> findAll() {
        return symptoms;
    }
    @Override
    public Symptom save(Symptom symptom) {
        symptoms.add(symptom);

        return symptom;
    }
    @Override
    public Symptom findById(Integer id) {
        try {
            return symptoms
                  .stream()
                  .filter(symptom -> symptom.getCode().equals(id.toString())).findFirst().orElseThrow(null);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Symptom with id %d not found: %s", id, e.getMessage())
            );
        }
    }
    @Override
    public List<Symptom> update(Symptom symptom) {
        return symptoms
              .stream()
              .map(s -> {
                     if (s.getCode().equals(symptom.getCode()))
                         return symptom;

                     return s;
                 })
              .toList();
    }
    @Override
    public Symptom deleteById(Integer id) {
        try {
            var symptomToDelete = symptoms
                 .stream()
                 .filter(s -> s.getCode().equals(id))
                 .findFirst()
                 .orElseThrow(null);

            symptoms.remove(symptomToDelete);

            return symptomToDelete;
        }
        catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Symptom with id %d not found: %s", id, e.getMessage())
            );
        }
    }
}
