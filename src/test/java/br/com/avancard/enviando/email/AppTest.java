package br.com.avancard.enviando.email;



import br.com.avancard.eviando.email.ObjetoEnviaEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    @org.junit.Test
   public void testeEmail() throws Exception {

       ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("mcemersonaraujo@gmail.com, alexanvictor@gmail.com", "Teste JDEV", "Assunto do email teste", "Corpo do email teste");
        enviaEmail.enviarEmail();
   }
}

