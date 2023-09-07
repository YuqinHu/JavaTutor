package com.itheima.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    String hi(String name) {
        return "Hello " + name;
    }

    @RequestMapping("/bye")
    @ResponseBody
    String bye() {
        return "Bye Bye";
    }
}
