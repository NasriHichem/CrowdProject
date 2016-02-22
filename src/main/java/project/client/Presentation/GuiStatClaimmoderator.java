	package project.client.Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import project.client.locators.ClaimDelegate;

public class GuiStatClaimmoderator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiStatClaimmoderator frame = new GuiStatClaimmoderator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiStatClaimmoderator() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JFreeChart barChart = ChartFactory.createBarChart(
		         "CLAIM STATIStICS", 
		         "CLAIM", "number", 
		         createDataset(),PlotOrientation.VERTICAL, 
		         true, true, false);
	   ChartPanel chartPanel = new ChartPanel( barChart );        
       chartPanel.setPreferredSize(new java.awt.Dimension( 700 , 367 ) );        
       setContentPane( chartPanel ); 
  }
  private CategoryDataset createDataset( )
  {
     final String fiat = "Claims";        
        
     final String janvier = "Jan";   
     final String fevrier = "Feb"; 
     final String mars = "mar"; 
     final String avril = "apr"; 
     final String mai = "may"; 
     final String juin = "jun"; 
     final String juillet = "jul"; 
     final String aout = "aug"; 
     final String septembre = "sep"; 
     final String octobre = "oct"; 
     final String novembre = "nov"; 
     final String decembre = "dec"; 
            
     final DefaultCategoryDataset dataset = 
     new DefaultCategoryDataset( );  

     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-01-01", "2016-01-31") , fiat , janvier );        
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-02-01", "2016-02-29") , fiat , fevrier );        
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-03-01", "2016-03-31") , fiat , mars ); 
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-04-01", "2016-04-30") , fiat , avril );           
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-05-01", "2016-05-31") , fiat , mai );        
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-06-01", "2016-06-30") , fiat , juin );        
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-07-01", "2016-07-31") , fiat , juillet ); 
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-08-01", "2016-08-31") , fiat , aout ); 
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-09-01", "2016-09-30") , fiat , septembre );        
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-10-01", "2016-10-31") , fiat , octobre );        
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-11-01", "2016-11-30") , fiat , novembre ); 
     dataset.addValue( ClaimDelegate.getclaimbymonth("2016-12-01", "2016-12-31") , fiat , decembre ); 
                  

     return dataset; 
  }

}
