package com.methods.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Server_Connection {

	public String username;
	public String hostname;
	public String password;
	public int port;
	public Session session;
	public Channel channel;
	public InputStream in;
	public OutputStream out;
	public String outputline;
	 List<String> al;
	
	public Server_Connection(Session session, Channel channel, InputStream in, OutputStream out, String outputline,List<String> al ) {
		this.username = "oracle";
		this.hostname = "inmbzp5165.in.dst.ibm.com";
		this.password = "M@in10DSTp@ssw0rd";
		this.port = 22;
		this.session = session;
		this.channel = channel;
		this.in = in;
		this.out = out;
		this.outputline = outputline;
		this.al = al;
	}
	
	public void Connect_Server() {

		java.util.Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		JSch jsch = new JSch();
		try {
			session = jsch.getSession(username,hostname,port);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setPassword(password);
		session.setConfig(config);
		try {
			session.connect();
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected to DST_DB");

	}

	public void Execute_Commands(String cmd)
	{
		try {
			channel=session.openChannel("exec");
		} catch (JSchException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		((ChannelExec)channel).setCommand(
				"export ORACLE_HOME=/opt/app/oracle/product/11.2.0/dbhome_2"
						+"&&export ORACLE_SID=orcl1"
						+"&&export PATH=$PATH:/usr/local/sbin:/usr/sbin:/sbin:/home/oracle/bin:/opt/app/oracle/product/11.2.0/dbhome_2/bin"
						+"&&cd mmVFfiles"
						+"&&"+cmd);
		channel.setInputStream(null);
		((ChannelExec)channel).setErrStream(System.err);
		try {
			in=channel.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			channel.connect();
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] tmp=new byte[2000];
        while(true)
        {
          try {
			while(in.available()>0)
			  {
				 System.out.println(in);
			    int i=in.read(tmp, 0, 2000);
			    System.out.println(i);
			    if(i<0)break;
			    outputline = new String(tmp,0,i);
			    al.add(outputline);
			    System.out.println(outputline);
			    
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         if(channel.isClosed()){
            System.out.println("exit-status: "+channel.getExitStatus());
            break;
          }
        }
	}

	public void Disconnect_server()
	{
		channel.disconnect();
		session.disconnect();
	}

}
