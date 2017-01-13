package client;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface ChatClientIF extends Remote {
	void retrieveMessage(String message) throws RemoteException;
	String getName() throws RemoteException;
}
