package task.epam.race.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.util.mail.SessionCreator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ResourceBundle;

public class MailService {
    private static Logger logger = LogManager.getLogger(MailService.class);

    private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private ResourceBundle resourceBundle;

    public MailService(String sendToEmail, String mailSubject, String mailText,
                             ResourceBundle resourceBundle) {
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.resourceBundle = resourceBundle;
    }

    void init() {
        Session mailSession = new SessionCreator(resourceBundle).createSession();
        mailSession.setDebug(true);

        message = new MimeMessage(mailSession);
        try {
            message.setSubject(mailSubject);
            message.setContent(mailText, "text/html");
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(sendToEmail));
        } catch (AddressException e) {
            logger.error("Invalid e-mail address", e);
        } catch (MessagingException e) {
            logger.error("Mail generation error", e);
        }
    }

    public void run() {
        init();
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Mail transfer error", e);
        }
    }
}
