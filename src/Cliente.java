public class Cliente {

        private String nombre;
        private String dni;
        private String telefono;
        private String email;

        public Cliente(String nombre, String dni, String telefono, String email) {
            this.nombre = nombre;
            this.dni = dni;
            this.telefono = telefono;
            this.email = email;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
