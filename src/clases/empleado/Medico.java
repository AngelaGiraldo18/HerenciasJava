package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlantilla {

private String especialidad;
  private int numerosDeConsultorio;
  
  @Override
  public void registrarDatos() {
	  super.registrarDatos();
	  
	  especialidad=JOptionPane.showInputDialog("ingrese su especialidad");
	  numerosDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Num consultorio"));
	  
  }
  

  
  public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumerosDeConsultorio() {
		return numerosDeConsultorio;
	}
	public void setNumerosDeConsultorio(int numerosDeConsultorio) {
		this.numerosDeConsultorio = numerosDeConsultorio;
	}
}
