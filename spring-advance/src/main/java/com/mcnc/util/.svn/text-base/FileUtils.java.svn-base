package com.mcnc.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
	public static final String DEFAULT_FILE_EXTENSION = "jpg";
	
	public static ByteArrayOutputStream readFile(File file){
		ByteArrayOutputStream ous = new ByteArrayOutputStream();
		InputStream ios = null;
	    try {
	    	ios = new FileInputStream(file);
	        byte[] buffer = new byte[4096];
	        int read = 0;
	        while ( (read = ios.read(buffer)) != -1 ) {
	            ous.write(buffer, 0, read);
	        }
	    } catch( Exception ex ){
	    	
	    } finally { 
	        try {
	             if ( ous != null ) 
	                 ous.close();
	             
	        } catch ( IOException e) {
	        }

	        try {
	             if ( ios != null ) 
	                  ios.close();
	        } catch ( IOException e) {
	        	
	        }
	    }
	    return ous;
	}
	
	
	public static String getExtension(File file){
		String extension = FileUtils.DEFAULT_FILE_EXTENSION;
		String fileName = file.getName();

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i + 1);
		}
		return extension;
	}
}
