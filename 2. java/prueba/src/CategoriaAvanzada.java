public class CategoriaAvanzada extends Categoria{

    public CategoriaAvanzada() {
        setId(1);
        setNombre("Circuito avanzado");
        setDescripcion("10 km por selva, arroyos, barro y escalada en piedra.");
    }

    @Override
    public double obtenerMonto(int edad) throws Exception {

        if(edad >=18) {
            return 2800;
        } else {
            throw new Exception("No se permite inscripciones a menores de 18 años");
        }

    }
}
