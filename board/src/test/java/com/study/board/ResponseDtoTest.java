package com.study.board;

import com.study.board.dto.ResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseDtoTest {
    @Test
    public  void   롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        ResponseDto dto = new ResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertThat:검증하고 싶은 대상을 메소드 인자로 받음
        //isEqualTo: assertj의 동등 비교 메서드 ,assertThat값과 isEqualTo 값 비교해 같을때만 성공
    }
}
//Junit의 기본 assertThat 대신 assertj의 assertThat 사용한 이유
//CoreMatchers와 달리 추가 라이브러리가 필요하지 않음, 자동완성 확실하게 지원
