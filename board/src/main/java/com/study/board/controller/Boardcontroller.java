package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Controller

public class Boardcontroller {//컨트롤러 클래스 생성
    @Autowired
    private BoardService boardService;//보드서비스의 인스턴스 선언?
    @GetMapping("/board/write")
    public String boardWriteform() {//보드라이트 url로 가면 해당 html 보여주기

        return "boardwrite";

    }

    @PostMapping("/board/writepro")

    public String boardwritepro(Board board){//보드 클래스의 데이터를 가져와라?

        boardService.write(board);//(객체)보드서비스의 write 메서드 실행해
        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){//보드리스트 url로 가면 Model을 통해서 보드서비스의 보드리스트를 받아올 건데 그 이름을 "리스트"
        model.addAttribute("list",boardService.boardList());
        return "boardlist";//html 보드리스트 보여줘
    }//아직 뭐가 객체고 뭐가 메소든지 좀 헷갈린다...(220507)

    @GetMapping("/board/view")//보드뷰 url 들어가면 html보여줘 localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id){
        model.addAttribute("board",boardService.boardView(id));
        return "boardview";//보드뷰는 모델을 통해서 id를 보드라는 이름으로 담아오기
    }
    @GetMapping("/board/delete")
    public String boardDelete(Model model, Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
    @GetMapping("/board/modify/{id}")//해당 id를 받아와서 넘어가라
    public String boardModify(@PathVariable("id") Integer id){
        //pathvariable은 url 역슬래시 뒤에 들어간 id를 받아와서 integer id에 넢어준다는 의미
        return "boardmodify";
        //boardmodify 페이지 보여줘
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board){
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setTitle(board.setContent());
        return "redirect:/board/list";
    }


}


