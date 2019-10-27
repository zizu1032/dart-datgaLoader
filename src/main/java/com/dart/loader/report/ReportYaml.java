package com.dart.loader.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.dart.loader.exception.DataLoaderException;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlWriter;

public class ReportYaml {

	public void creatrReport(JTable jtable, int rowNumber, File file)  throws DataLoaderException{
	
	Map<String, String> map = new HashMap<>();
	
	TableModel model = jtable.getModel();
		for (int rowIndex = 0 ; rowIndex < rowNumber; rowIndex++ ) {
			for (int columnIndex = 0 ; columnIndex < model.getColumnCount(); columnIndex ++) {
			map.put(rowIndex+model.getColumnName(columnIndex), model.getValueAt(rowIndex, columnIndex).toString());
		}
	}
		YamlWriter writer = null;
	try {
	    writer = new YamlWriter (new FileWriter(file));
		writer.write(map);
		writer.close();
	} catch (IOException e) {
		if (writer != null)
			try {
				writer.close();
			} catch (YamlException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		throw new DataLoaderException(e.getMessage());
	}
	
	}
}
