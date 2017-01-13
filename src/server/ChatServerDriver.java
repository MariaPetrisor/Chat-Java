package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ChatServerDriver 
{
	public static void main(String args[]) throws RemoteException, MalformedURLException
	{
		
		try
		{
			
			if (args.length != 1){
				System.out.println("Usage: java ChatServerDriver <port>");
				System.exit(1);
			}
			String port = args[0];
			int portInt = Integer.parseInt(port);
            Registry registry = LocateRegistry.createRegistry(portInt);
             
            
            registry.rebind("RMIChatServer", new ChatServer());
        } catch (Exception e)
		{
            e.printStackTrace();
        }     
        System.out.println("system is ready");
    }
    
}

