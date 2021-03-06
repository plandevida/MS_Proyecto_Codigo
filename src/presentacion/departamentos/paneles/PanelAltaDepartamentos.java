/**
 * 
 */
package presentacion.departamentos.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.departamentos.objetonegocio.Departamento;
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
public class PanelAltaDepartamentos extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	
	private JPanel contentPane;

	public PanelAltaDepartamentos() {
		
		contentPane = this;
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][34px][161.00px,grow][12.00px][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][24.00][30.00px][24.00][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta departamentos");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 0 0 9 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 9 1,growx,aligny center");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 3,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 2 3,growx,aligny top");
		textNombre.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 6 9 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Departamento departamento = new Departamento();
				
				if ( !textNombre.getText().equals("")) {
					
					departamento.setNombre(textNombre.getText());
						
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_DEPARTAMENTO, departamento);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(btnAceptar, "cell 7 7,alignx left,aligny top");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ALTA_DEPARTAMENTO == idEvento ) {
		
			if ( datos instanceof Departamento ) {
				
				JOptionPane.showMessageDialog(contentPane, "Departamento creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	
				textNombre.setText("");
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al dar de alta un departamento", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_ALTA_DEPARTAMENTO == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}