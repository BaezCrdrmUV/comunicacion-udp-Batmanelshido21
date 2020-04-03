import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int PUERTO = 5000;
		byte[] buffer = new byte[1024];
		boolean opcion= true;
		try {
			System.out.println("El servidor ha iniciado");
			DatagramSocket socketUDP = new DatagramSocket(PUERTO);
			while(opcion=true) {
				
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(peticion);
				System.out.println("Recibo informacion del cliente");
				String mensaje = new String(peticion.getData());
				System.out.println(mensaje);

				if(mensaje.equals("bye")) {
					System.out.println("entró");
					int puertoCliente = peticion.getPort();
					InetAddress direccion = peticion.getAddress();
					buffer = mensaje.getBytes();
					DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, PUERTO);
					System.out.println("Envio la información al cliente");
					socketUDP.send(respuesta);
					opcion = false;
				}
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
