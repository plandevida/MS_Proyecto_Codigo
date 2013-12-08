/**
 * 
 */
package presentacion.clientes.frames;

import javax.swing.JPanel;

import presentacion.clientes.GUIInterfazClientes;
import presentacion.controladores.aplicacion.ControladorAplicacion;
import negocio.clientes.transfer.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollBar;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FrameBajaClientes extends JPanel implements GUIInterfazClientes {
	public FrameBajaClientes() {
		
		ControladorAplicacion.getInstance();
		
		setLayout(new BorderLayout(0, 0));
		
		final JList<TransferCliente> list = new JList();
		add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setMinimumSize(new Dimension(15, 14));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new MigLayout("", "[][][][][][][][][]", "[][]"));
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.getSelectedIndices();
				
			}
		});
		panel.add(btnNewButton, "cell 8 1");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}