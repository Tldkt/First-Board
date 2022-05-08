package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write")
    public String boardWriteform() {

        return "boardwrite";

    }

    @PostMapping("/board/writepro")

    public String boardwritepro(Board board){

        boardService.write(board);
        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList());
        return"boardlist";
    }//name 있는 거로 선택하는지 몰랐고, 아직 뭐가 객체고 뭐가 메소든지 좀 헷갈린다...  글고 객체 뒤에 () 안붙여서 틀렸다
}


