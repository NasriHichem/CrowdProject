package project.client.mails;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sendmail {
	

    Message msg = null ;
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    final String username = "ambotious.project@gmail.com";
	final String password = "azerty123456789smartdev";
	private String receiver ;
	Session session;
	public Sendmail(String receiver) {
	 this.receiver=receiver;
	 Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
	 props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	 props.setProperty("mail.smtp.socketFactory.fallback", "false");
	 props.setProperty("mail.smtp.port", "465");
	 props.setProperty("mail.smtp.socketFactory.port", "465");
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.debug", "true");
	 props.put("mail.store.protocol", "pop3");
	 props.put("mail.transport.protocol", "smtp");		  
	 session = Session.getDefaultInstance(props, 
	  new Authenticator(){
	  protected PasswordAuthentication getPasswordAuthentication() {
	  return new PasswordAuthentication(username, password);
	  }});
	}
    
    public void send() throws AddressException, MessagingException
    {
    	msg = new MimeMessage(session);
    	MimeBodyPart mbp1 = new MimeBodyPart();
        try {
			mbp1.setText("Response!");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MimeBodyPart mbp2 = new MimeBodyPart();	
        mbp2.setText("Sorry your project are deinded");    
        MimeMultipart mp = new MimeMultipart();
        try {
			mp.addBodyPart(mbp1);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			mp.addBodyPart(mbp2);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        msg.setRecipients(Message.RecipientType.TO, 
        InternetAddress.parse(this.receiver,false));
        msg.setContent(mp);
        Transport.send(msg);
       
    
    }

}
