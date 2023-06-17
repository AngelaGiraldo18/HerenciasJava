package clases;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Paciente extends Persona{
 
private int numeroHistoriaClinica;
  private String sexo;
  private String grupoSanguineo;
  private ArrayList<String> ListaMedicamentosAlergico;
  
  @Override
  
  public void registrarDatos() {
	  super.registrarDatos();
	  
	  ListaMedicamentosAlergico=new ArrayList<String>();
	  numeroHistoriaClinica=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia clinica: "));
	  sexo=JOptionPane.showInputDialog("Ingrese el sexo: ");
	  grupoSanguineo=JOptionPane.showInputDialog("Ingrese el grupo sanguineo: ");
	  
	  String pregunta=JOptionPane.showInputDialog("¿Es alergico a algun medicamento? ingrese Si o No");
	  
	  if (pregunta.equalsIgnoreCase("si")) {
		String medicamento ="";
		String continuar="";
		
		do {
			medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
			ListaMedicamentosAlergico.add(medicamento);
			
			continuar=JOptionPane.showInputDialog("ingrese Si,si desea continuar");
		} while (continuar.equalsIgnoreCase("si"));
	} 
  }
  
  @Override
  public void imprimirDatosPersona(String datos) {
	  super.imprimirDatosPersona(datos);
	  
	  datos="Numero de Historiaa Clinica: "+ numeroHistoriaClinica+"\n";
	  datos+="Sexo: "+sexo+"\n";
	  datos+= "Grupo Sanguineo: "+grupoSanguineo+"\n";
	  
	  if (ListaMedicamentosAlergico.size()>0) {
		datos+="Lista de Medicamentos a los que es alergicp\n";
		for (int i = 0; i < ListaMedicamentosAlergico.size(); i++) {
			datos+="\t"+ListaMedicamentosAlergico.get(i)+"\n";
		}
	} else {
      datos+="El paciente, no es alergico a ningún medicamento";
	}
	  System.out.println(datos);
  }
  
  public int getNumeroHistoriaClinica() {
		return numeroHistoriaClinica;
	}
	public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
		this.numeroHistoriaClinica = numeroHistoriaClinica;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public ArrayList<String> getListaMedicamentosAlergico() {
		return ListaMedicamentosAlergico;
	}
	public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) {
		ListaMedicamentosAlergico = listaMedicamentosAlergico;
	}
	
	
	
}
