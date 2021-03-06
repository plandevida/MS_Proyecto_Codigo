/**
 * 
 */
package negocio.reservas.servicioaplicacion.imp;

import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.reservas.dao.DAOReserva;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Date;
import java.util.List;

import negocio.excepciones.BSoDException;
import negocio.reservas.servicioaplicacion.SAReservas;
import negocio.reservas.transfer.TransferReserva;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAReservasImp implements SAReservas {
	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#actualizarReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarReserva(TransferReserva reserva)
			throws BSoDException {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		transacion.start();
		Boolean correcto = false;
		try {
			correcto = dao.updateReserva(reserva);
			transacion.commit();
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#anadirReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirReserva(TransferReserva reserva) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		transacion.start();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		Integer idReserva = null;
		try {

			Date diaEntradaNuevaReserva = new Date( ((java.util.Date) reserva.getFechaEntrada()).getTime());
			Date diaSalidaNuevaReserva = new Date( ((java.util.Date) reserva.getFechaSalida()).getTime());

			if (diaEntradaNuevaReserva.before(diaSalidaNuevaReserva)) {
				
				List<TransferReserva> listareservasporhabitacion = dao.getReservasporHabitacion(reserva.getNumeroHabitacion());
				
				if (!listareservasporhabitacion.isEmpty()) {
					
					for (TransferReserva reservaporhabitacion : listareservasporhabitacion) {
						Date diaentrada = (Date) reservaporhabitacion
								.getFechaEntrada();
						Date diasalida = (Date) reservaporhabitacion
								.getFechaSalida();
						
						System.out.println(diaentrada);
						System.out.println(diasalida);
						System.out.println(diaEntradaNuevaReserva);
						System.out.println(diaSalidaNuevaReserva);
						
						if ( (diaentrada.before(diaEntradaNuevaReserva) && diasalida.after(diaSalidaNuevaReserva))
							&& diaentrada.before(diaEntradaNuevaReserva) && diasalida.before(diaSalidaNuevaReserva)
							&& diaentrada.after(diaEntradaNuevaReserva) && diasalida.after(diaSalidaNuevaReserva)) {
							
							throw new BSoDException("La habitación ya está reservada para algún intervalo del solicitdo");
						}
						else {

							idReserva = dao.addReserva(reserva);
							transacion.commit();
						}
					}
				}
				else {

					idReserva = dao.addReserva(reserva);
					transacion.commit();
				}
			}
		}
		catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}

		return idReserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#borrarReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarReserva(Integer idReserva) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		transacion.start();

		Boolean resultado = null;
		try {

			resultado = dao.deleteReserva(idReserva);
			transacion.commit();
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return resultado;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#obtenerReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva obtenerReserva(Integer idReserva)
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		TransferReserva reserva = null;

		transacion.start();
		try {
			reserva = dao.getReserva(idReserva);
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}

		return reserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#obtenerTodaslasReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public List<TransferReserva> obtenerTodaslasReservasPorCliente(
			Integer idCliente) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		transacion.start();

		List<TransferReserva> listaReserva = null;
		try {
			listaReserva = dao.getAllReservasporCliente(idCliente);
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return listaReserva;
	}

	@Override
	public List<TransferReserva> obtenerReservasporHabitacion(
			Integer numhabitacion) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		transacion.start();

		List<TransferReserva> listaReserva = null;
		try {
			listaReserva = dao.getReservasporHabitacion(numhabitacion);
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return listaReserva;

	}

	@Override
	public List<TransferReserva> obtenerTodaslasReservas() throws BSoDException {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		transacion.start();
		List<TransferReserva> listaReserva = null;
		try {
			listaReserva = dao.getAllReservas();
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return listaReserva;

	}

}