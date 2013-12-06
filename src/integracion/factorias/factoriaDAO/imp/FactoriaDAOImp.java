/**
 * 
 */
package integracion.factorias.factoriaDAO.imp;

import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.reservas.dao.DAOReserva;
import integracion.reservas.dao.imp.DAOReservaImp;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOImp extends FactoriaDAO {
	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaDAO#generaDAOCliente()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCliente generaDAOCliente() {
	
		return new DAOClienteImp();
		
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaDAO#generaDAOReserva()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOReserva generaDAOReserva() {
		return new DAOReservaImp();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaDAO#generaDAOHabitacion()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOHabitacion generaDAOHabitacion() {
		
		return new DAOHabitacionImp();
		
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaDAO#generaDAOTarea()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOReserva generaDAOTarea() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaDAO#generaDAOEmpleado()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object generaDAOEmpleado() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactoriaDAO#generaDAODepartamento()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object generaDAODepartamento() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}
}