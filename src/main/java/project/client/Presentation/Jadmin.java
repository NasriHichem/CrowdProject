package project.client.Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projects.serveur.entites.Adminstrator;
import projects.serveur.entites.Modirator;

public class Jadmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static Adminstrator administrator ;
	private static GuiCompteModirator gui;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jadmin frame = new Jadmin(administrator);					
					frame.setVisible(true);
					Thread.sleep(4000);
					if(administrator instanceof Modirator)
					{
						gui=new GuiCompteModirator();
						gui.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jadmin(Adminstrator administrator) {
		this.administrator=administrator;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\profile.png"));
		lblNewLabel_1.setBounds(568, 100, 146, 154);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblWelcome.setBounds(587, 297, 121, 21);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\ambitousproject.jpg"));
		lblNewLabel.setBounds(0, 0, 1125, 616);
		contentPane.add(lblNewLabel);
	}
}
