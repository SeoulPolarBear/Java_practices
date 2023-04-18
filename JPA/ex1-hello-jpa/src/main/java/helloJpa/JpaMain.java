package helloJpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        //주의점
        //엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유를 해야 한다.
        //엔티티 매니저는 쓰레드간에 공유X (사용하고 버려야 한다.)
        //JPA의 모든 데이터 변경은 트랜잭션 안에서 실행

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션을 받아서 수행
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{
//--------------Insert------------------------------------------
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//--------------Update------------------------------------------
            // table class,primary key
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());
//            findMember.setName("HelloJPA");

            // persist를 할 필요가 없다 . 이유 : 바뀐 부분이 있으면 자동으로 JPA에서 Update를 처리해 준다.
//            em.persist(findMember);

// ------------------------Query----------------------------
//          JPA 입장에서는 Table을 기준으로 쿼리를 짜지 않고 멤버객체를 기준으로 쿼리를 짠다
            //이를 해결하는 것이 JPQL
//            List<Member> result= em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)//5번부터
//                    .setMaxResults(8)//8개 가지고 와주세요
//                    .getResultList();//즉 Oracle에서의 RowNum을 그대로 사용한다고 생각하면 된다. 방언에 맞게 처리해준다.
//
//            for (Member member: result) {
//                System.out.println("member = " + member.getName());
//            }


//--------------영속성 컨텍스트------------------------------------------
// 비영속
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
            // 영속
//            em.persist(member);
            // 준영속 : 컨테스트에 넣은 것을 다시 지운다. commit 전에
            //em.detach(member);

            // 실제 Query를 날릴 때 실행 즉, 이로써 하느의 Trancation이 실행 되었다.
            //tx.commit();

//--------------엔티티 등록 트랜잭션을 지원하는 쓰기 지연-----------------------------------------

    //장점은 이를 통해서 JDBC Batch를 할 수 있다. 즉, 버퍼링을 할 수 있다. Batch를 만들어서 통신 비용을 절약할 수 있다.
    Member member1 = new Member(150L,"A");
    Member member2 = new Member(160L,"B");

    em.persist(member1);
    em.persist(member2);
    // 이렇게 flush를 사용하면 commit을 통해서 Query가 날라가기 전에 즉시 Query가 DB로 날라간다.
    // 1차 캐시에 있는 정보들은 지워지지 않고 쓰기 지연SQL 저장소에 있는 Query에 있는 것들 혹은 변경 된 사항들만 반영이 된다.
    em.flush();

//--------------엔티티 준영속 -----------------------------------------

            //장점은 이를 통해서 JDBC Batch를 할 수 있다. 즉, 버퍼링을 할 수 있다. Batch를 만들어서 통신 비용을 절약할 수 있다.
            Member member= em.find(Member.class, 150L);
            
            //entity 해제
//            em.detach(member);
            // 영속성 초기화
//            em.clear();
            //영속성 닫기
//            em.close();
            // 이렇게 flush를 사용하면 commit을 통해서 Query가 날라가기 전에 즉시 Query가 DB로 날라간다.
            // 1차 캐시에 있는 정보들은 지워지지 않고 쓰기 지연SQL 저장소에 있는 Query에 있는 것들 혹은 변경 된 사항들만 반영이 된다.
            em.flush();

    System.out.println("==============================");
            // 트랜잭션을 정상적으로 수행
            tx.commit();
        }catch (Exception e){
            //롤백
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
