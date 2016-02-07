package project.client.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class GuiCompteModirator extends JFrame {
	

	private JPanel contentPane;
	private JTable table_projects;

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
	 */
	public GuiCompteModirator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 624);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmAccount = new JMenuItem("Account");
		mntmAccount.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\user.png"));
		mntmAccount.setBounds(0, 0, 129, 22);
		contentPane.add(mntmAccount);
		
		JMenuItem mntmMessages = new JMenuItem("Messages");
		mntmMessages.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\msg.png"));
		mntmMessages.setBounds(126, 0, 129, 22);
		contentPane.add(mntmMessages);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\aide.png"));
		mntmHelp.setBounds(228, 0, 129, 22);
		contentPane.add(mntmHelp);
		
		JLabel lblSearchProject = new JLabel("Search project by :");
		lblSearchProject.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblSearchProject.setForeground(new Color(0, 0, 128));
		lblSearchProject.setBounds(26, 44, 122, 14);
		contentPane.add(lblSearchProject);
		
		JRadioButton radioCat = new JRadioButton("Category");
		radioCat.setBounds(26, 65, 109, 23);
		contentPane.add(radioCat);
		
		JRadioButton radioDate = new JRadioButton("Date");
		radioDate.setBounds(26, 91, 109, 23);
		contentPane.add(radioDate);
		
		JRadioButton radioName = new JRadioButton("Name");
		radioName.setBounds(26, 117, 109, 23);
		contentPane.add(radioName);
		
	    JComboBox comboBox = new JComboBox();
		comboBox.setBounds(36, 146, 70, 20);
		contentPane.add(comboBox);
		
		JRadioButton radionoConf = new JRadioButton("No confirmed");
		radionoConf.setBounds(26, 179, 109, 23);
		contentPane.add(radionoConf);
		
		JButton btnsearch = new JButton("");
		btnsearch.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\search.png"));
		btnsearch.setBounds(131, 145, 89, 23);
		contentPane.add(btnsearch);
		
		JLabel lblListOfProjects = new JLabel("List of projects");
		lblListOfProjects.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblListOfProjects.setForeground(new Color(0, 0, 128));
		lblListOfProjects.setBounds(389, 44, 129, 14);
		contentPane.add(lblListOfProjects);
		
		table_projects = new JTable();
		table_projects.setBounds(663, 192, -286, -96);
		contentPane.add(table_projects);
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\detail.png"));
		btnDetail.setBounds(327, 202, 89, 23);
		contentPane.add(btnDetail);
		
		JMenuItem mntmDetails = new JMenuItem("Details");
		mntmDetails.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\detail.png"));
		mntmDetails.setBounds(0, 284, 129, 22);
		contentPane.add(mntmDetails);
		
		JMenuItem mntmStatistical = new JMenuItem("Statistical");
		mntmStatistical.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\statistique.png"));
		mntmStatistical.setBounds(136, 284, 129, 22);
		contentPane.add(mntmStatistical);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 317, 728, 268);
		contentPane.add(panel);
		
		
	}
}
