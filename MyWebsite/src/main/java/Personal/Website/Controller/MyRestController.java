package Personal.Website.Controller;

import Personal.Website.email.EmailConfig;
import Personal.Website.email.Feedback;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;


@RestController
@RequestMapping("/feedback")
public class MyRestController {
    private EmailConfig emailConfig;

    public MyRestController(EmailConfig emailConfig){
        this.emailConfig = emailConfig;
    }


    @PostMapping
    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback not valid");
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        //create new mail instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("febrian.francione@gmail.com");
        mailMessage.setSubject("New feedback from " + feedback.getName());
        mailMessage.setText(feedback.getFeedback());

        //send mail
        mailSender.send(mailMessage);
    }
}
