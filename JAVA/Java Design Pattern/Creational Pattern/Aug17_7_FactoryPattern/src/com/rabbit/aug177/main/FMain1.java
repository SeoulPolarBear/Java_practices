package com.rabbit.aug177.main;

//학원에서 학생을 상담한 후 해당 커리큘럼 대기자로 등록하려고 함 => 클래스 2개 필요(학원, 학생)
//학생의 정보는 이름 / 나이 !
//등록 순서대로 번호를 부여하고 싶은데 어떻게 해야할까요?

//객체가 필요없을 경우 : static 메소드 기반
//객체가 있기는 해야함
//      하나만 필요할 때 : Singleton 패턴
//      여러개 필요할 때 :
//                      대량생산, 자동화된 : Factory 패턴
//                      나머지 : 여태껏 우리가 했던 걸로!


import com.rabbit.aug177.register.Academy;
import com.rabbit.aug177.register.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class FMain1 {
    public static void main(String[] args) {
        Academy academy = new Academy();
        while(true) {
            academy.consult(new Scanner(System.in).next(),
                    new Scanner(System.in).nextInt()).printInfo();

            if(academy.getStudentCount() == 9){
                break;
            }
        }

    }
}
