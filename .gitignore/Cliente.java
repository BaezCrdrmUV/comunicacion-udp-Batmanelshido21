import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		final int PUERTO = 5000;
		byte[] buffer = new byte[1024];
		try {
			InetAddress direccionServidor = InetAddress.getByName("localhost");
			DatagramSocket socketUDP = new DatagramSocket();
			System.out.println("Introduce el texto");
			String mensaje = lector.nextLine();
			buffer = mensaje.getBytes();
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO);
			socketUDP.send(pregunta);

			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			socketUDP.receive(peticion);
			mensaje = new String(peticion.getData());
			System.out.println(mensaje);
			socketUDP.close();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
