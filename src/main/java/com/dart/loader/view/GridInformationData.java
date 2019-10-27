package com.dart.loader.view;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dart.loader.bean.FileSampleCSVBean;
import com.dart.loader.bean.RowCSV;

public class GridInformationData  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public TableModel  createGrid(FileSampleCSVBean fileCSV) {
		
		String [] columns = getColumns(fileCSV.getListHeaders());
		
		Object [][] rows = getArrayRow(fileCSV);
		 TableModel model = new DefaultTableModel(rows, columns) {
		      public Class getColumnClass(int column) {
		        Class returnValue;
		        if ((column >= 0) && (column < getColumnCount())) {
		          returnValue = getValueAt(0, column).getClass();
		        } else {
		          returnValue = Object.class;
		        }
		        return returnValue;
		      }
		    };
		    
		    
		  return  model;
	}
	
	private String [] getColumns(List<StringBuilder> list) {
		String [] columns = new String [list.size()];
		for (int col = 0 ; col < list.size() ; col++) {
			columns[col] = list.get(col).toString();
		}
		return columns;
	}
	
	private Object [][] getArrayRow(FileSampleCSVBean fileCSV){
		Object rows[][] = new Object[fileCSV.getListRowCSV().size()]
				[fileCSV.getListHeaders().size()];
		
		for (int y = 0; y < fileCSV.getListRowCSV().size() ; y++) {
			RowCSV rowcsv = fileCSV.getListRowCSV().get(y);
			for (int x = 0 ; x < fileCSV.getListHeaders().size(); x++ ) {
				
				rows[y][x] =  rowcsv.getListRow().get(x); 
			}
		}
		
		
		return rows;
	} 
}