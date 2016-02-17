package project.client.Presentation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.websocket.Decoder.Text;

public class Jrecover extends JFrame {

	private JPanel contentPane;
	private JTextField textMail;
	private String username = "ambitiousprojectpdev@gmail.com";
	private String password = "info4b1pdev";

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
					Jrecover frame = new Jrecover();
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
	public Jrecover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\msg.png"));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.smtp.host","smtp.gmail.com");
				props.put("mail.smtp.port","587");
				Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
				}
				});
				try {
				// Etape 2 : Création de l'objet Message
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("ambitiousprojectpdev@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(textMail.getText()));
					message.setSubject("Password email");
					message.setText("Your password is : root ");
					// Etape 3 : Envoyer le message
					Transport.send(message);
					System.out.println("Message_envoye");
					JOptionPane.showMessageDialog(null, "Mail sent ! Consult your mail");
					;
				} catch (MessagingException ex) {
					JOptionPane.showMessageDialog(null, "Invalid mail");
				throw new RuntimeException(ex);
				}
			}
		});
		btnSend.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSend.setBounds(640, 245, 141, 40);
		contentPane.add(btnSend);
		
		JButton btnCancel = new JButton("Return");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				authentification au = new authentification();
				au.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnCancel.setBounds(480, 245, 141, 40);
		contentPane.add(btnCancel);
		
		textMail = new JTextField();
		textMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textMail.setBounds(502, 152, 259, 40);
		contentPane.add(textMail);
		//Text.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your mail here to recieve your password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(486, 97, 322, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hichem\\workspace\\project.client\\src\\main\\resources\\Pictures\\ambitousproject.jpg"));
		lblNewLabel.setBounds(5, 5, 1099, 567);
		contentPane.add(lblNewLabel);
		
	}
}
