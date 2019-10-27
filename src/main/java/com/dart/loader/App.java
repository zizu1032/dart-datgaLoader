package com.dart.loader;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.dart.loader.control.UpLoadActionListener;


@SpringBootApplication
public class App  extends JFrame
{
	private JButton openButton, reportButton;
    private JTextArea log;
    private JFileChooser fc;
	private JScrollPane jscrollPaneGrid;
	private BorderLayout borderLayout;
	public App(){
		initUI();
	}
	
	 private void initUI() {
	        setTitle("Data Loader V 1.0.0");
	        setSize(1100, 850);
	        getContentPane().add(getJPanel());
	        
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }


	 private JPanel getJPanel() {
		 borderLayout = new BorderLayout();
		 JPanel jpanel = new JPanel(borderLayout);
		 log = new JTextArea(5,20);
	     log.setMargin(new Insets(5,5,5,5));
	     log.setEditable(false);
	     JScrollPane logScrollPane = new JScrollPane(log);
	     fc = new JFileChooser();
	     JTable jtable = new JTable ();
	     jscrollPaneGrid = new JScrollPane(jtable);
	     jscrollPaneGrid.setSize(1100, 455);
	     jscrollPaneGrid.setLocation(0, 30);
	     
	     openButton = new JButton("Open a File...");
	     openButton.addActionListener(new UpLoadActionListener(openButton, fc, log, jpanel, jtable, 1));
	     reportButton = new JButton ("Create Report");
	     reportButton.addActionListener(new UpLoadActionListener(reportButton, fc, log, jpanel, jtable, 2));
	     JPanel buttonPanel = new JPanel(); //use FlowLayout
	     buttonPanel.setSize(1100, 50);
	     buttonPanel.add(openButton);
	     buttonPanel.add(reportButton);
	     getContentPane().add(buttonPanel, BorderLayout.NORTH);
	     getContentPane().add(jscrollPaneGrid, BorderLayout.CENTER);
	     getContentPane().add(logScrollPane, BorderLayout.SOUTH);
		 return jpanel;
	 }
    
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext ctx = new SpringApplicationBuilder(App.class)
         .headless(false).run(args);

		 EventQueue.invokeLater(()-> {
		     App ex = ctx.getBean(App.class);
		     ex.setVisible(true);
		 });
    }
}
