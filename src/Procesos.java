import javax.swing.JOptionPane;

import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.CitaMedica;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlantilla;
import clases.empleado.Medico;

public class Procesos {
  
	ModeloDatos miModeloDatos;
	
	public Procesos() {
		miModeloDatos=new ModeloDatos();
		presentarMenuOpciones();
	}

	private void presentarMenuOpciones() {
    String menu="MENU HOSPITAL\n";
    menu+="1. Registrar Paciente\n";
    menu+="2.Registrar Empleado\n";
    menu+="3.Registrar Cita Medica\n";
    menu+="4.Imprimir Informacion\n";
    menu+="5.Salir\n";
    menu+="INGRESE UNA OPCION\n";
    
    int opcion=0;
   
	   do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1:
				 registrarpaciente();
				break;
			case 2:
				registrarEmpleado();
				break;
			case 3:
				registrarCitaMedica();
				break;
			case 4:
				imprimirInformacion();
				break;
			case 5:
				 JOptionPane.showInternalMessageDialog(null, "El sistema ha terminado!");
				break;
			default:JOptionPane.showMessageDialog(null,"No existe el codigo,verifique nuevamente ");
				break;
			}
	} while (opcion!=5);

	}
	private void registrarpaciente() {
	   Paciente miPaciente = new Paciente();
	   miPaciente.registrarDatos();
	   
	   miModeloDatos.registrarPersona(miPaciente);
;	}

	private void registrarEmpleado() {
   String menuTipoEmpleado = "Registro de empleados\n";
   menuTipoEmpleado+="1.Empleado Eventual\n";
   menuTipoEmpleado+="2. Empleado por Planilla\n";
   menuTipoEmpleado+="SELECIONE EL TIPO DE EMPLEADO A REGISTRAR\n";
    
   int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
   
   switch (tipoEmpleado) {
case 1:
	   EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
	   miEmpleadoEventual.registrarDatos();
	   miModeloDatos.registrarPersona(miEmpleadoEventual);
	break;
case 2:
	   String resp=JOptionPane.showInputDialog("Ingrese Si,si es un medico, de lo contrario es otro tipo de empleado");
	   if (resp.equalsIgnoreCase("si")) {
		   Medico miMedico = new Medico();
		   miMedico.registrarDatos();
		   miModeloDatos.registrarPersona(miMedico);
		
	}else {
		 EmpleadoPlantilla miEmpleadoPlantilla = new EmpleadoPlantilla();
		 miEmpleadoPlantilla.registrarDatos();
		   miModeloDatos.registrarPersona(miEmpleadoPlantilla);
	}
	   
	   
	break;

default:System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
	break;
}
   
	}

	private void registrarCitaMedica() {
     String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
     
     Paciente PacienteEncontrado =miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
     
     if (PacienteEncontrado!=null) {
		String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
		Medico medicoEncontrado= miModeloDatos.consultarMedicoPorNombre(nombreMedico);
		
		if (medicoEncontrado!=null) {
			String servivio=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
			String fechaConsulta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
			String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
			
			String lugar = "La cita en el  consultotio"+medicoEncontrado.getNumerosDeConsultorio();
			CitaMedica miCita=new CitaMedica(PacienteEncontrado,medicoEncontrado,servivio,fechaConsulta,horaConsulta,lugar);
			miModeloDatos.registrarCitaMedica(miCita);
		}else {
			System.out.println("El medico no se encuentra registrado en el sistema");
		}
	}else {
		System.out.println("El paciente no se encuentra registrado en el sistema");
	}
	}

	private void imprimirInformacion() {
        String menuImprimir="MENU IMPRESIONES\n";
        menuImprimir+="1. Listar Pacientes\n";
        menuImprimir+="2. Listar Empleados Eventuales\n";
        menuImprimir+="3. Listar Empleados Por Planilla\n";
        menuImprimir+="4. Listar Medicos\n";
        menuImprimir+="5. Listar Citas Programadas\n";
        menuImprimir+="INGRESE UNA OPCIÓN\n";
        
        System.out.println("**********Menu****************");
        
        int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
        
        switch (opcion) {
		case 1:
			miModeloDatos.imprimirPacientes();
			break;
		case 2:
			miModeloDatos.imprimirEmpleadosEventuales();
			break;
		case 3:
			miModeloDatos.imprimirEmpleadosPorPlantilla();
			break;
			
		case 4:
			miModeloDatos.imprimirMedicos();
			break;
			
		case 5:
			miModeloDatos.imprimirCitasMedicasProgramadas();
			break;

		default:System.out.println("NO EXISTE ESTA OPCIÓN");
			break;
		}
	}




}
