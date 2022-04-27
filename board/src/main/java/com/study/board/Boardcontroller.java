package com.study.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Controller

public class Boardcontroller {

    @GetMapping("/board/write")
    public String boardWriteform() {

        return "boardwrite";

    }
    @PostMapping("/board/writepro")
    public String boardwritepro(String title, String content){

        System.out.println("제목:" + title);
        System.out.println("내용:" + content);

        return "";
    }
}


