package br.com.avancard.enviando.email;



import br.com.avancard.eviando.email.ObjetoEnviaEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    @org.junit.Test
   public void testeEmail() throws Exception {

        StringBuilder stringBuilderTextoEmail = new StringBuilder();
        stringBuilderTextoEmail.append("Olá,<br><br>");
        stringBuilderTextoEmail.append("<h1 style='color: #6A5ACD'>Você está recebendo o acesso ao curso java.</h1><br>");
        stringBuilderTextoEmail.append("<h2 style='color: #6A5ACD' >Para ter acesso clique no botão abaixo</h2><br>");

        stringBuilderTextoEmail.append("<b>Login: </b>victor@setup.com<br>");
        stringBuilderTextoEmail.append("<b>Senha: </b>sdsdsdk44<br><br>");
        stringBuilderTextoEmail.append("<a target=\"_blank\" href =\"globo.com\" style=\"color:#2525a7; padding: 14px 25px; text-aligne: center; text-decoration: none; display: inline-block; border-radius: 30px; font-size:20px;font-family:courier; border: 3px solid green; background-color: #99DA39\">Acessar Portal do Aluno</a>");
       ObjetoEnviaEmail enviaEmail =
               new ObjetoEnviaEmail("alexanvictor@gmail.com", "Teste JDEV", "Assunto do email teste", stringBuilderTextoEmail.toString().toString());
        enviaEmail.enviarEmail(true);
   }
}

