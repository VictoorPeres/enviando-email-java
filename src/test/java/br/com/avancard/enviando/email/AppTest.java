package br.com.avancard.enviando.email;

import java.util.Properties;

public class AppTest {

    @org.junit.Test
    public void testeEmail(){

        /* Olhe as configurações SMTP do seu email */
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");/*Autorização*/
        properties.put("mail.smtp.starttls", "true");/*Autenticação*/
        properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
        properties.put("mail.smtp.port", "465");/*Porta do servidor*/
        properties.put("mail.smtp.socketFactory.port", "465");/*Expecifica a porta a ser conectada pelo socket*/
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/
    }
}
