package com.polarbear.sep292;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polarbear.sep292.book.Book;
import com.polarbear.sep292.dog.Dog;


@Controller
public class HomeController {
	//			역 흐름 제어    의존성주입(외부파일에 만들고 java에 불러서 사용하는 것을 DI라고 한다.)
	//Spring : JAVA에서 IoC로 DI해주는 Framework
	//		객체를 .java에서 만들기
	//		객체를 외부파일(.xml)에 만들기 -> .java에서 불러서 사용하게 끔
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//원래는 이렇게 객체를 만들었다면...
//		Dog d = new Dog("개", 3);
//		System.out.println(d.getName());
//		System.out.println(d.getAge());
		
		//sep292beans.xml 불러오기 -> xml파일에 등록해놓은 객체를 만들어서 java코드에서 사용하면 된다.
		//AbstractApplication : Bean 객체를 생성하고 관리하는 기능
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext("sep292beans.xml");
		
		//aac가 없어질 때 등록해놓은 객체들을 다 없애라
		aac.registerShutdownHook();
		
		// id가 d인 강아지 객체를 불러오기
		Dog d = aac.getBean("d", Dog.class);// xml 객체를 불러오기
		System.out.println(d);
		
		//DI (Dependency Injection -의존성 주입)
		//		xml에서 객체를 만들고, 속성값 넣고
		//		java에서 가져다 쓰는 
		Dog d2 = aac.getBean("d2",Dog.class);
		System.out.println(d2.getName());
		System.out.println(d2.getAge());
		System.out.println("============================");
		
		Dog d3 = aac.getBean("d3",Dog.class);
		System.out.println(d3.getName());
		System.out.println(d3.getAge());
		System.out.println("============================");
		
		//책 객체를 만들어서 이름 - 가격 출력
		
		Book b1 = aac.getBean("b1",Book.class);
		Book b2 = aac.getBean("b2",Book.class);
		
		System.out.println(b1);
		System.out.println(b1.getPrice());
		System.out.println(b1.getName());
		System.out.println("============================");
		System.out.println(b2);
		System.out.println(b2.getName());
		System.out.println(b2.getPrice());
		System.out.println("============================");
		//aac 업애기
		aac.close();
		
		return "home";
	}
	
}
