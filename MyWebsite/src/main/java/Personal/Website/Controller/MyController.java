package Personal.Website.Controller;


import Personal.Website.email.EmailConfig;
import Personal.Website.email.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;


@Controller
public class MyController implements WebMvcConfigurer {

    private EmailConfig emailConfig;

    public MyController(EmailConfig emailConfig){
        this.emailConfig = emailConfig;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    //    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult){
    @PostMapping("/Contact")
//    public String sendFeedback(@Valid Feedback feedbackForm, Model model, BindingResult bindingResult){
    public String sendFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult bindingResult){

//        model.addAttribute("feedbackForm", feedbackForm);


        if(bindingResult.hasErrors()){
//            throw new ValidationException("Feedback not valid");
            return "Contacts";
        }
//        else{
//
//            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//            mailSender.setHost(this.emailConfig.getHost());
//            mailSender.setPort(this.emailConfig.getPort());
//            mailSender.setUsername(this.emailConfig.getUsername());
//            mailSender.setPassword(this.emailConfig.getPassword());
//
//            //create new mail instance
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setFrom(feedback.getEmail());
//            mailMessage.setTo("febrian.francione@gmail.com");
//            mailMessage.setSubject("New feedback from " + feedback.getName());
//            mailMessage.setText(feedback.getFeedback());
//
//            //send mail
//            mailSender.send(mailMessage);
//            return "Home";
//        }
        return "result";
    }

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
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
//        model.addAttribute("feedbackForm", new Feedback());
        return "Contacts";
    }


}
