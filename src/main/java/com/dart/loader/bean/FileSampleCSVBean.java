package com.dart.loader.bean;


import java.util.ArrayList;
import java.util.List;


public class FileSampleCSVBean {

	/**
	 * List of headers 
	 */
	private List<StringBuilder> listHeaders = new ArrayList<StringBuilder>();

	/**
	 * List of Samples in rows
	 */
	private List <RowCSV> listRowCSV = new ArrayList<RowCSV>();

	/**
	 * Get list of Header to file CSV
	 * @return List String Builder
	 */
	public List<StringBuilder> getListHeaders() {
		return listHeaders;
	}

	/**
	 * Set List header of CSV
	 * @param listHeaders
	 */
	public void setListHeaders(List<StringBuilder> listHeaders) {
		this.listHeaders = listHeaders;
	}

	public List<RowCSV> getListRowCSV() {
		return listRowCSV;
	}

	public void setListRowCSV(List<RowCSV> listRowCSV) {
		this.listRowCSV = listRowCSV;
	}

}

