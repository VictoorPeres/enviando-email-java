package br.com.avancard.eviando.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ObjetoEnviaEmail {

    private String username = "alxdak47@gmail.com";
    private String password = "pzct wukk cdqj calg";
    private String listaDestinatarios = "";
    private String nomeRemetente = "";
    private String assuntoEmail = "";
    private String corpoEmail = "";

    public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String corpoEmail) {
        this.listaDestinatarios = listaDestinatarios;
        this.nomeRemetente = nomeRemetente;
        this.assuntoEmail = assuntoEmail;
        this.corpoEmail = corpoEmail;
    }


    public void enviarEmail(boolean envioHtml) {
        try {
            /* Olhe as configurações SMTP do seu email */
            Properties properties = new Properties();
            properties.put("mail.smtp.ssl.trust", "*");
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

            Address[] toUser = InternetAddress.parse(listaDestinatarios);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username, this.nomeRemetente));/*Quem esta enviando*/
            message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
            message.setSubject(this.assuntoEmail);/*Assunto do email*/

            if(envioHtml) {
                message.setContent(this.corpoEmail, "text/html; charset=utf-8");
            }else {
                message.setText(this.corpoEmail);/*Corpo do email*/
            }
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
