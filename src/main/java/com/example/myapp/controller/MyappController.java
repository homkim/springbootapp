package com.example.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyappController {
    
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){

        model.addAttribute("username", "홍길동");
        return "greetings";  // templates/greetings.mustache를 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){

        model.addAttribute("nicname", "배고픈사자");
        return "goodbye";  // templates/greetings.mustache를 브라우저로 전송
    }


}
