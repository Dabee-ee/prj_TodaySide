package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;

@Getter
@Setter
public class WriteForm {

    private Long writeId;

    private String title;

    private String content;

    private Date regDate;

    private File attach;

}
