/**
 * 
 */
package negocio.reservas.transfer;

import java.util.Date;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferReserva {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer numeroReserva;

	/**
	 * @return el numeroReserva
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getNumeroReserva() {
		// begin-user-code
		return numeroReserva;
		// end-user-code
	}

	/**
	 * @param numeroReserva
	 *            el numeroReserva a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNumeroReserva(Integer numeroReserva) {
		// begin-user-code
		this.numeroReserva = numeroReserva;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer numeroHabitacion;

	/**
	 * @return el numeroHabitacion
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getNumeroHabitacion() {
		// begin-user-code
		return numeroHabitacion;
		// end-user-code
	}

	/**
	 * @param numeroHabitacion
	 *            el numeroHabitacion a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNumeroHabitacion(Integer numeroHabitacion) {
		// begin-user-code
		this.numeroHabitacion = numeroHabitacion;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer idusuario;

	/**
	 * @return el DNI
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getidusuario() {
		// begin-user-code
		return idusuario;
		// end-user-code
	}

	/**
	 * @param DNI
	 *            el DNI a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setidusuario(Integer idusuario) {
		// begin-user-code
		this.idusuario = idusuario;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date fechaReserva;

	/**
	 * @return el fechaReserva
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getFechaReserva() {
		// begin-user-code
		return fechaReserva;
		// end-user-code
	}

	/**
	 * @param fechaReserva
	 *            el fechaReserva a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFechaReserva(Date fechaReserva) {
		// begin-user-code
		this.fechaReserva = fechaReserva;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date fechaSalida;

	/**
	 * @return el fechaSalida
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getFechaSalida() {
		// begin-user-code
		return fechaSalida;
		// end-user-code
	}

	/**
	 * @param fechaSalida
	 *            el fechaSalida a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFechaSalida(Date fechaSalida) {
		// begin-user-code
		this.fechaSalida = fechaSalida;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date fechaEntrada;

	/**
	 * @return el fechaEntrada
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getFechaEntrada() {
		// begin-user-code
		return fechaEntrada;
		// end-user-code
	}

	/**
	 * @param fechaEntrada
	 *            el fechaEntrada a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFechaEntrada(Date fechaEntrada) {
		// begin-user-code
		this.fechaEntrada = fechaEntrada;
		// end-user-code
	}

	@Override
	public String toString() {
		
		return getNumeroReserva() + " " + getidusuario() + " " + getNumeroHabitacion() + " " + getFechaReserva() + " " + getFechaEntrada() + " " + getFechaSalida();
	}
}