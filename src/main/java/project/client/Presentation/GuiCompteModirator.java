package project.client.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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

import project.client.locators.UserDelegate;
import project.client.mails.Sendmail;
import project.client.models.Projcts_Model;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import projects.serveur.entites.Category;
import projects.serveur.entites.Project;
import javax.swing.JTabbedPane;

public class GuiCompteModirator extends JFrame {
	

	private JPanel contentPane;
	private JTable table_projects;
	private JTable table;
	private JComboBox<String> comboBox;
	private ArrayList<Category>categories=new ArrayList<>();
	private ArrayList<Project>projects=new ArrayList<>();
	JLabel lblnamep,lbltitle,lblshortp,lblduration,lbltarget,lbllocation,lblcat,lblnamec,lblcemail;
	JPanel panel ;
	JTabbedPane tabbedPane;
	JButton btnConfirmed,btnDenied ;
	int choix ;
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
		radioCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    catbuttonActionPerformed(e);		   
		}});
		radioCat.setBounds(26, 65, 109, 23);
		contentPane.add(radioCat);
		
		JRadioButton radioDate = new JRadioButton("Date");
		radioDate.setBounds(26, 91, 109, 23);
		contentPane.add(radioDate);
		
		JRadioButton radioName = new JRadioButton("Name");
		radioName.setBounds(26, 117, 109, 23);
		contentPane.add(radioName);
		
	    comboBox = new JComboBox<String>();
		comboBox.setBounds(36, 146, 70, 20);
		contentPane.add(comboBox);
		
		JRadioButton radionoConf = new JRadioButton("No confirmed");
		radionoConf.setBounds(26, 179, 109, 23);
		radionoConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radionoConfActionPerformed(e);		   
		}});
		contentPane.add(radionoConf);
		
		JButton btnsearch = new JButton("");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbuttonActionPerformed(e);
			}
		});
		btnsearch.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\search.png"));
		btnsearch.setBounds(131, 145, 89, 23);
		contentPane.add(btnsearch);
		
		JLabel lblListOfProjects = new JLabel("List of projects");
		lblListOfProjects.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblListOfProjects.setForeground(new Color(0, 0, 128));
		lblListOfProjects.setBounds(389, 44, 129, 14);
		contentPane.add(lblListOfProjects);
		
		
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetailsActionperfomed(e);
			}
		});
		btnDetail.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\detail.png"));
		btnDetail.setBounds(327, 202, 89, 23);
		contentPane.add(btnDetail);
		
		table = new JTable();
		table.setBackground(SystemColor.menu);
		table.setBounds(314, 65, 250, 109);
		projects=UserDelegate.getList();
		table.setModel(new Projcts_Model(projects));

		contentPane.add(table);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 287, 728, 298);
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
			}
		});
		btnConfirmed.setBounds(423, 222, 118, 23);
		panel.add(btnConfirmed);
		
		btnDenied = new JButton("Denied");
		btnDenied.setEnabled(false);
		btnDenied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnDeniedactionperformed(e);
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDenied.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\refuser.png"));
		btnDenied.setBounds(571, 222, 120, 23);
		panel.add(btnDenied);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Stastic", new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\statistique.png"), panel_1, null);
		tabbedPane.setEnabledAt(1, false);
		
		
	}

	protected void btnDeniedactionperformed(ActionEvent e) throws AddressException, MessagingException {
		   Sendmail sm=new Sendmail(lblcemail.getText());
		   sm.send();
		
	}

	protected void btnDetailsActionperfomed(ActionEvent e) {
		Project p=null ;	
		Integer index=new Integer(table.getSelectedRow());
		
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
		lblduration.setText(String.valueOf(p.getDuration())+" jours");
		lbltarget.setText(String.valueOf(p.getTurget_funding()+" Tdt"));
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
		projects=UserDelegate.getListByCategory(category);		
		table.setModel(new Projcts_Model(projects));
		}
		if(choix==2)
		{				
		table.setModel(new Projcts_Model( UserDelegate.getListprojectsnomconfirmed(0)));
		}
		
	}

	protected void catbuttonActionPerformed(ActionEvent e) {
	        choix=1;
		    categories=UserDelegate.getListCategory();
		    for(Category c :categories)
			{
			comboBox.addItem(c.getName_category()); 
			}
	
	}
}
