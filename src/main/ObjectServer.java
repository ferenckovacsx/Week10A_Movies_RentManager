package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer
{
	public void initServerSocket()
	{
		try
		{	
			ServerSocket serverSocket = new ServerSocket(9999);
			Socket clientSocket = serverSocket.accept();
			ObjectOutputStream streamtoClient = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream streamFromClient = new ObjectInputStream(clientSocket.getInputStream());

			FileOutputStream fos = new FileOutputStream("sample.ser", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			serverSocket.close();
	        clientSocket.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
}