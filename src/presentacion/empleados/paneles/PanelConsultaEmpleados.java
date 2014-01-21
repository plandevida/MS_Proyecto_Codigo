/**
 * 
 */
package presentacion.empleados.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.objetonegocio.Empleado.TipoEmpleado;
import negocio.excepciones.BSoDException;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelConsultaEmpleados extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textDNIBusqueda;
	private JTextField txtDni;
	private JTextField textNombre;
	private JTextField textApellidos;
	
	private JComboBox<TipoEmpleado> cbTipo;
	private JComboBox<Departamento> cbDepartamento;
	
	public PanelConsultaEmpleados() {
		
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][13.00][][24.00]"));
		
		JLabel lblConsultaClientes = new JLabel("Consulta empleados");
		add(lblConsultaClientes, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 8 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 2 4,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		add(textDNIBusqueda, "cell 3 4,growx");
		textDNIBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniEmpleado = textDNIBusqueda.getText().trim();
				
				if ( !dniEmpleado.equals("")) {
				
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_EMPLEADOS, dniEmpleado);
				}
				else {
					JOptionPane.showMessageDialog(null, "El campo DNI no puede quedar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 5 4");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,growx,aligny center");
		
		JLabel lblDni_1 = new JLabel("DNI: ");
		add(lblDni_1, "cell 2 6,alignx right");
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		add(txtDni, "cell 3 6,growx");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 2 8,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		add(textNombre, "cell 3 8,growx");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "cell 5 8,alignx right");
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		add(textApellidos, "cell 6 8,growx");
		textApellidos.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		add(lblTipo, "cell 2 10,alignx trailing");
		
		cbTipo = new JComboBox<>();
		cbTipo.setModel(new DefaultComboBoxModel<TipoEmpleado>(TipoEmpleado.values()));
		add(cbTipo, "cell 3 10,growx");
		
		JLabel lblDepartamento = new JLabel("Departamento: ");
		add(lblDepartamento, "cell 5 10,alignx trailing");
		
		cbDepartamento = new JComboBox<>();
		add(cbDepartamento, "cell 6 10,growx");
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTAR_EMPLEADOS == idEvento ) {
		
			if ( datos instanceof Empleado) {
				
				Empleado empleado = (Empleado) datos;
				
				txtDni.setText(empleado.getDNI());
				textNombre.setText(empleado.getNombre());
				textApellidos.setText(empleado.getPrimerApellido() + " " + empleado.getSegundoApellido());
				
				cbTipo.setSelectedItem(empleado.getTipo());
				cbDepartamento.setSelectedItem(empleado.getDepartamento());
					
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo obtener el empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_EMPLEADOS == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(this, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}