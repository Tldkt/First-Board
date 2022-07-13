package com.study.board;

import com.study.board.controller.Boardcontroller;
import com.study.board.entity.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//스프링부트 테스트와 Junit 사이의 연결자 역할, 내장 실행자 외에 SpringRunner라는 실행자를 실행시킴
@WebMvcTest(controllers = Boardcontroller.class)
//Web에 집중할 수 있는 어노테이션, 선언 시 컨트롤러, 컨트롤러어드바이스 사용가능 but service component, repository 사용불가

public class BoardControllerTest {
    @Autowired//bean을 주입받음
    private MockMvc mvc;//웹 API 테스트 시 사용, HTTP,Get, Post API테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))//MockMvc를 통해 /hello 주소로 HTTP GET요청
                .andExpect(status().isOk())//체이닝, 검증기능 이어서 진행, 상태가 ok인가?
                .andExpect(content().string(hello));//resultMatchers선택했음, 응답 본문의 내용 검증함
    }

}
