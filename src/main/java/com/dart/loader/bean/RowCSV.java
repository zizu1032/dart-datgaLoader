package com.dart.loader.bean;

import java.util.ArrayList;
import java.util.List;

public class RowCSV {

	/**
	 * List to store the rows of file csv
	 */
	private List<StringBuilder> listRow = new ArrayList<StringBuilder>();

	/**
	 * Get list of Rows of file CSV
	 * @return List
	 */
	public List<StringBuilder> getListRow() {
		return listRow;
	}

	/**
	 * Set List rows of the samples
	 * @param listRow
	 */
	public void setListRow(List<StringBuilder> listRow) {
		this.listRow = listRow;
	}

}

