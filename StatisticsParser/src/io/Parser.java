package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class Parser {
	public static String readFromFile(String path) throws IOException {
		// TODO(1): Implementati functia readFromFile, care citeste un fisier si ii intoarce
		// continutul sub forma de String.
		
		BufferedReader file_read = new BufferedReader(new FileReader(path));
	        StringBuilder str = new StringBuilder();
	        String line = file_read.readLine();

	        while (line != null) {
	        	str.append(line);
	            str.append("\n");
	            line = file_read.readLine();
	        }
	    
	        file_read.close();
	        return str.toString();
		
	}


	
	}
