/**
 * 
 */
package presentacion.comandos.empleado.redireccion;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Daniel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandRConsultarEmpleadosVModificar implements Command {

	@Override
	public CommandResponse execute(Object datos) {

		Command command = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_EMPLEADO);

		CommandResponse cr = command.execute(datos);
		
		if ( cr.getEvento().equals(IDEventos.ERROR_CONSULTAR_EMPLEADO) ) {
			
			cr.setEvento(IDEventos.ERROR_CONSULTAR_EMPLEADOS_V_MODIFICAR);
		}
		else {
			
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_EMPLEADOS_V_MODIFICAR);
		}
		
		return cr;
	}
}