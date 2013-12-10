package presentacion.comandos.habitacion;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

public class CommandConsultaHabitacionVentanaAlta implements Command {

	@Override
	public CommandResponse execute(Object datos) {

		FactorySA factoriaSa = FactorySA.getInstance();

		TransferCliente cliente = null;
		CommandResponse cr = new CommandResponse();
		try {
			String dniCliente = (String) datos;
			
			cliente = factoriaSa.getSAClientes().obtenerCliente(dniCliente);

			cr.setDatos(cliente);
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_HABITACION_V_ALTA);

		} catch (BSoDException bsod) {

			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_HABITACION_V_ALTA);
		}

		return cr;
	}
}
