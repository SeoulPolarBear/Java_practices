package com.rabbit.aug251.main;

//Map 계열 (Python : dict / Object-C : NSDictionary)
//      가변사이즈
//      <key,Value>
//      key값도 지정해줘야 함
//      순서 개념 x
//      Hasarrayap, HashTable,...
import java.util.HashMap;
import java.util.Set;

public class MapMain {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        hm.put("아메리카노",4000);
        hm.put("녹차라떼", 5000);
        hm.put("레몬에이드", 6000);
        hm.put("녹차라떼", 7000);//'녹차라떼' key값이 같기 때문에
                                //제일 마지막에 저장된 Value값으로 '수정'됨
        System.out.println(hm.get("녹차라떼"));//key값 통해 value 사용
        Set<String> k = hm.keySet();// key 값 추출
        for (String string : k){
            System.out.println(string);// key 값만 추출 녹차라뗴 중복이므로 삭제
            System.out.println(hm.get(string));//value 값 추출
            System.out.println("===============================");

        }

    }
}
