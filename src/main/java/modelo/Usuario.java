package modelo;

public class Usuario {
	    private String rut;
	    private String username;
	    private String password;

	    // Constructor, getters y setters
	
	    public Usuario(String rut, String username, String password) {
	        this.rut = rut;
	        this.username = username;
	        this.password = password;
	    }

	    public String getRut() {
	        return rut;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

}
