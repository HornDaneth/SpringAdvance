package com.mcnc.service.api;
import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DynamicGroovyObject {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InstantiationException, IllegalAccessException {
		File file = new File("src/test/resources/com/mcnc/service/impl/highschool.groovy");
		if(file.exists()){
			GroovyClassLoader gcl = new GroovyClassLoader();
			FileReader fileReader = new FileReader(file);
			int fSize = (int) file.length();
			char[] rChars = new char[fSize];
			StringBuffer stringBuffer = new StringBuffer();
			while((fileReader.read(rChars)) != -1 ){
				stringBuffer.append(rChars);
			}
			fileReader.close();
			Class<?> clazz = gcl.parseClass(stringBuffer.toString());
			Object aScript = clazz.newInstance();
			IScoreService scoreService  = (IScoreService) aScript;
			System.out.println(scoreService.getGrade());
		}
		else{
			System.out.println("File not found:" + file.getAbsolutePath());
		}
	}

}
