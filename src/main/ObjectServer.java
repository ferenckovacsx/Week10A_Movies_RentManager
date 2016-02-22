package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ObjectServer
{
	public static void initServer()
	{
		ServerSocket serverSocket = null;
		ServerMode servermode = null;
		try
		{
			serverSocket = new ServerSocket(8888);
			System.out.println("Server Waiting...");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client is connected!");
			ObjectInputStream serverInputStream = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

			FileOutputStream fos = new FileOutputStream("sample.ser", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			while (true)
			{
				if (serverInputStream.read() > -1)
				{
					Object objectFromClient = serverInputStream.readObject();
					if (objectFromClient instanceof Command && objectFromClient == Command.EXIT)
					{
						System.out.println("EXIT");
						break;
					} else if (objectFromClient instanceof Command && objectFromClient == Command.GET)
					{
						servermode = ServerMode.LOAD;
						Object o = loadFromFile();
						System.out.println("Load data from file to client.");
						List<Object> castedList = (List<Object>) o;
						serverOutputStream.writeObject(o);
					} else if (objectFromClient instanceof Command && objectFromClient == Command.PUT)
					{
						servermode = ServerMode.SAVE;
						System.out.println("Switch to save mode.");
						System.out.printf("Server mode: " + servermode + "\n");
					}
				}
				serverSocket.close();
				clientSocket.close();
			}
		}

		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private static void saveToFile()
	{
		Object object = new Object();
		try
		{
			FileOutputStream fos = new FileOutputStream("sample.ser", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			System.out.println("Saving to file...");
			oos.writeObject(object);

			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static Object loadFromFile()
	{
		try
		{
			FileInputStream fis = new FileInputStream("sample.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			System.out.println("Loading data from file...");
			Object objectFromFile;
			while ((objectFromFile = ois.readObject()) != null)
			{

				System.out.println("Printing out loaded elements...");

				System.out.println();
			}
			System.out.println("Closing all input streams...\n");
			ois.close();
			fis.close();
			return objectFromFile;
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args)
	{
		initServer();
	}
}