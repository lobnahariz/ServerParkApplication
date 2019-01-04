package com.park.server.demo.controller;

import com.park.server.demo.model.AppRole;
import com.park.server.demo.model.AppUser;
import com.park.server.demo.repository.RoleRepository;
import com.park.server.demo.repository.UserRepository;
import com.park.server.demo.web.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.validation.ValidationException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@RestController
@RequestMapping("/register")
public class AccountRestController {

     @Autowired
    private UserRepository userRepository;

     @Autowired
     private RoleRepository roleRepository;
@Value("${gmail.username}")
private String username;
    @Value("${gmail.password}")
private String password;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping
      public AppUser register(@RequestBody RegisterForm userForm,   BindingResult bindingResult)
      {

          if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("you must confirm your password");
          AppUser user= userRepository.findByUsername(userForm.getUsername());

          if(user!=null) throw new RuntimeException("this user already exist");
          AppUser  appUser = new AppUser();
          appUser.setTestlogin(userForm.getUsername());
          appUser.setEmail(userForm.getEmail());
          appUser.setValid("non");
          String hashPW=bCryptPasswordEncoder.encode(userForm.getPassword());
          appUser.setPassword(hashPW);

          userRepository.save(appUser);
        addRoleToUSer(appUser.getUsername(),"USER");

        try {
              this.sendmail("helo",appUser.getEmail());
          } catch (MessagingException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }

          if(bindingResult.hasErrors()){
              throw new ValidationException("Feedback is not valid");
          }

           return appUser;
      }


    public void addRoleToUSer(String username, String roleName) {
        AppRole role=roleRepository.findByRoleName(roleName);
        AppUser user=userRepository.findByUsername(username);
        user.getRoles().add(role);
        userRepository.saveAndFlush(user);
    }
    private void sendmail(String emailmessage,String email) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Inscription");
        msg.setContent("Merci pour votre inscription! Notre admin est en cours de la traiter", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("helo", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
     //   MimeBodyPart attachPart = new MimeBodyPart();

      //  attachPart.attachFile("C:\\talk2amareswaran-downloads\\mysql2.png");

      //  multipart.addBodyPart(attachPart);
     //   msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);

    }

}
