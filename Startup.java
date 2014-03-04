//import java.lang.*;
import java.io.*;

public class Startup
{
	public static void main(String args[])
	{
		Strt_stop_network ssn=new Strt_stop_network();
		ssn.init_network();
		ssn.strt_network();
		
		Strt_server ss= new Strt_server();
		ss.strt();
	}
}

class Strt_server
{
	String s;
	String cmd[];
	Runtime runtime;
	Process process;
	void strt()
	{
		try
		{
			s="cd Server/bin/ftpd.bat Server/res/conf/Qaccess_conf.xml";
			cmd= new String[]{"cmd.exe", "/c", "Start"+s};
			runtime = Runtime.getRuntime();
			process = runtime.exec(cmd);
		}
		catch(IOException e)
		{
			System.out.println("Unable to start Server..!!");
		}
	}
}

class Strt_stop_network
{
	String s;
	String[] cmd;
	Runtime runtime;
	Process process;
	void init_network()
	{
		try
		{
			s="C:/Windows/System32/netsh wlan set hostednetwork mode"+'='+"allow ssid"+'='+"QAccess key"+'='+"thesteam keyUsage"+'='+"persistent & exit";
			cmd= new String[]{"cmd.exe", "/c", "start "+s};
			runtime = Runtime.getRuntime();
			process = runtime.exec(cmd);
		}
		catch(IOException e)
		{
			System.out.println("Could not initialise network..!!");
		}
	}
	
	void strt_network()
	{
		try
		{
			cmd= new String[]{"cmd.exe", "/c", "start C:/Windows/System32/netsh wlan start hostednetwork & exit"};
			process = runtime.exec(cmd);
		}
		catch(IOException e)
		{
			System.out.println("Could not Start Network...!!");
		}
	}
	
	void stop_network()
	{
		try
		{
			cmd= new String[]{"cmd.exe", "/c", "start C:/Windows/System32/netsh wlan stop hostednetwork & exit"};
			process = runtime.exec(cmd);
		}
		catch(IOException e)
		{
			System.out.println("Could not Stop Network...!!");
		}
	}
}


