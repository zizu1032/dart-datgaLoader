package com.dart.loader.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.csvreader.CsvReader;
import com.dart.loader.bean.FileSampleCSVBean;
import com.dart.loader.bean.RowCSV;
import com.dart.loader.exception.FIleUpLoadException;


public class ReadFileCSV {

	private FileSampleCSVBean fileSampleCSV = new FileSampleCSVBean();
	public FileSampleCSVBean readFileCSV(File file) throws FIleUpLoadException {
		CsvReader reader = null; 
		try {
	      int numberColumn;
	       reader = new CsvReader(new FileReader(file));
	       reader.readRecord();
	       numberColumn = reader.getColumnCount();
	      
	       for (int sizeHeader = 0; sizeHeader < numberColumn; sizeHeader++){
				fileSampleCSV.getListHeaders().add
				(new StringBuilder(reader.get(sizeHeader)));
			}
	       while (reader.readRecord()){
				RowCSV row = new RowCSV();
				for (int sizeRow = 0; sizeRow < numberColumn; sizeRow++){
					row.getListRow().add(new StringBuilder(reader.get(sizeRow)));
				}
				fileSampleCSV.getListRowCSV().add(row);
			}
	       reader.close();
	       return fileSampleCSV;
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (reader!= null)
			reader.close();
			throw new FIleUpLoadException(e.getMessage());
		}
	}
}
