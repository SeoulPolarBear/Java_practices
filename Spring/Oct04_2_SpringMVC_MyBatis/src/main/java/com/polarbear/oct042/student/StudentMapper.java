package com.polarbear.oct042.student;

import java.util.List;

public interface StudentMapper {
	// method 리턴 타입
	// insert / update / delete -> 영향을 받은 데이터의 수 => int로 return;
	//
	//select
	//		결과가 하나 나온다 : resultType객체 (Student)
	//		결과가 여러개 나온다 : List<resultType객체> (List<Student>)
	
	//	메소드명 - mapper.xml의 id와 맞추기!
	//	파라미터 - mapper.xml의 parameterType과 맞추기!
	//	노란 밑줄 있는 것은 Mybatis와 interface끼리 연결이 안되어 있다는 뜻이다.
	
	public abstract int reqStudent(Student s);
	public abstract List<Student> getAllStudent();
	
}
