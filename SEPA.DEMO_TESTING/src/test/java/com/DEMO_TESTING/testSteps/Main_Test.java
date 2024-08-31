package com.DEMO_TESTING.testSteps;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;
import com.methods.conn.Server_Connection;

public class Main_Test {
	
	public static Session session;
	public static Channel channel;
	public static InputStream in;
	public static List<String> al =  new ArrayList<String>();
	public static String outline;
	public static OutputStream out;
	public static String cmd ="./IncomingFile700IN.sh /var/SP/sepa_nas/mmweb/legacy/ES/PP/RMCA/in/VFES_RMCA_PP_BBV_SDDCORE_ES4101823994040101512391_20171031_194461.xml"; 

	public static void main(String[] args) {
		
		Server_Connection SC = new Server_Connection(session, channel, in,out, outline,al);
		SC.Connect_Server();
		SC.Execute_Commands(cmd);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SC.Disconnect_server();
	}

}
