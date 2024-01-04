public abstract class Progresion {
    private int inicio;
    private int actual;

    public abstract int siguiente();

    public void reincio(){
        setActual(getInicio());
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
}
