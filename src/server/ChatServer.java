package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import client.ChatClientIF; //++

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
	//private static final long serialVersionUID = 1L;
	
	private ArrayList<ChatClientIF> chatClients;
	
	protected ChatServer() throws RemoteException {
		chatClients = new ArrayList<ChatClientIF>();
		//
	}
	
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException{
		boolean flag=false;
		for(int i=0; i<chatClients.size(); i++)
		{
			if(chatClients.get(i).getName().equals(chatClient.getName()))
				flag=true;
		}
		
		if(flag==false)
		this.chatClients.add(chatClient);
		else
			System.out.println("Client's name exists!");
		
	}
	
	public synchronized void broadcastMessage(String message) throws RemoteException {
		int i;
		for(i=0; i<chatClients.size(); i++)
			chatClients.get(i).retrieveMessage(message);
		
		
	}
}