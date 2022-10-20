/**???
 *      ???
 *Stack
 *      변수를 만들때마다 아래에서 부터 차국차곡 쌓임
 *      프로그램이 종료하면 알아서 다 정리
 *Heap
 *      컴퓨터가 적당하다고 판단한 위칭에 만든다.
 *      자동정리 X(핸드폰 메모리 정리하는 느낌으로... 정리해야...)
 * Garbage Collection : Heap영역 자동정리 시스템(*** 면접)
 * //언제? - 그 번지에 더이상 접근할 방법이 없어지면 발동!
 */





public class OMain5 {
    public static void main(String[] args) {
        //마스크
    Mask m1 = new Mask();
        // 이름
    m1.maskName = "KF94";
        // 구매처
        m1.buyPlace = "양재 온누리 약국";
        //가격
        m1.price = 1000;
        // 정보 출력
        m1.MaskInfo();

        Mask m2 = m1;//Mask m1은 m2라는 별명이 하나 더 생김
        m1 = null;
        System.out.println(m1); // 아무 번지도 안가리킴 ***(null)
        System.out.println(m2);// 얘는 아직 살아있다.
        m2 = null;
        //============마스크의 정보가 사라지는 시점. 이때 Garbage Collection이 발동된다.
        System.out.println(m2);//이 때도 번지가 존재 x null로 바뀜
        m2.MaskInfo(); //m2의 정보를 출력하는게 불가능 하게 된다. garbage collection 때문에 
        //발동이 안되면 다 끝나서야 날라감
    }
}
//프로그램이 종료되면 Stack영역이 날라가고
//=> Heap영역에 접근을 못하게 되니 Garbage Collection 발동!