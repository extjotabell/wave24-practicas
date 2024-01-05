package repositories;

import java.util.List;

public class LocalizadorRepository<T> {

    private List<T> localizadores;

    public LocalizadorRepository(List<T> localizadores) {
        this.localizadores = localizadores;
    }
}
