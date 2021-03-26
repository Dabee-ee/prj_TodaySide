package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthInfo {

    //회원 정보 세션 유지

        private String id;
        private String name;
        private int grade;
    }

