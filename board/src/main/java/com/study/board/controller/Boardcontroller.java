package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
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
}


