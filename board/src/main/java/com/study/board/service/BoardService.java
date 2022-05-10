package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {//보드서비스 클래스 생성
    @Autowired
    private BoardRepository boardRepository; //인터페이스 보드리파지터리 사용할 거야

    public void write(Board board) {
        boardRepository.save(board);
    }
    public List<Board> boardList(){
        return boardRepository.findAll();
    }
    public Board boardView(int id){
        return boardRepository.findById(id).get();
    }

}
