public class WhatIsValue {
    //알고 싶은 자료형의 기본값을 멤버변수로 만들어서
    //정수
    byte byteField;
    short shortField;
    int intField;
    long longField;
    //
    boolean booleanField;
    char charField;

    float floatField;
    double doubleField;
    //참조형
    String stringField;
    int[] arrayField;
    //출력하는 메소드를 생성

    public void printInfo() {
        System.out.println("byte : "+ byteField);
        System.out.println("short : "+ shortField);
        System.out.println("int : "+ intField);
        System.out.println("long : "+ longField);
        System.out.println("boolean : "+ booleanField);
        System.out.println("char : "+ charField);//기본 값이 띄어쓰기 이다.
                                                // (유니코드 : \u0000)
        System.out.println("float : "+ floatField);
        System.out.println("double : "+ doubleField);
        System.out.println("string : "+ stringField);
        System.out.println("array : "+ arrayField);

    /*    byte : 0
        short : 0
        int : 0
        long : 0
        boolean : false
        char :
        float : 0.0
        double : 0.0
        string : null
        array : null*/
    }
}
