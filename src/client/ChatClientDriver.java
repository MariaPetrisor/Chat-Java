package client;

import java.rmi.*;
import server.ChatServerIF;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ChatClientDriver {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		if (args.length != 2){
			System.out.println("Usage: java ChatClientDriver <nume client> <port>");
			System.exit(1);
		}
		String port = args[1];
		int portInt = Integer.parseInt(port);
		 Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", portInt);
		 
		 
		//String chatServerURL="//localhost/RMIChatServer";
		
		ChatServerIF chatServer=(ChatServerIF) myRegistry.lookup("RMIChatServer");
		new Thread(new ChatClient(args[0], chatServer)).start();
	}

}
