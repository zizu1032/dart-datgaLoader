package com.dart.loader.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.dart.loader.bean.FileSampleCSVBean;
import com.dart.loader.exception.DataLoaderException;
import com.dart.loader.exception.FIleUpLoadException;
import com.dart.loader.report.ReportYaml;
import com.dart.loader.utils.ReadFileCSV;
import com.dart.loader.view.GridInformationData;

public class UpLoadActionListener implements ActionListener{
	static private final String newline = "\n";
	private JButton openButton, reportButton;
    private JTextArea log;
    private JFileChooser fc;
    private JPanel jpanel;
    private JTable jtable;
    private int option;
    
	public UpLoadActionListener(JButton openButton,
			JFileChooser fc,JTextArea log, JPanel jpanel,
			JTable jtable, int option) {
		this.openButton = openButton;
		this.fc = fc;
		this.log = log;
		this.jpanel = jpanel;
		this.jtable = jtable;
		this.option = option;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 //Handle open button action.
        if (option == 1) {
            int returnVal = fc.showOpenDialog(jpanel);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
                ReadFileCSV read = new ReadFileCSV();
                try {
                FileSampleCSVBean fileCSV = read.readFileCSV(file);
                GridInformationData grid =new GridInformationData();
                TableModel model = grid.createGrid(fileCSV);
                
                this.jtable.setModel(model);
    		    RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

    		    jtable.setRowSorter(sorter);
                
                log.append(fileCSV != null ? "Successful" + newline:"Something was wrong"+ newline);
                }catch (FIleUpLoadException ex) {
                	ex.printStackTrace();
                log.append("Error .." + ex.getMessage());	
                };
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
 
        //Handle save button action.
        } else {
        
        	 int returnVal = fc.showSaveDialog(jpanel);
        	 
             if (returnVal == JFileChooser.APPROVE_OPTION) {
                 File file = fc.getSelectedFile();
                 ReportYaml yaml = new ReportYaml();
                 try {
					yaml.creatrReport(jtable, 20, file);
				} catch (DataLoaderException e1) {
					// TODO Auto-generated catch block
					log.append("Error .." + e1.getMessage());
				}
                 //This is where a real application would open the file.
                 log.append("saving file: " + file.getName() + "." + newline);
             }

            log.setCaretPosition(log.getDocument().getLength());
        }
	}

}
