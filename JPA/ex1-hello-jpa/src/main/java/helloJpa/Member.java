package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MBR")
public class Member {

    //--------------------필기용이기 떄문에 오류가 발생할 수 있습니다.----------------------------------------------
    @Id
    private Long id;

    // Column의 이름을 내가 지정하고 싶을 떄 사용한다.  default : 객체의 필드 이름
    //name : 필드와 매핑할 테이블 컬럼 이름
    //insertable, updatable : 등록, 변경 가능 여부 default : TRUE
    //nullable : null값의 허용 여부 설정
    //unique : @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제약조건을 걸 때 사용한다.
    //columnDefinition : 데이터베이스 컬럼 정보를 직접 줄 수 있다. default : 필드의 자바 타입과 방언 정보를 사용
    //length : 문자 길이 제약조건, String 타입에만 사용한다. default : 255

    //precision, scale(DDL) : BigDecimal 타입에서 사용한다(BigInteger도 사용할 수 있다).
    //precision은 소수점을 포함한 전체 자 릿수를, scale은 소수의 자릿수
    //다. 참고로 double, ﬂoat 타입에는 적용되지 않는다. 아주 큰 숫자나
    //정 밀한 소수를 다루어야 할 때만 사용한다.
    @Column(
            unique = true,
            length = 10,
            name = "name",
            updatable = false,
            insertable = false,
            nullable = false,
            columnDefinition = "varchar(100) default 'EMPTY'"
    )
    private String name;

    @Column(precision=19,
            scale=2 )
    //Integer로 만들면 각 DB에 맞게 알아서 매칭해준다.
    private Integer age;

    //EUM 타입을 사용하고 싶을 떄 사용된다.
    //즉, 여러개 중 하나를 사용하게 되는데
    // Ordinal은 순서를 데이터 베이스에 저장한다.
    // STRING은 이름을 데이터베이스에 저장. (저장할 String은 getter, setter를 사용하서 정한다.)
    // ★★★★★★따라서 반드시 ORDIAL을 사용하면 안 된다.★★★★★★
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // JAVA 8로 넘어오면서 아래 두가지를 이용하면 사용할 때 Temporal annotation 생략이 가능하다.
    private LocalDate test1;
    private LocalDateTime test2;

    // DB에는 날짜(Date)와 시간(TIME)이 따로 구분이 되어있다.
    // 하지만 JAVA에서는 날짜와 시간을 한번에 같이 사용하므로 DB에서 날짜 시간을 같이 쓰는
    // TIMESTAMP로 설정을 해서 넣어줘야 한다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //varchar를 넘는 큰 컨텐츠를 넣고 싶으면 Lob 사용
    //데이터베이스 BLOB, CLOB 타입과 매핑
    // @Lob에는 지정할 수 있는 속성이 없다.
    //매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑
    //      CLOB : String, char[], java.sql.CLOB
    //      BLOB : byte[], java.sql.BLOB
    @Lob
    private String description;

    //임시로 메모리에만 사용하겠다는 뜻이다. 즉, DB에 반영이 되지 않는다.
    //필드 매핑 X, 데이터베이스 저장 X, 조회 X
    //주로 메모리상에서만 임시로 어떤 값을 보관하고 싶을 때 사용
    @Transient
    private int temp;

    // 동적으로 할당 되기 때문에 반드시 다음과 같이 기본 생성자가 필요하다.
    public Member() {
    }
}
