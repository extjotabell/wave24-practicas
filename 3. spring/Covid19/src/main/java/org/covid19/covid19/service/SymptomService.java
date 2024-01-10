package org.covid19.covid19.service;

import org.covid19.covid19.entity.Symptom;
import org.covid19.covid19.reposirtory.SymptomRepository;

import java.util.List;

public class SymptomService {
    private static final SymptomRepository SYMPTOM_REPOSITORY = new SymptomRepository();

    public List<Symptom> findAll() {
        return SYMPTOM_REPOSITORY.findAll();
    }
    public Symptom save(Symptom symptom) {
        return SYMPTOM_REPOSITORY.save(symptom);
    }
    public Symptom findById(Integer id) {
        return SYMPTOM_REPOSITORY.findById(id);
    }
    public List<Symptom> update(Symptom symptom) {
        return SYMPTOM_REPOSITORY.update(symptom);
    }
    public Symptom deleteById(Integer id) {
        return SYMPTOM_REPOSITORY.deleteById(id);
    }
    public Symptom findSymptomByName(String name) {
        return SYMPTOM_REPOSITORY.findSymptomByName(name);
    }
}
