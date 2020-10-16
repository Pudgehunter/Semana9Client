package co.domi.semana9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDP extends Thread {

	private DatagramSocket socket;

	public void run() {
		
		try {
			//1. Escuchar
			socket = new DatagramSocket(6000);
			
			//2 Esperar mensajes: DatagramSocket
			
			while(true) {
				//2 Params en constructor
				byte[] buffer = new byte[100];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				System.out.println("Esperando datagrama");
				socket.receive(packet);
				
				//Aqu� recibo los mensajes de Android
				String mensaje = new String(packet.getData());		
				System.out.println("Datagrama recibido: "+ mensaje);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String mensaje) {
		//4 params, datagrama de envio
		new Thread(
			() -> {
				try {
					InetAddress ip = InetAddress.getByName("192.168.1.2");
					DatagramPacket packet = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,ip,5000);
					socket.send(packet);
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		).start();	
	}
	
}
