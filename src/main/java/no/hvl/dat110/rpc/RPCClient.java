package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		// connect using the RPC client
		connection = msgclient.connect();
		
	}
	
	public void disconnect() {
		
		// disconnect by closing the underlying messaging connection
		connection.close();
	}

	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and param into an RPC message
		byte[] rpcMessage = RPCUtils.encapsulate(rpcid, param);
		
		// Send the RPC message to the server
		connection.send(new Message(rpcMessage));
		
		// Receive the RPC reply message from the server
		Message replyMessage = connection.receive();
		
		// Decapsulate the payload from the RPC reply message
		returnval = RPCUtils.decapsulate(replyMessage.getData());
		
		// TODO - END
		return returnval;
		
	}

}
