package project.client.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import project.client.locators.CategoryDelegate;
import project.client.locators.ProjectDelegate;
import project.client.mails.Sendmail;
import project.client.models.Projcts_Model;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

import projects.serveur.entites.Category;
import projects.serveur.entites.Project;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;



public class GuiCompteModirator extends JFrame {
	

	private JPanel contentPane;
	private JTable table_projects;
	private JTable table;
	private JComboBox<String> comboBox;
	private ArrayList<Category>categories=new ArrayList<>();
	private ArrayList<Project>projects=new ArrayList<>();
	JLabel lblnamep,lbltitle,lblshortp,lblduration,lbltarget,lbllocation,lblcat,lblnamec,lblcemail,
	lblCauseOfDenied;
	JPanel panel ;
	JTabbedPane tabbedPane;
	JButton btnConfirmed,btnDenied ;
	JEditorPane editorcause;
	int choix ;
	Integer index;
		
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCompteModirator frame = new GuiCompteModirator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public GuiCompteModirator() throws IOException, ParseException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 742);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccount = new JMenu("Account");
		mnAccount.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\user.png"));
		menuBar.add(mnAccount);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new authentification().setVisible(true);
			    dispose();
			}
		});
		mnAccount.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchProject = new JLabel("Search project by :");
		lblSearchProject.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblSearchProject.setForeground(new Color(0, 0, 128));
		lblSearchProject.setBounds(133, 44, 122, 14);
		contentPane.add(lblSearchProject);
		
		JRadioButton radioCat = new JRadioButton("Category");
		radioCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    catbuttonActionPerformed(e);		   
		}});
		ButtonGroup group=new ButtonGroup();
		
		radioCat.setBounds(132, 65, 109, 23);
		contentPane.add(radioCat);
		JRadioButton radioDate = new JRadioButton("Date");
		radioDate.setBounds(132, 91, 109, 23);
		contentPane.add(radioDate);
		
		JRadioButton radioName = new JRadioButton("Name");
		radioName.setBounds(132, 117, 109, 23);
		contentPane.add(radioName);
	
	    comboBox = new JComboBox<String>();
		comboBox.setBounds(142, 147, 70, 20);
		contentPane.add(comboBox);
		group.add(radioCat);
		group.add(radioDate);
		group.add(radioName);
		JRadioButton radionoConf = new JRadioButton("No confirmed");
		radionoConf.setBounds(100, 179, 109, 23);
		radionoConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radionoConfActionPerformed(e);		   
		}});
		contentPane.add(radionoConf);
		group.add(radionoConf);
		JButton btnsearch = new JButton("");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbuttonActionPerformed(e);
			}
		});
		btnsearch.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\search.png"));
		btnsearch.setBounds(215, 179, 89, 23);
		contentPane.add(btnsearch);
		
		JLabel lblListOfProjects = new JLabel("List of projects");
		lblListOfProjects.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblListOfProjects.setForeground(new Color(0, 0, 128));
		lblListOfProjects.setBounds(314, 44, 129, 14);
		contentPane.add(lblListOfProjects);
		
		
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetailsActionperfomed(e);
			}
		});
		btnDetail.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\detail.png"));
		btnDetail.setBounds(314, 225, 89, 23);
		contentPane.add(btnDetail);
		projects=ProjectDelegate.getList();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 65, 493, 149);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new Projcts_Model(projects));
		table.setBackground(Color.WHITE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 236, 843, 515);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		tabbedPane.addTab("Details", new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\detail.png"), panel, null);
		tabbedPane.setEnabledAt(0, false);
		panel.setLayout(null);
		
		
		JLabel label = new JLabel("");
		label.setBounds(361, 5, 0, 0);
		panel.add(label);
		
		JLabel lblNameProject = new JLabel("Name project :");
		lblNameProject.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNameProject.setForeground(new Color(0, 0, 128));
		lblNameProject.setBounds(10, 11, 87, 14);
		panel.add(lblNameProject);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblTitle.setBounds(10, 51, 46, 14);
		panel.add(lblTitle);
		
		JLabel lblShortPresentation = new JLabel("Short presentation :");
		lblShortPresentation.setForeground(new Color(0, 0, 128));
		lblShortPresentation.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblShortPresentation.setBounds(10, 91, 118, 14);
		panel.add(lblShortPresentation);
		
		JLabel lblDuration = new JLabel("Duration :");
		lblDuration.setForeground(new Color(0, 0, 128));
		lblDuration.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblDuration.setBounds(10, 135, 68, 14);
		panel.add(lblDuration);
		
		JLabel lblTurgetFunding = new JLabel("Turget funding :");
		lblTurgetFunding.setForeground(new Color(0, 0, 128));
		lblTurgetFunding.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblTurgetFunding.setBounds(10, 178, 87, 14);
		panel.add(lblTurgetFunding);
		
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setForeground(new Color(0, 0, 128));
		lblLocation.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblLocation.setBounds(10, 226, 68, 14);
		panel.add(lblLocation);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setForeground(new Color(0, 0, 128));
		lblCategory.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblCategory.setBounds(376, 11, 74, 14);
		panel.add(lblCategory);
		
		JLabel lblCreatorName = new JLabel("Creator name :");
		lblCreatorName.setForeground(new Color(0, 0, 128));
		lblCreatorName.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblCreatorName.setBounds(376, 51, 79, 14);
		panel.add(lblCreatorName);
		
		JLabel lblCreatorEmail = new JLabel("Creator email :");
		lblCreatorEmail.setForeground(new Color(0, 0, 128));
		lblCreatorEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblCreatorEmail.setBounds(376, 91, 87, 14);
		panel.add(lblCreatorEmail);
		
		lblnamep = new JLabel("xxx");
		lblnamep.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblnamep.setBounds(123, 11, 153, 14);
		lblnamep.setVisible(false);
		panel.add(lblnamep);
		
		lbltitle = new JLabel("xxx");
		lbltitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lbltitle.setBounds(125, 51, 151, 14);
		lbltitle.setVisible(false);
		panel.add(lbltitle);
		
		lblshortp = new JLabel("xxx");
		lblshortp.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblshortp.setBounds(123, 91, 153, 14);
		lblshortp.setVisible(false);
		panel.add(lblshortp);
		
		lblduration = new JLabel("xxx");
		lblduration.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblduration.setBounds(125, 135, 131, 14);
		lblduration.setVisible(false);
		panel.add(lblduration);
		
		lbltarget = new JLabel("xxx");
		lbltarget.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lbltarget.setBounds(125, 178, 151, 14);
		lbltarget.setVisible(false);
		panel.add(lbltarget);
		
		lbllocation = new JLabel("xxx");
		lbllocation.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lbllocation.setBounds(125, 226, 151, 14);
		lbllocation.setVisible(false);
		panel.add(lbllocation);
		
		lblcat = new JLabel("xxx");
		lblcat.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblcat.setBounds(512, 11, 160, 14);
		lblcat.setVisible(false);
		panel.add(lblcat);
		
		lblnamec = new JLabel("xxx");
		lblnamec.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblnamec.setBounds(512, 51, 179, 14);
		lblnamec.setVisible(false);
		panel.add(lblnamec);
		
		lblcemail = new JLabel("xxx");
		lblcemail.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblcemail.setBounds(512, 91, 201, 14);
		lblcemail.setVisible(false);
		panel.add(lblcemail);
		
	    btnConfirmed = new JButton("Confirmed");
		btnConfirmed.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\confirmed.png"));
		btnConfirmed.setEnabled(false);
		btnConfirmed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnconfirmedactionperfomed(e);
			}
		});
		btnConfirmed.setBounds(349, 367, 118, 23);
		panel.add(btnConfirmed);
		
		btnDenied = new JButton("Denied");
		btnDenied.setEnabled(false);
		btnDenied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeniedactionperformed(e);
			}
		});
		btnDenied.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\refuser.png"));
		btnDenied.setBounds(570, 367, 120, 23);
		panel.add(btnDenied);
		
		lblCauseOfDenied = new JLabel("Cause of denied :");
		lblCauseOfDenied.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblCauseOfDenied.setForeground(new Color(0, 0, 128));
		lblCauseOfDenied.setBounds(377, 135, 100, 14);		
		panel.add(lblCauseOfDenied);
		
		editorcause = new JEditorPane();
		editorcause.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		editorcause.setBounds(376, 160, 439, 179);
		
		panel.add(editorcause);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Stastic", new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\statistique.png"), panel_1, null);
		panel_1.setLayout(null);				
		 DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-01-01", "2016-01-31") , "projects" , "Jan" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-02-01", "2016-02-28") , "projects" , "Fab" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-03-01", "2016-03-31") , "projects" , "Mar" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-04-01", "2016-04-30") , "projects" , "Apr" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-05-01", "2016-05-31") , "projects" , "May" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-06-01", "2016-06-31") , "projects" , "Jui" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-07-01", "2016-07-30") , "projects" , "Jul" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-08-01", "2016-08-31") , "projects" , "Aug" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-09-01", "2016-09-30") , "projects" , "Sep" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-10-01", "2016-10-31") , "projects" , "Oct" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-11-01", "2016-11-30") , "projects" , "Nov" );
	     line_chart_dataset.addValue( ProjectDelegate.getNumberProjects("2016-12-01", "2016-12-31") , "projects" , "Dec" );
	     JFreeChart lineChartObject = ChartFactory.createLineChart(
		 "","",
		 "",
		 line_chart_dataset,PlotOrientation.VERTICAL,
		  true,true,false);
		 int width = 640;
	      int height = 480;
		  File lineChart = new File( "LineChart.jpeg" ); 
		  ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
		
		   ChartPanel cPanel = new ChartPanel(lineChartObject);
		   cPanel.setBounds(103, 0, 680, 420);
		   panel_1.add(cPanel);
		tabbedPane.setEnabledAt(1, true);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\profile.png"));
		label_1.setBounds(10, 27, 119, 140);
		contentPane.add(label_1);
		
		
	}

	protected void btnconfirmedactionperfomed(ActionEvent e) {
		Project p=projects.get(index);
		if(p.isIs_confirmed()==1)
		{
		JOptionPane.showMessageDialog(this, "this project are confirmed", "ERROR", 
	    JOptionPane.INFORMATION_MESSAGE, 
	    new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\erreur.png"));	
		}
		else
		{
		p.setIs_confirmed(1);
		int answer = JOptionPane.showConfirmDialog(this,
		"Are you sure to confirm this project");
	    if (answer == JOptionPane.YES_OPTION) {
		ProjectDelegate.confirm(p);
		JOptionPane.showMessageDialog(this, "this project is now confirmed", "ERROR", 
	    JOptionPane.INFORMATION_MESSAGE, 
	    new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\confirmed.png"));	
	   }}
		
	}

	protected void btnDeniedactionperformed(ActionEvent e)  {
		 
		
		int answer = JOptionPane.showConfirmDialog(this,
		"Are you sure to delete this project");
	    if (answer == JOptionPane.YES_OPTION) {
	     Sendmail sm=new Sendmail(lblcemail.getText(), editorcause.getText());
	     try {
			sm.send();
			JOptionPane.showMessageDialog(this, "Your mail are sended with succeful", "ERROR", 
	    	JOptionPane.INFORMATION_MESSAGE, 
		    new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\gmail.png"));
			ProjectDelegate.remove(projects.get(index));
			projects.remove(projects.get(index));
			table.setModel(new Projcts_Model(projects));
			
	     } catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 ProjectDelegate.remove(projects.get(index));
	    } else if (answer == JOptionPane.NO_OPTION) {
	      
	    	
	    }
		  
		   
		
	}

	protected void btnDetailsActionperfomed(ActionEvent e) {
		Project p=null ;	
	    index=new Integer(table.getSelectedRow());
		
		if(index==-1)
		{
			JOptionPane.showMessageDialog(this, "Please select an project", "ERROR", 
			JOptionPane.INFORMATION_MESSAGE, 
			new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\erreur.png"));
		}
		else
		{
	    btnConfirmed.setEnabled(true);
	    btnDenied.setEnabled(true);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setEnabledAt(1, true);
		p=projects.get(index);
		lblnamep.setVisible(true);
		lbltitle.setVisible(true);
		lblduration.setVisible(true);
		lbltarget.setVisible(true);
		lblshortp.setVisible(true);
		lbllocation.setVisible(true);
		lblcat.setVisible(true);
		lblnamec.setVisible(true);
		lblcemail.setVisible(true);
		lblnamep.setText(p.getName());
		lbltitle.setText(p.getTitle());
		lblshortp.setText(p.getShort_presentation());
		lblduration.setText(String.valueOf(p.getDuration())+" days");
		lbltarget.setText(String.valueOf(p.getTurget_funding()+" DNT"));
		lbllocation.setText(p.getLocation());
		lblcat.setText(p.getCategory().getName_category());
		lblnamec.setText(p.getCreator().getFirstname()+" "+p.getCreator().getLastname());
		lblcemail.setText(p.getCreator().getEmail());}
		
		
		
	}

	protected void radionoConfActionPerformed(ActionEvent e) {
		choix=2;
		
	}

	protected void searchbuttonActionPerformed(ActionEvent e) {
		
		if(choix==1)
		{
		String category=categories.get(comboBox.getSelectedIndex()).getName_category();
		projects=new ArrayList<>();
		projects=ProjectDelegate.getListByCategory(category);
		if(projects.size()==0)
		{
			JOptionPane.showMessageDialog(this, "No project matched this category", "ERROR", 
			JOptionPane.INFORMATION_MESSAGE, 
			new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\erreur.png"));
		}
		table.setModel(new Projcts_Model(projects));
		}
		if(choix==2)
		{				
		table.setModel(new Projcts_Model( ProjectDelegate.getListprojectsnomconfirmed(0)));
		}
		
	}

	protected void catbuttonActionPerformed(ActionEvent e) {
	        choix=1;
		    categories=CategoryDelegate.getListCategory();
		    for(Category c :categories)
			{
			comboBox.addItem(c.getName_category()); 
			}
	
	}
}
