package sendmail;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendMail {
	public static String send_mail(String path, String email) {
	   String filename = path;
	   String reply;
	   String to = email;

     
      String from = "";
      final String username = "";
      final String password = "";
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      
      Session session = Session.getInstance(props,
    	      new javax.mail.Authenticator() {
    	         protected PasswordAuthentication getPasswordAuthentication() {
    	        	 return new PasswordAuthentication(username, password);
    	         }
    	      });

      try {
    	  // Create a default MimeMessage object.
          Message message = new MimeMessage(session);

          // Set From: header field of the header.
          message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
          message.setRecipients(Message.RecipientType.TO,
             InternetAddress.parse(to));

          // Set Subject: header field
          message.setSubject("Employee Details Fetched From the Database.");

          // Create the message part
          BodyPart messageBodyPart = new MimeBodyPart();

          // Now set the actual message
          messageBodyPart.setText("Your Sincerely - Navinder Kumar Singh\nAdvanced Java Batch.");

          // Create a multipar message
          Multipart multipart = new MimeMultipart();

          // Set text message part
          multipart.addBodyPart(messageBodyPart);

          // Part two is attachment
          messageBodyPart = new MimeBodyPart();
          DataSource source = new FileDataSource(filename);
          messageBodyPart.setDataHandler(new DataHandler(source));
          messageBodyPart.setFileName(filename);
          multipart.addBodyPart(messageBodyPart);

          // Send the complete message parts
          message.setContent(multipart);

          // Send message
          Transport.send(message);

      	return "Attachment Sent Succesfully.";

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
}
}