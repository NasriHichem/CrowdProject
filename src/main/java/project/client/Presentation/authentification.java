package project.client.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import project.client.locators.GestionAdminstratorDelegate;
import projects.serveur.entites.Adminstrator;
import projects.serveur.entites.Modirator;

public class authentification extends JFrame {

	private JPanel contentPane;
	private JTextField logina;
	private JTextField pwda;
	protected JTextComponent login;
	protected JTextComponent pwd;
	private int i=0;
	private int j=6;
	private int k=6;
	private JPasswordField pwdaa;

	/**
	 * Launch the application.
	 */
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
					authentification frame = new authentification();
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
	public authentification() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\USER\\Desktop\\crowdfunding1.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logina = new JTextField();
		logina.setBounds(584, 118, 187, 42);
		contentPane.add(logina);
		logina.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\confirmed.png"));
		btnConnect.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Adminstrator adminstrator = GestionAdminstratorDelegate.doAuthentificate(logina.getText(), pwdaa.getText());
		        if(adminstrator!=null){
		        
		        	System.out.println("OK ! ");
		        	JOptionPane.showMessageDialog(null, "Connection succeeded ! ");
		        	if(adminstrator instanceof Modirator)
					{
						GuiCompteModirator gui;
						try {
							gui = new GuiCompteModirator();
							gui.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
		        	dispose();
		        }
		        else{
		        	System.out.println("Erreur de connexion! ");
		        	i = i+1;
		        	k = j-i;
		        	JOptionPane.showMessageDialog(null, " invalid username or password ! WARNING : " + k + " connection attempt remains");
		        	
		        }
		        
			}
		});
		btnConnect.setBounds(680, 272, 141, 40);
		contentPane.add(btnConnect);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblLogin.setBounds(487, 117, 116, 42);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblPassword.setBounds(487, 170, 116, 40);
		contentPane.add(lblPassword);
		
		JButton btnStat = new JButton("Statistic");
		btnStat.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\statistique.png"));
		btnStat.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultPieDataset pieDataset = new DefaultPieDataset();
				pieDataset.setValue("attempts failed", i);
				pieDataset.setValue("attempts remaining", k);
				
				JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
				PiePlot p= (PiePlot) chart.getPlot();
				ChartFrame frame = new ChartFrame("Pie Chart", chart);
				frame.setVisible(true);
				frame.setSize(500,500);
			}
		});
		btnStat.setBounds(505, 272, 141, 40);
		contentPane.add(btnStat);
		
		JButton btnForgottenPassword = new JButton("Forgotten Password");
		btnForgottenPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Jrecover JR = new Jrecover();
	        	JR.setVisible(true);
			}
		});
		btnForgottenPassword.setBackground(Color.LIGHT_GRAY);
		btnForgottenPassword.setBounds(594, 219, 166, 23);
		contentPane.add(btnForgottenPassword);
		
		pwdaa = new JPasswordField();
		pwdaa.setBounds(584, 171, 187, 42);
		contentPane.add(pwdaa);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\ambitousproject.jpg"));
		lblNewLabel.setBounds(0, 0, 1125, 616);
		contentPane.add(lblNewLabel);
		
		pwda = new JTextField();
		pwda.setBounds(244, 270, 187, 42);
		contentPane.add(pwda);
		pwda.setColumns(10);
	}
}
