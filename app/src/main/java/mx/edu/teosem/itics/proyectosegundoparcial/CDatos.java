package mx.edu.teosem.itics.proyectosegundoparcial;

public class CDatos {
    String Nombre;
    int Edad;
    String Correo;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String toString(){
        return Nombre + "," + Edad + "," + Correo + "\n";
    }

}
