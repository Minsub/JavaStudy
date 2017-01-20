package com.minsub.java.commons.email;

import org.apache.commons.mail.HtmlEmail;

import java.net.URL;

public class MailSenderHtml {
    public static void main(String[] args) {
        try {
            // Create the email message
            HtmlEmail email = new HtmlEmail();
            email.setHostName("mailing.hmm21.com");
            email.addTo("minsub.ji@hmm21.com", "MS Ji");
            email.setFrom("test@hmm21.com", "mail-server");
            email.setSubject("Test email with inline image");

            // embed the image and get the content id
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = email.embed(url, "Apache logo");

            // set the html message
            email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");

            // send the email
            email.send();
            System.out.println("complete to send email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
