package com.ripper.budding.word;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) {
		  String lujing = "E:\\test\\ss\\ss.txt";
		  File file = new File(lujing);
		  if (!file.getParentFile().exists()) {
		   file.getParentFile().mkdirs();
		  }
		  try {
		   file.createNewFile();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }

		  try {
		   FileWriter fw = new FileWriter(file, true);
		   BufferedWriter bw = new BufferedWriter(fw);
		   bw.write("kingid");
		   bw.flush();
		   bw.close();
		   fw.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  try {
		   FileReader fr = new FileReader(file);
		   BufferedReader bReader = new BufferedReader(fr);
		   String string = bReader.readLine();
		   System.out.println(string);

		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }

		 }
}
