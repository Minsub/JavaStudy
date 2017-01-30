package com.minsub.java.commons.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class MailSender {
    public static void main(String[] args) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("mailing.hmm21.com");
            //email.setSmtpPort(465);
            //email.setAuthenticator(new DefaultAuthenticator("username", "password"));
            //email.setSSLOnConnect(true);
            email.setFrom("test@hmm21.com");
            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("minsub.ji@hmm21.com");
            email.send();
            System.out.println("complete to send email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
