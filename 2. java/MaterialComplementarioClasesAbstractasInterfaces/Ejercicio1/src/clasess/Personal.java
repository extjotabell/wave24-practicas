package clasess;

import java.util.ArrayList;

public class Personal<T extends interfaces.Personal> {
    private ArrayList<T> personal;

    public Personal(ArrayList<T> personal) {
        this.personal = personal;
    }

    public ArrayList<T> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<T> personal) {
        this.personal = personal;
    }
}