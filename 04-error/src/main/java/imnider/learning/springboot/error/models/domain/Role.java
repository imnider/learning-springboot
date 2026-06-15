package imnider.learning.springboot.error.models.domain;

public class Role {
    
    private String nombre;
    
    public Role() {
    }

    public Role(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
