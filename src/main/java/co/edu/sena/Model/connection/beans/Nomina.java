package co.edu.sena.Model.connection.beans;

public class Nomina {

    //atribitos de la clase
    private String nombre;
    private String apellido;
    private String numDoc;
    private byte diasTrabajados;
    private float sueldo;

    //método constructor
    public Nomina() {
    }

    public Nomina(String nombre, String apellido, String numDoc, byte diasTrabajados, float sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numDoc = numDoc;
        this.diasTrabajados = diasTrabajados;
        this.sueldo = sueldo;
    }

    //métodos get and set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public byte getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(byte diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

}
