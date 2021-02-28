package Personal.Website.Controller;


import Personal.Website.email.EmailConfig;
import Personal.Website.email.Feedback;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;


@Controller
public class MyController {

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("theDate", new java.util.Date());

        return "Home";
    }
    @GetMapping("/CurriculumVitae")
    public String showCV(Model model){
        return "CurriculumVitae";
    }

    @GetMapping("/Projects")
    public String showProjects(Model model){
        return "Projects";
    }

    @GetMapping("/About")
    public String showAbout(Model model){
        return "About";
    }

    @GetMapping("/Contact")
    public String showContact(Model model){
        return "Contact";
    }


}
