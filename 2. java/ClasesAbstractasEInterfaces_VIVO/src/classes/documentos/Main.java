package classes.documentos;

import classes.documentos.interfaces.Imprimible;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person persona= new Person("juan camilo","Zapata Macias");
        Curriculum curriculum= new Curriculum(persona,"java,desarrollo,hapkido");
        Informe informe=new Informe("este es el informe sobre clases abstractas e interfaces",28,persona,"jean");
        Pdf pdf=new Pdf(12,persona,"Abstraccion y herencia","software");
        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(informe);
        Imprimible.imprimirDocumento(pdf);

        }

}