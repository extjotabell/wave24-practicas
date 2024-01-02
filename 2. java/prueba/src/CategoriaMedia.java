public class CategoriaMedia extends Categoria{

    public CategoriaMedia() {
        setId(1);
        setNombre("Circuito medio");
        setDescripcion("5 km por selva, arroyos y barro.");
    }

    @Override
    public double obtenerMonto(int edad) {
        return edad <= 18 ? 2000 : 2300;
    }
}
