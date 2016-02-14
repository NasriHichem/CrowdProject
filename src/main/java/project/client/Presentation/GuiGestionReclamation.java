package project.client.Presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import project.client.locators.ClaimDelegate;
import project.client.models.Claim_Model;
import projects.serveur.entites.Claim;
import java.awt.SystemColor;

public class GuiGestionReclamation extends JFrame {

	private JPanel contentPane;
	private JTable table_reclamations;
	private ArrayList<Claim>claims=new ArrayList<>();
	JLabel lbl_caliming,lbl_cause,lbl_objet ;

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
					GuiGestionReclamation frame = new GuiGestionReclamation();
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
	public  void initialisation(){
    claims=new ArrayList<>();
    claims=ClaimDelegate.getListclaim();
	table_reclamations.setModel(new Claim_Model(claims));
		
	}
	public GuiGestionReclamation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 510);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmAccount = new JMenuItem("Account");
		menuBar.add(mntmAccount);
		
		JMenuItem mntmMessages = new JMenuItem("Messages");
		menuBar.add(mntmMessages);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Search reclamation par:");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Date");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Claiming");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Sujet");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblListOfReclamtions = new JLabel("List of Reclamtions:");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.setIcon(new ImageIcon("C:\\Users\\khayri\\git\\CrowdProject\\src\\main\\resources\\Pictures\\detail.png"));
		
		JButton btnStatistique = new JButton("Statistique");
		
		table_reclamations = new JTable();
		
		JButton btnRecherche = new JButton("Search");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnStatistique, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addGap(60)
					.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(112))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRecherche))
								.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblListOfReclamtions)
							.addGap(117))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(table_reclamations, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListOfReclamtions)
						.addComponent(lblNewLabel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_1)
							.addGap(3)
							.addComponent(rdbtnNewRadioButton_2)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRecherche)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table_reclamations, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStatistique)
						.addComponent(btnDetail))
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Caliming :");
		lblNewLabel_3.setBounds(10, 11, 66, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("cause :");
		lblNewLabel_1.setBounds(10, 44, 66, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("objet :");
		lblNewLabel_2.setBounds(10, 73, 66, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lbl_caliming = new JLabel("xxx");
		lbl_caliming.setBounds(100, 11, 138, 14);
		panel.add(lbl_caliming);
		
		JLabel lbl_cause = new JLabel("xxx");
		lbl_cause.setBounds(100, 44, 125, 14);
		panel.add(lbl_cause);
		
		JLabel lbl_objet = new JLabel("xxx");
		lbl_objet.setBounds(100, 73, 114, 14);
		panel.add(lbl_objet);
		
		JButton btn_confirm = new JButton("confirm");
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_confirm.setBounds(178, 98, 89, 23);
		panel.add(btn_confirm);
		
		JButton btn_denied = new JButton("denied");
		btn_denied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_denied.setBounds(303, 98, 89, 23);
		panel.add(btn_denied);
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Claim c=null;
				Integer index=new Integer(table_reclamations.getSelectedRow());
				if(index==-1)
				{
					JOptionPane.showMessageDialog(rootPane, "Please select an claim", "ERROR", 
							JOptionPane.INFORMATION_MESSAGE, 
							new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\erreur.png"));
				}
				else
				{
					
				c=claims.get(index);
				lbl_caliming.setText(c.getClaiming().getFirstname()+" "+c.getClaiming().getLastname());
				lbl_cause.setText(c.getCause());
				lbl_objet.setText(c.getObject());
				
				
				
			}}
		});
		
		contentPane.setLayout(gl_contentPane);
		initialisation();	}
}
