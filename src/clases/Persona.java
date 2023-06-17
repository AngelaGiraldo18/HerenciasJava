package clases;

import javax.swing.JOptionPane;

public class Persona {
 
   private String numeroDeDNI;
   private String nombre;
   private String apellido;
   private String fechaDeNacimiento;
   private String direccion;
   private String ciudadDeProcedecia;
   
   public void imprimirDatosPersona(String datos) {
	 
	   datos += "Nombre: "+ nombre+ "\n";
	   datos += "Apellido: "+apellido+"\n";
	   datos += "Fecha de nacimiento: "+fechaDeNacimiento+"\n";
	   datos += "Direccion: "+direccion+"\n";
	   datos += "Ciudad de procedencia: "+ciudadDeProcedecia+"\n";
	   
	   System.out.println(datos);
}
   public void registrarDatos() {
	    numeroDeDNI=JOptionPane.showInputDialog("Ingrese el numero de documento");
	    nombre=JOptionPane.showInputDialog("ingrese el nombre");
	    apellido=JOptionPane.showInputDialog("ingrese el apellido");
	    fechaDeNacimiento=JOptionPane.showInputDialog("ingrese la fecha de nacimiento");
	    direccion=JOptionPane.showInputDialog("ingrese la direccion");
	    ciudadDeProcedecia=JOptionPane.showInputDialog("ingrese la ciudad de procedenciaa");
    }
   
   public String getNumeroDeDNI() {
 		return numeroDeDNI;
 	}
 	public void setNumeroDeDNI(String numeroDeDNI) {
 		this.numeroDeDNI = numeroDeDNI;
 	}
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
 	public String getFechaDeNacimiento() {
 		return fechaDeNacimiento;
 	}
 	public void setFechaDeNacimiento(String fechaDeNacimiento) {
 		this.fechaDeNacimiento = fechaDeNacimiento;
 	}
 	public String getDireccion() {
 		return direccion;
 	}
 	public void setDireccion(String direccion) {
 		this.direccion = direccion;
 	}
 	public String getCiudadDeProcedecia() {
 		return ciudadDeProcedecia;
 	}
 	public void setCiudadDeProcedecia(String ciudadDeProcedecia) {
 		this.ciudadDeProcedecia = ciudadDeProcedecia;
 	}
}
