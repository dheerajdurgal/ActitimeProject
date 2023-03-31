package com.Actitime.GenericLiberaries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
/**
 * THIS CLASS IS A GENERIC CLASS WHICH IS HAVING NON STATIC METHODS TO PERFORM DATA DRIVEN TESTING
 * (WE CAN DO DATADRIVEN TESTING FOR EXCEL FILE AS WELL AS PROPERTY FILE)
 * @author ASUS
 *
 */

public class FileLiberary {
public String readdatafromproperty(String key) throws IOException {//HERE RETURN TYPE FOE METHOD IS 'STRING',WE NOT USED 'VOID' BECAUSE WE RETURNING THE 'value'
	FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
	Properties p = new Properties();//WE CREATE OBJECT FOR PROPERTIES CLASS TO CALLED NONSTATIC METHOD AS LOAD(),GETPROPERTY()
	p.load(fis);//LOAD()METHOD LOAD THE PROPERTY FILE WHICH IS PRESENT IN fis VARIABLE
	String value = p.getProperty(key);//HERE WE DIRECTY NOT USE 'URL'BECAUSE WE DESIGN HERE SO IF WE TAKE 'URL'THEN IT IS ONLY APPLICABLE FOR URL NOT FOR THE OTHER PARAMETERS
	return value;
}
}
