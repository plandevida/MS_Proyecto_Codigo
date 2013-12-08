/**
 * 
 */
package negocio.clientes.servicioaplicacion.imp;

import integracion.clientes.dao.DAOCliente;
import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.List;

import negocio.clientes.servicioaplicacion.SAClientes;
import negocio.clientes.transfer.TransferCliente;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAClientesImp implements SAClientes {
	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#anadirCliente(TransferCliente clienteNuevo)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirCliente(TransferCliente clienteNuevo) {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		transacion.start();

		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		Integer idCliente = null;
		
		try {
			idCliente = dao.addCliente(clienteNuevo);
			transacion.commit();
		} catch (Exception e) {
			transacion.rollback();
		} finally {
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}

		return idCliente;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#obtenerTodoslosClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferCliente> obtenerTodoslosClientes() {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		transacion.start();
		List<TransferCliente> listaClientes = null;
		try
		{
			listaClientes = dao.getAllClientes();
		}
		catch(Exception e)
		{
			//
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}	
		return listaClientes;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#actualizarCliente(TransferCliente clienteActualizado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarCliente(TransferCliente clienteActualizado) {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		transacion.start();
		Boolean correcto = false;
		try
		{
			
			correcto =  dao.updateCliente(clienteActualizado);
			transacion.commit();
			if(!correcto)
			{
				
				transacion.rollback();
				
			}
			
		}
		catch(Exception e)
		{
			//tratar
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#borrarCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarCliente(Integer idCliente) {
		
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		transacion.start();
		Boolean resultado = null;
		try
		{
				resultado = dao.deleteCliente(idCliente);
				transacion.commit();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}
		return resultado;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#obtenerCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente obtenerCliente(Integer idCliente) {
		
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		TransferCliente t = null;
		transacion.start();
		try
		{
				t = dao.getCliente(idCliente);
		}catch(Exception e)
		{
			
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}
		
		return t;
		
	}
}