package pl.coderslab.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

        @GetMapping("/")
        public String home() { return "dashboard/dashboard"; }

        @GetMapping("/about")
        @ResponseBody
        public String about() { return "Here you can find some details for logged users"; }

}
