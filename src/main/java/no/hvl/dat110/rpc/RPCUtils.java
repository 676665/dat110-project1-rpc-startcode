package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		// TODO - START
		
		byte[] rpcmsg = new byte[payload.length + 1];

		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		rpcmsg[0] = rpcid;
		System.arraycopy(payload, 0, rpcmsg, 1, payload.length);
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		// TODO - START
		
		byte[] payload = new byte[rpcmsg.length - 1];
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		System.arraycopy(rpcmsg, 1, payload, 0, payload.length);
		
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		return str.getBytes();
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		return new String(data);
	}
	
	public static byte[] marshallVoid() {
		return new byte[0];
	}
	
	public static void unmarshallVoid(byte[] data) {
		// No action needed
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = new byte[4];
		
		// TODO - START 
		
		encoded[0] = (byte)(x >> 24); // Highest byte
		encoded[1] = (byte)(x >> 16); 
		encoded[2] = (byte)(x >> 8);
		encoded[3] = (byte)x; // Lowest byte
		
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		// TODO - START 
		
		int decoded = ((data[0] & 0xFF) >> 24) | (data[1] & 0xFF >> 16) |
					   (data[2] & 0xFF >> 8) | (data[3] & 0xFF);
		
		// TODO - END
		
		return decoded;
		
	}
}
