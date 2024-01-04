public class Dos extends Progresion {
    @Override
    public int siguiente() {
        setActual(getActual()+2);
        return getActual();
    }

    public Dos(int actual, int inicio) {
        this.setActual(actual);
        this.setInicio(inicio);
    }


}
