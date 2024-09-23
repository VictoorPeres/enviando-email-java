package br.com.avancard.enviando.email;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    private String username = "alxdak47@gmail.com";
    private String password = "pzct wukk cdqj calg";

    @org.junit.Test
    public void testeEmail(){
    try{
        /* Olhe as configurações SMTP do seu email */
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");/*Autorização*/
        properties.put("mail.smtp.starttls", "true");/*Autenticação*/
        properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
        properties.put("mail.smtp.port", "465");/*Porta do servidor*/
        properties.put("mail.smtp.socketFactory.port", "465");/*Expecifica a porta a ser conectada pelo socket*/
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Address[] toUser = InternetAddress.parse("alexanvictor@gmail.com, mcemersonaraujo@gmail.com");

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));/*Quem esta enviando*/
        message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
        message.setSubject("Cacheada");
        message.setText("MA cacheada");

        Transport.send(message);
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
