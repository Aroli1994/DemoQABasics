package com.qa.selenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DataReadingFromFile {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;
				//reader1 = null;
		//PrintWriter writer = null;
		FileReader fileReader = null;
		//FileWriter fileWriter = null;
		int lineCount = 0, wordCound = 0, charCount = 0;
		try {
			//fileReader = new FileReader("C:\\Users\\vinaya.ka.YCS\\Desktop\\tjninmdev.txt");
			fileReader = new FileReader("C:\\Users\\vinaya.ka.YCS\\Desktop\\Airtime Purchase Req");
			
			reader = new BufferedReader(fileReader);

			String currentLine = reader.readLine();
			while (currentLine != null) {
				System.out.println(currentLine);
				lineCount = lineCount + 1;
				String[] words = currentLine.split(" ");
				wordCound = wordCound + words.length;

				for (String word : words) {
					charCount = charCount + word.length();
				}
				currentLine = reader.readLine();
			}
			System.out.println("Number of chars in a file: " + charCount);
			System.out.println("Number of words in a file: " + wordCound);
			System.out.println("Number of lines in a file: " + lineCount);

			
			
			/*// create a buffered reader that connects to the console, we use it so we can
			// read lines
			reader1 = new BufferedReader(new InputStreamReader(System.in));
			// create an file writer object for path of file where data needs to be written and append=true
			fileWriter = new FileWriter("vinay.txt",true);
			// create an print writer for writing to a file and auto-flush=true
			writer = new PrintWriter(fileWriter,true);
			// read a line from the console
			String line = reader1.readLine();
			//while (line != null) {
				// output to the file a line
				writer.println(line);
			//	line=reader1.readLine();
			//}
				*/
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close the file
			fileReader.close();
			//fileWriter.close();
			reader.close();
			//reader1.close();
		}
	}

}
