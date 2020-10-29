package com.qa.selenium;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		usingFileWriter();
	}

	public static void usingFileWriter()  
	{
	    String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
	     
	    FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("‪C:\\Users\\vinaya.ka.YCS\\Desktop\\o.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			fileWriter.write(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
