package com.study.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Board {
    @Id
    @GeneratedValue()
    private Integer id;
    private String  title;
    private String content;


}
