package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingServer {

	// server-side socket for accepting incoming TCP connections
	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public MessageConnection accept() {

		MessageConnection connection = null;

		// TODO - START
		try {

			// accept an incoming connection from a client
			Socket clientSocket = welcomeSocket.accept();

			// accept TCP connection on welcome socket and create messaging connection to be returned
			connection = new MessageConnection(clientSocket);

		} catch (IOException e) {
			System.err.println("Failed to accept the connection:" + e.getMessage());
			e.printStackTrace();

		}

		// TODO - END

		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
