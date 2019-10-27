package com.dart.csv;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.dart.loader.bean.FileSampleCSVBean;
import com.dart.loader.exception.FIleUpLoadException;
import com.dart.loader.utils.ReadFileCSV;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestCSV {

	private File testFile;
	
	@Before
	public void initResources() {
		try {
			testFile = new File("src/test/resources/testfile/input-data.csv");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test1ExampleTesting() throws FIleUpLoadException {
		ReadFileCSV read = new ReadFileCSV();
		FileSampleCSVBean fileCSV = read.readFileCSV(testFile);
		Assert.assertNotNull(fileCSV);
	}
}
