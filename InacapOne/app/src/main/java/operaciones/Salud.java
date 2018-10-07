package operaciones;

public class Salud {
    private String nombre;
    private int pesoRecibido;
    private int pesoIdeal;
    private int edad;
    private int estadoPeso;

    public int calcularPesoIdeal() {
        pesoIdeal = (edad * 2) + 8;
        if (pesoRecibido == pesoIdeal) {
            estadoPeso = 0;
            return pesoIdeal;
        } else {
            if (pesoRecibido > pesoIdeal) {
                estadoPeso = 2;
                return pesoIdeal;
            } else {
                estadoPeso = 1;
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPesoRecibido() {
        return pesoRecibido;
    }

    public void setPesoRecibido(int pesoRecibido) {
        this.pesoRecibido = pesoRecibido;
    }

    public void setPesoIdeal(int pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public int getEdad() {
        return edad;
    }

    public int getEstadoPeso() {
        return estadoPeso;
    }

    public void setEstadoPeso(int estadoPeso) {
        this.estadoPeso = estadoPeso;
    }
}
