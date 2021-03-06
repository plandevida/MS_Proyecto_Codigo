/**
 * 
 */
package presentacion.empleados.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

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
import negocio.empleados.objetonegocio.EmpleadoParcial;
import negocio.empleados.objetonegocio.EmpleadoTotal;
import negocio.empleados.objetonegocio.EmpleadoTotal.TipoPlazaParking;
import negocio.excepciones.BSoDException;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelModificacionEmpleados extends JPanel implements GUIPanelesInterfaz {
	
	private static final long serialVersionUID = 1L;
	private JTextField textDNIBusqueda;
	private JTextField textNombre;
	private JTextField textSegundoApellido;
	private Empleado empleado;
	private JTextField textPrimerApellido;
	
	private JPanel contentPane;
	
	private JComboBox<Departamento> cbDepartamento;
	private JComboBox<TipoEmpleado> cbTipo;
	
	private JButton btnModificarEmpleado;
	private JLabel lblPlaza;
	private JTextField textHoras;
	
	private JLabel lblHoras;
	private JComboBox<TipoPlazaParking> cbPlaza;
	
	public PanelModificacionEmpleados() {
		
		contentPane = this;
		
		setLayout(new MigLayout("", "[][][121.00,grow][36.00][][grow][10.00][]", "[][][][][18.00][17.00][][10.00][][9.00][][16.00][13.00][]"));
		
		JLabel lblModificacinDeClientes = new JLabel("Modificación de empleados");
		add(lblModificacinDeClientes, "cell 0 0 6 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 5 1,growx,aligny center");
		
		JLabel label = new JLabel("DNI: ");
		add(label, "cell 1 3,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		textDNIBusqueda.setColumns(10);
		add(textDNIBusqueda, "cell 2 3,growx");
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textDNIBusqueda.setEditable(false);
				
				String dniEmpleado = textDNIBusqueda.getText().trim();
				
				if ( !dniEmpleado.equals("")) {
				
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_EMPLEADOS_V_MODIFICAR, dniEmpleado);
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo DNI no puede quedar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(buttonBuscar, "cell 4 3");
		
		JButton btnNuevaBsqueda = new JButton("Nueva búsqueda");
		btnNuevaBsqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				empleado = null;
				textDNIBusqueda.setText("");
				textDNIBusqueda.setEditable(true);
				textNombre.setText("");
				textNombre.setEditable(false);
				textPrimerApellido.setText("");
				textPrimerApellido.setEditable(false);
				textSegundoApellido.setText("");
				textSegundoApellido.setEditable(false);
				cbTipo.setEnabled(false);
				cbDepartamento.setEnabled(false);
				
				lblHoras.setVisible(false);
				textHoras.setText("");
				textHoras.setVisible(false);
				
				lblPlaza.setVisible(false);
				cbPlaza.setVisible(false);
				cbPlaza.setSelectedIndex(-1);
			}
		});
		add(btnNuevaBsqueda, "cell 5 3");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 4 5 1,growx,aligny center");
		
		JLabel label_1 = new JLabel("Nombre: ");
		add(label_1, "cell 1 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		add(textNombre, "cell 2 6,growx");
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		add(lblPrimerApellido, "cell 4 6,alignx trailing");
		
		textPrimerApellido = new JTextField();
		textPrimerApellido.setEditable(false);
		add(textPrimerApellido, "cell 5 6,growx");
		textPrimerApellido.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		add(lblTipo, "cell 1 8,alignx trailing");
		
		cbTipo = new JComboBox<>();
		cbTipo.addItemListener(new ItemListener() {
		    
		    @Override
		    public void itemStateChanged(ItemEvent arg0) {

			if ( arg0.getStateChange() == ItemEvent.SELECTED) {
			    
			    TipoEmpleado tie = (TipoEmpleado) arg0.getItem();
			    
			    if ( tie == TipoEmpleado.COMPLETO) {
				
			    }
			}
		    }
		});
		cbTipo.setModel(new DefaultComboBoxModel<TipoEmpleado>(TipoEmpleado.values()));
		cbTipo.setSelectedIndex(-1);
		cbTipo.setEnabled(false);
		add(cbTipo, "cell 2 8,growx");
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido: ");
		add(lblSegundoApellido, "cell 4 8,alignx trailing");
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setToolTipText("Más de dos apellidos serán ingonrados.");
		textSegundoApellido.setEditable(false);
		textSegundoApellido.setColumns(10);
		add(textSegundoApellido, "cell 5 8,growx");
		
		btnModificarEmpleado = new JButton("Modificar empleado");
		btnModificarEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textDNIBusqueda.setEditable(false);
				
				if ( empleado != null 
						&& !textDNIBusqueda.getText().equals("")
						&& !textPrimerApellido.getText().equals("")
						&& !textSegundoApellido.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& cbTipo.getSelectedIndex() > -1
						&& cbDepartamento.getSelectedIndex() > -1) {
					
					/*empleado.setDNI(textDNIBusqueda.getText());
					empleado.setNombre(textNombre.getText());
					
					try {
						empleado.setTipo( (TipoEmpleado) cbTipo.getSelectedItem());
						empleado.setDepartamento( (Departamento) cbDepartamento.getSelectedItem());
						
						if ( textPrimerApellido.getText().equals("") ) {
							JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							empleado.setPrimerApellido(textPrimerApellido.getText().trim());
							if ( !textSegundoApellido.getText().equals("") )
								empleado.setSegundoApellido(textSegundoApellido.getText().trim());
							
							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_EMPLEADO, empleado);
						}
					}
					catch (ClassCastException cce) {
						JOptionPane.showMessageDialog(contentPane, "No se ha seleccionado un tipo o departamento", "Error", JOptionPane.ERROR_MESSAGE);
					}*/
				    
				    if ( textHoras.isVisible() ) {

					    if ( !textHoras.getText().trim().equals("")) {
						
						try {
						    
						    if (Integer.valueOf(textHoras.getText().trim()) <= 7) {
							
							((EmpleadoParcial)empleado).setHoras( Integer.valueOf(textHoras.getText().trim()));
							   
							empleado.setNombre(textNombre.getText());
							empleado.setDepartamento( (Departamento)cbDepartamento.getSelectedItem());
							
							if ( textPrimerApellido.getText().equals("") ) {
								JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else {
								empleado.setPrimerApellido(textPrimerApellido.getText().trim());
								
								if ( !textSegundoApellido.getText().equals("") )
									empleado.setSegundoApellido(textSegundoApellido.getText().trim());
								
								ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_EMPLEADO, empleado);
							}
						    }
						    else {
							JOptionPane.showMessageDialog(contentPane, "Las horas no pueden superar 7", "Aviso", JOptionPane.WARNING_MESSAGE);
						    }
						}
						catch ( NumberFormatException nu) {
						    JOptionPane.showMessageDialog(contentPane, "Solo puede insertar números en las horas", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
					    }
					    else {
						JOptionPane.showMessageDialog(contentPane, "El campo horas no puede estar vacío", "Aviso", JOptionPane.WARNING_MESSAGE);
					    }
					}
					else if ( cbPlaza.isVisible() ) {
					    
					    if ( cbPlaza.getSelectedIndex() > -1) {
						
						((EmpleadoTotal)empleado).setPlazaAparcamiento( (TipoPlazaParking)cbPlaza.getSelectedItem());

						empleado.setNombre(textNombre.getText());
						empleado.setDepartamento( (Departamento)cbDepartamento.getSelectedItem());
						
						if ( textPrimerApellido.getText().equals("") ) {
							JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							empleado.setPrimerApellido(textPrimerApellido.getText().trim());
							
							if ( !textSegundoApellido.getText().equals("") )
								empleado.setSegundoApellido(textSegundoApellido.getText().trim());
							
							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_EMPLEADO, empleado);
						}
					    }
					    else {
						JOptionPane.showMessageDialog(contentPane, "Debe seleccionar el tipo de plaza de parking", "Aviso", JOptionPane.WARNING_MESSAGE);
					    }
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setVisible(false);
		add(lblHoras, "cell 1 10,alignx trailing");
		
		textHoras = new JTextField();
		textHoras.setVisible(false);
		add(textHoras, "cell 2 10,growx");
		textHoras.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento: ");
		add(lblDepartamento, "cell 4 10,alignx trailing");
		
		cbDepartamento = new JComboBox<>();
		cbDepartamento.setEnabled(false);
		add(cbDepartamento, "cell 5 10,growx");
		
		lblPlaza = new JLabel("Plaza:");
		lblPlaza.setVisible(false);
		add(lblPlaza, "cell 1 11,alignx trailing");
		
		cbPlaza = new JComboBox<>();
		cbPlaza.setModel(new DefaultComboBoxModel<TipoPlazaParking>(TipoPlazaParking.values()));
		cbPlaza.setSelectedIndex(-1);
		cbPlaza.setVisible(false);
		add(cbPlaza, "cell 2 11,growx");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 1 12 6 1,growx,aligny center");
		add(btnModificarEmpleado, "cell 5 13");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_MODIFICAR_EMPLEADO == idEvento ) {
			
			if ( datos instanceof Empleado ) {
				
			    Empleado correcto = (Empleado) datos;
				
			    if ( correcto != null ) {
				textDNIBusqueda.setText("");
				textNombre.setText("");
				textNombre.setEditable(false);
				textPrimerApellido.setText("");
				textPrimerApellido.setEditable(false);
				textSegundoApellido.setText("");
				textSegundoApellido.setEditable(false);
				
				cbTipo.setSelectedIndex(-1);
				cbTipo.setEnabled(false);
				cbDepartamento.setSelectedIndex(-1);
				cbDepartamento.setEnabled(false);
				
				lblHoras.setVisible(false);
				textHoras.setText("");
				textHoras.setVisible(false);
				
				lblPlaza.setVisible(false);
				cbPlaza.setVisible(false);
				cbPlaza.setSelectedIndex(-1);
				
				btnModificarEmpleado.setEnabled(false);
				
				JOptionPane.showMessageDialog(contentPane, "El empleado se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			    }
			}
			else {
				
				JOptionPane.showMessageDialog(contentPane, "El empleado no se ha modificado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
			}
			empleado = null;
			
		}
		else if ( IDEventos.EVENTO_CONSULTAR_EMPLEADOS_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof Empleado) {
				
				empleado = (Empleado) datos;
				
				textNombre.setText(empleado.getNombre());
				textNombre.setEditable(true);
				textPrimerApellido.setText(empleado.getPrimerApellido());
				textPrimerApellido.setEditable(true);
				textSegundoApellido.setText(empleado.getSegundoApellido());
				textSegundoApellido.setEditable(true);
				
				cbTipo.setSelectedItem(empleado.getTipo());
				
				ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO, null);

				if ( empleado.getTipo() == TipoEmpleado.HORAS) {
				    lblHoras.setVisible(true);
				    textHoras.setVisible(true);
				    textHoras.setText( String.valueOf( ((EmpleadoParcial)empleado).getHoras() ) );
				}
				else if ( empleado.getTipo() == TipoEmpleado.COMPLETO) {
				    lblPlaza.setVisible(true);
				    cbPlaza.setVisible(true);
				    cbPlaza.setSelectedItem( (TipoPlazaParking) ((EmpleadoTotal)empleado).getPlazaAparcamiento());
				}
				
				btnModificarEmpleado.setEnabled(true);
			}
		}
		else if (IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO == idEvento) {
		    
		    if ( datos instanceof List) {
			
			@SuppressWarnings("unchecked")
			List<Departamento> listaDepartamentos = (List<Departamento>) datos;
			
			DefaultComboBoxModel<Departamento> model = new DefaultComboBoxModel<Departamento>();
			
			for ( Departamento dep : listaDepartamentos ) {
				
				model.addElement(dep);
			}
			
			cbDepartamento.setEnabled(true);
			cbDepartamento.setModel(model);
			cbDepartamento.setSelectedItem(empleado.getDepartamento());
		    }
		}
		else if ( IDEventos.ERROR_MODIFICAR_EMPLEADO == idEvento || IDEventos.ERROR_CONSULTAR_EMPLEADOS_V_MODIFICAR == idEvento || IDEventos.ERROR_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO == idEvento) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}