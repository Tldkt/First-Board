package com.study.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Boardcontroller {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return"게시판을 만들어보자";
    }
}
