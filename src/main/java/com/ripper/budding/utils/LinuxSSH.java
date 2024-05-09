package com.ripper.budding.utils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import org.apache.poi.hssf.record.PageBreakRecord.Break;
//import org.apache.tools.ant.taskdefs.optional.ccm.Continuus;
//
//
//public class LinuxSSH  extends Thread{
//
//	@SuppressWarnings("resource")
//	public static void LinuxLog(String pwd){
//		String hostname = "192.168.130.240";
//		String username = "root";
//		String password = pwd;
//		try{
////			Connection conn = new Connection(hostname);
//			try {
//				conn.connect();
//			} catch (IOException e) {
//				System.err.println(e.getLocalizedMessage());
//			}
//			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
//			if (isAuthenticated == false){
//				//throw new IOException("Authentication failed.");
//				System.err.println(pwd);
//				return;
//			}
//			//Session sess = conn.openSession();
//			//sess.execCommand("cd /var/log && less secure");
//			//System.out.println("Here is some information about the remote host:");
//			/*InputStream stdout = new StreamGobbler(sess.getStdout());
//			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
//			while (true){
//				String line = br.readLine();
//				if (line == null)
//					break;
//				System.out.println(line);
//			}
//			System.out.println("ExitCode: " + sess.getExitStatus());*/
//			//sess.close();
//			conn.close();
//		}catch (IOException e){
//			e.printStackTrace(System.err);
//			System.exit(2);
//		}
//	}
//
//	public void run(){
//		while(true){
//			String[] pwds = {"123456","sdsdsds","dsdsds","dsdsds","rwerw","qweqwe","hghghgh","dsfsdger","rtredsds","dsadasdas"};
//			LinuxLog(pwds[(int)(Math.random()*10)]);
//			try {
//				Thread.sleep(1*1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		new LinuxSSH().start();
//	}
//
//}
