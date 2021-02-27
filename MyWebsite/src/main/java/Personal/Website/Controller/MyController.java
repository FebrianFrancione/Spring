package Personal.Website.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
