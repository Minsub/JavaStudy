package com.minsub.java.commons.email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import java.net.URL;

public class MailSenderAttachment {

    public static void main(String[] args) {
        try {
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("C:/image.jpg");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Picture of John");
            attachment.setName("flink.jpg");

            // Create the attachment with URL
            EmailAttachment attachment2 = new EmailAttachment();
            attachment2.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
            attachment2.setDisposition(EmailAttachment.ATTACHMENT);
            attachment2.setDescription("Apache logo");
            attachment2.setName("Apache-logo.gif");


            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("mailing.hmm21.com");
            email.addTo("minsub.ji@hmm21.com","minsub Ji");
            email.setFrom("test@hmm21.com", "test-mail-server");
            email.setSubject("test email with attachments");
            email.setMsg("Here is the picture you wanted");

            // add the attachment
            email.attach(attachment);
            email.attach(attachment2);

            // send the email
            email.send();
            System.out.println("complete to send email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
