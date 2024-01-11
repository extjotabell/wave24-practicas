package Variables.poo.Interfaces;

public class RinesDeLujo implements Vehiculo {

        private Vehiculo vehiculo;

        public RinesDeLujo(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
        }
        @Override
        public Double getPrecio() {
            return vehiculo.getPrecio()+10.0;
        }
        @Override
        public String getAccesorios() {
            return vehiculo.getAccesorios() + " Rines de lujo ";
        }
}


