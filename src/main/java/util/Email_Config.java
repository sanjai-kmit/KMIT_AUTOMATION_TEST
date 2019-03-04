package util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * @author Sanjai on 03/04/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Email_Config {

    public static MimeMessage message;
    public static Session session;

    org.apache.log4j.Logger Log = Logger.getLogger(Email_Config.class.getName());

    public void send_email(String site, String url){

        DOMConfigurator.configure("src\\log4j.xml");

        // Create object of Property file
        Properties prop = new Properties();

        prop.put("mail.smtp.starttls.enable", "true");

        // this will set host of server- you can change based on your requirement
        prop.put("mail.smtp.host", "smtp.gmail.com");

        prop.put("mail.smtp.user", "sannila4369@gmail.com");
        prop.put("mail.smtp.password", "sannila@1");

        // set the port of SMTP server
        prop.put("mail.smtp.port", "587");

        // set the authentication to true
        prop.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(prop, null);

        try {
            // Create object of MimeMessage class
            message = new MimeMessage(session);

            // set the form address
            message.setFrom(new InternetAddress("sannila4369@gmail.com"));

            // Set the recipient address
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(send_to));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(select_emailId()));

            // Add subject line
            message.setSubject("KMIT Automation Test Result");

            // Add the file attachment
            String fileName = "KMIT E-comm Test Result";
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Hi "+ System.getProperty("user.name") + ",\nTest Completed to the given\nSite: " + site.toUpperCase() + "\nwith URL: " + url + "\nKindly check in \"KMIT_AUTOMATION_TEST/src/failure_ScreenShots \" folder created in your project, for any error screenshots.\nFind the attachment for more LOG details.\n");

            MimeBodyPart attachment = new MimeBodyPart();
            DataSource source = new FileDataSource(new File("src\\logfile.log").getAbsolutePath());
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName("Test_Result.txt");

            multipart.addBodyPart(textBodyPart);
            multipart.addBodyPart(attachment);

            message.setContent(multipart);

//****
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "sannila4369@gmail.com", "sannila@1");
            transport.sendMessage(message, message.getAllRecipients());
            Log.info("Email message sent with attached log file: Sucessfully");
        } catch (MessagingException m){
            Log.error("Email messag sent with attached log file: Failed with Exception: \n" + m.getMessage());
        }
    }


    private String select_emailId(){

        String system_user = System.getProperty("user.name");
        String user_email = null;

        switch (system_user){
            case "Sanjai":
                user_email = "sanjaim@kmitsolutions.com";
        }

        return user_email;
    }

}
