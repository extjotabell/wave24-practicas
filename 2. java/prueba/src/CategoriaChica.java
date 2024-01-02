public class CategoriaChica extends Categoria {

    public CategoriaChica() {
        setId(1);
        setNombre("Circuito Chico");
        setDescripcion("2 km por selva y arroyos.");
    }

    @Override
    public double obtenerMonto(int edad) {
        return edad <= 18 ? 1300 : 1500;
    }
}

