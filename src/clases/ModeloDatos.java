package clases;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import clases.empleado.CitaMedica;
import clases.empleado.Empleado;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlantilla;
import clases.empleado.Medico;

public class ModeloDatos {
  
	HashMap<String , Paciente> pacientesMap;
	HashMap<String, EmpleadoPlantilla> empleadosPlantillaMap;
	HashMap<String, EmpleadoEventual> empleadoEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;
	
	
	public ModeloDatos() {
		pacientesMap=new HashMap<String, Paciente>();
		empleadosPlantillaMap=new HashMap<String, EmpleadoPlantilla>();
		medicosMap=new HashMap<String, Medico>();
		empleadoEventualMap=new HashMap<String, EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();
	}
	
	public void registrarPersona(Paciente miPaciente) {
		pacientesMap.put(miPaciente.getNumeroDeDNI(),miPaciente);
		System.out.println("se ha registrado el paciente "+ miPaciente.getNombre()+" Satisfactoriamente");
	}
	
	public void registrarPersona(EmpleadoPlantilla miEmpPlantilla) {
		empleadosPlantillaMap.put(miEmpPlantilla.getNumeroDeDNI(),miEmpPlantilla);
		System.out.println("se ha registrado el paciente "+ miEmpPlantilla.getNombre()+" Satisfactoriamente");
	}
	
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		empleadoEventualMap.put(miEmpEventual.getNumeroDeDNI(),miEmpEventual);
		System.out.println("se ha registrado el paciente "+ miEmpEventual.getNombre()+" Satisfactoriamente");
	}
	
	public void registrarPersona(Medico miMedico ) {
		medicosMap.put(miMedico.getNumeroDeDNI(),miMedico);
		System.out.println("se ha registrado el paciente "+ miMedico.getNombre()+" Satisfactoriamente");
	}

	public void imprimirPacientes() {
     String msj = "PACIENTES REGISTRADOS\n";
     Iterator<String> iterator = pacientesMap.keySet().iterator();
    
     if (!iterator.hasNext()) {
    	 System.out.println("No hay datos registrados");
     }else {
     while (iterator.hasNext()) {
		String clave = iterator.next();
		pacientesMap.get(clave).imprimirDatosPersona(msj);
     }
	}
	}


	public void imprimirEmpleadosEventuales() {
	     String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";
	     boolean boolen = true;
	     
        for (String clave : empleadoEventualMap.keySet()) {
			empleadoEventualMap.get(clave).imprimirDatosPersona(msj);
			boolen = false;
			
			break;
		}
        
        if (!boolen) {
			for (String  clave : empleadoEventualMap.keySet()) {
				empleadoEventualMap.get(clave).imprimirDatosPersona(msj);
			}
		} else {
           System.out.println("no hay ningun usuario registrado");
		}
        
	}

	public void imprimirEmpleadosPorPlantilla() {
	     String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";
	     
	     for (EmpleadoPlantilla empleadoPlantilla: empleadosPlantillaMap.values()) {
	    	 empleadoPlantilla.imprimirDatosPersona(msj);
		}
		
	}

	public void imprimirMedicos() {
	     String msj = "MEDICOS REGISTRADOS\n";
	     
	     for (Map.Entry<String,Medico> elemento : medicosMap.entrySet()) {
			
	    	 elemento.getValue().imprimirDatosPersona(msj);
		}
		
	}
	
	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente=null;
		
		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente=pacientesMap.get(documentoPaciente);
			
		}
		
		return miPaciente;
		
	}
	
	public Medico consultarMedicoPorNombre(String nombreMedico) {
		for (Medico medico : medicosMap.values()) {
			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}
		}
		
		return null;
	}
	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("se ha registrado la cita exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
		
	}

	public void imprimirCitasMedicasProgramadas() {
     String msj= "CITAS MEDICAS PROGRAMADAS\n";
     CitaMedica miCita=null;
     
     System.out.println(msj+"\n");
     
     if (citasList.size()>0) {
		for (int i = 0; i < citasList.size(); i++) {
			miCita=citasList.get(i);
			System.out.println(miCita.informacionCitaMedica());
		}
	} else {
         System.out.println("NO EXISTE CITAS PROGRAMADAS");
	}
	}


}
