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

	 String consultar="";
	 
	public ModeloDatos() {
		pacientesMap=new HashMap<String, Paciente>();
		empleadosPlantillaMap=new HashMap<String, EmpleadoPlantilla>();
		medicosMap=new HashMap<String, Medico>();
		empleadoEventualMap=new HashMap<String, EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();
	}
	
	public void registrarPersona(Paciente miPaciente) {
		String numeroDeDNI = miPaciente.getNumeroDeDNI();
		if (pacientesMap.containsKey(numeroDeDNI)) {
			System.out.println("El paciente con numero de Documento: " + numeroDeDNI + " ya se encuentra registrado.");
		  return;
		}
		pacientesMap.put(miPaciente.getNumeroDeDNI(),miPaciente);
		System.out.println("se ha registrado el paciente "+ miPaciente.getNombre()+" Satisfactoriamente");
	
	}
	
	public void registrarPersona(EmpleadoPlantilla miEmpPlantilla) {
		if (empleadosPlantillaMap.containsKey(miEmpPlantilla.getNumeroDeDNI())) {
			System.out.println("El Empleado con numero de Documento: " +miEmpPlantilla.getNumeroDeDNI()+ " ya se encuentra registrado.");
		}else {
		empleadosPlantillaMap.put(miEmpPlantilla.getNumeroDeDNI(),miEmpPlantilla);
		System.out.println("se ha registrado el empleado por planilla "+ miEmpPlantilla.getNombre()+" Satisfactoriamente");
		}
	}
	
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		if (empleadoEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
			System.out.println("El Empleado Eventual con numero de Documento: " +miEmpEventual.getNumeroDeDNI()+ " ya se encuentra registrado.");
		}else {
		empleadoEventualMap.put(miEmpEventual.getNumeroDeDNI(),miEmpEventual);
		System.out.println("se ha registrado el empleado eventual "+ miEmpEventual.getNombre()+" Satisfactoriamente");
		}
	}
	
	public void registrarPersona(Medico miMedico ) {		
		if (medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
		System.out.println("El Medico con numero de Documento: " +miMedico.getNumeroDeDNI()+ " ya se encuentra registrado.");
	}else {
		medicosMap.put(miMedico.getNumeroDeDNI(),miMedico);
		System.out.println("se ha registrado el Medico "+ miMedico.getNombre()+" Satisfactoriamente");
	  }
    }

	public void imprimirPacientes() {
     String msj = "PACIENTES REGISTRADOS\n";
     Iterator<String> iterator = pacientesMap.keySet().iterator();
 
     while (iterator.hasNext()) {
		String clave = iterator.next();
		pacientesMap.get(clave).imprimirDatosPersona(msj);
     }if (pacientesMap.isEmpty()) {
		System.out.println("NO SE ENCUENTRA PACIENTES REGISTRADOS");
	}
	
	}
	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		
		String msj = " PAciente\n";
		Paciente miPaciente=null;
		 System.out.println(msj+"\n");
		 
		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente=pacientesMap.get(documentoPaciente);
			
		}
		
		return miPaciente;
		
	}

	public void imprimirEmpleadosEventuales() {
	     String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";
	     
        for (String clave : empleadoEventualMap.keySet()) {
			empleadoEventualMap.get(clave).imprimirDatosPersona(msj);
		}if (empleadoEventualMap.isEmpty()) {
			System.out.println("NO HAY EMPLEADOS EVENTUALES REGISTRADOS");
		}
                
	}

	public void imprimirEmpleadosPorPlantilla() {
	     String msj = "EMPLEADOS PLANILLA REGISTRADOS\n";
       for (EmpleadoPlantilla emPlantilla :empleadosPlantillaMap.values()) {
		 emPlantilla.imprimirDatosPersona(msj);
		 }if (empleadosPlantillaMap.isEmpty()) {
		        System.out.println("NO HAY EMPLEADOS POR PLANILLA REGISTRADOS");
		 }   
		      String mensaje = " MEDICOS REGISTRADOS\n";
		      for (Map.Entry<String,Medico> elemento : medicosMap.entrySet()) {
			    	 elemento.getValue().imprimirDatosPersona(mensaje);
	        }if (medicosMap.isEmpty()) {
				System.out.println("NO HAY MEDICOS REGISTRADOS");
			}
	    
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
         System.out.println("NO HAY CITAS PROGRAMADAS");
	}
	}

	public void imprimirPacientesPorCedula() {
		String msj = "Consulta Paciente\n";
		 consultar = JOptionPane.showInputDialog("Ingrese el numero de cedula a buscar");
		 System.out.println("Numero de documento ingresado: "+ consultar);
		 
		 if (pacientesMap.containsKey(consultar)) {
			Paciente paciente = pacientesMap.get(consultar);
			paciente.imprimirDatosPersona(msj);
		} else {
            System.out.println("No se encontro el paciente con Documento: "+consultar);
		}
		 
	}

	public void imprimirEmpleadosEventualesPorCedula() {
		String msj = "Consulta Empleado eventual\n";
		 consultar = JOptionPane.showInputDialog("Ingre el numero de cedula a buscar");
		 System.out.println("Numero de documento ingresado: "+ consultar);
         
		 if (empleadoEventualMap.containsKey(consultar)) {
			  EmpleadoEventual empleadoEvendual = empleadoEventualMap.get(consultar);
			  empleadoEvendual.imprimirDatosPersona(msj);
		} else {
            System.out.println("No se encontro el empleado evental con Documento: "+consultar);

		}
	}

	public void imprimirMedicosPorCedula() {
		String msj = "Consulta Medico\n";
		 consultar = JOptionPane.showInputDialog("Ingre el numero de cedula a buscar");
		 System.out.println("Numero de documento ingresado: "+ consultar);
        
		 if (medicosMap.containsKey(consultar)) {
			  Medico miMedico = medicosMap.get(consultar);
			  miMedico.imprimirDatosPersona(msj);
		} else {
           System.out.println("No se encontro el empleado evental con Documento: "+consultar);

		}
	}

	public void imprimirEmpleadosPorPlantillaPorCedula() {
		String msj = "Consulta Empleado por Planilla\n";
		 consultar = JOptionPane.showInputDialog("Ingre el numero de cedula a buscar");
		 System.out.println("Numero de docmento ingresado: "+ consultar);
        
		 if (empleadosPlantillaMap.containsKey(consultar)) {
			  EmpleadoPlantilla empleadosPlanilla = empleadosPlantillaMap.get(consultar);
			  empleadosPlanilla.imprimirDatosPersona(msj);
		} else {
           System.out.println("No se encontro el empleado por planilla con Documento: "+consultar);

		}
	}
}
