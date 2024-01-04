public class Tres extends Progresion {
    public Tres(int actual,int inicio) {
       setActual(actual);
       setInicio(inicio);
    }

    @Override
    public int siguiente() {
        setActual(getActual() + 3);
        return getActual();
    }
}
