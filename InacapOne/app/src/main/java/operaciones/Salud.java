package operaciones;

public class Salud {
    private String nombre;
    private int pesoRecibido;
    private int pesoIdeal;
    private int edad;


    public int calcularPesoIdeal() {
        pesoIdeal = (edad * 2) + 8;
        if (pesoRecibido == pesoIdeal) {
                return pesoIdeal;
        } else {
            if (pesoRecibido > pesoIdeal) {
                return pesoIdeal;
            } else {
                return pesoIdeal;
            }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(int pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPesoRecibido() {
        return pesoRecibido;
    }

    public void setPesoRecibido(int pesoRecibido) {
        this.pesoRecibido = pesoRecibido;
    }
}
