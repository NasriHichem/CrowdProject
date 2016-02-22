package project.client.Presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.mail.MessagingException;
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
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.transaction.Transactional.TxType;

import project.client.locators.ClaimDelegate;
import project.client.mails.Sendmail;
import project.client.models.Claim_Model;
import projects.serveur.entites.Claim;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

public class GuiGestionReclamation extends JFrame {

	private JPanel contentPane;
	private JTable table_reclamations;
	private ArrayList<Claim>claims=new ArrayList<>();
	JLabel lbl_caliming,lbl_cause,lbl_objet ;
	Integer index;
	private JTextField textField_txtclaiming;

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
    claims=ClaimDelegate.getListclaim_non_confirm();
    table_reclamations.setModel(new Claim_Model(claims));
    	
	
		
	}
	public GuiGestionReclamation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 510);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmAccount = new JMenuItem("Account");
		menuBar.add(mntmAccount);
		
		JMenuItem mntmMessages = new JMenuItem("Messages");
		menuBar.add(mntmMessages);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListOfReclamtions = new JLabel("List of Reclamtions:");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.setIcon(new ImageIcon("C:\\Users\\khayri\\git\\CrowdProject\\src\\main\\resources\\Pictures\\detail.png"));
		
		JButton btnStatistique = new JButton("Statistique");
		btnStatistique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GuiStatClaimmoderator().setVisible(true);
			
			}
		});
		
		JButton btnRecherche = new JButton("Search");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt_claiming=textField_txtclaiming.getText();
				claims = new ArrayList<>();
				claims = ClaimDelegate.getclaimByclaiming(txt_claiming);
				table_reclamations.setModel(new Claim_Model(claims));
				
			}
		});
		
		textField_txtclaiming = new JTextField();
		textField_txtclaiming.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnSearchByDate = new JButton("Search by date");
		btnSearchByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Date d=dateChooser.getDateEditor().getDate();
				SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
				
				RowFilter filter=RowFilter.regexFilter(sm.format(d),0);
				 TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new Claim_Model(claims));
				    sorter.setRowFilter(filter);
				    table_reclamations.setRowSorter(sorter);
;
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblListOfReclamtions)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDetail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(btnStatistique, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearchByDate, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnRecherche, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_txtclaiming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(516, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSearchByDate)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnDetail)
							.addGap(18)
							.addComponent(btnStatistique))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblListOfReclamtions)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRecherche)
								.addComponent(textField_txtclaiming, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(38)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
		);
		
		table_reclamations = new JTable();
		scrollPane.setViewportView(table_reclamations);
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
				btn_confirm.setBounds(428, 22, 89, 23);
		panel.add(btn_confirm);
		
		JButton btn_denied = new JButton("denied");
		btn_denied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int answer = JOptionPane.showConfirmDialog(rootPane,
						"Are you sure to delete this claim");
				if(answer==JOptionPane.YES_OPTION){
					Claim c=null;
					Integer index=new Integer(table_reclamations.getSelectedRow());
					Sendmail sm= new Sendmail(claims.get(index).getClaiming().getEmail(), "aloooooooo");
					try {
						sm.send();
						
						ClaimDelegate.removeClaim(claims.get(index));
						initialisation();
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btn_denied.setBounds(428, 64, 89, 23);
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
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Claim c=null;
				Integer index=new Integer(table_reclamations.getSelectedRow());
			    c=claims.get(index);
				c.setState_claim(1);
				ClaimDelegate.UpdateClaim(c);
				JOptionPane.showMessageDialog(rootPane, "Claim is confirmed");
				
			}
		});

		
		contentPane.setLayout(gl_contentPane);
		initialisation();	}
}
