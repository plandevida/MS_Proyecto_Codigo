/**
 * 
 */
package presentacion.comandos.departamento;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Daniel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandAltaDepartamento implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Clase datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public CommandResponse execute(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSADepartamentos().anadirDepartamento((Departamento) datos));
			cr.setEvento(IDEventos.EVENTO_ALTA_DEPARTAMENTO);

		} catch (BSoDException bsod) {

			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_ALTA_DEPARTAMENTO);
		}
		
		return cr;
	}
}