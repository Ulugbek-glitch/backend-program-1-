    package me.ugk.springdeveloper.service;

    import lombok.RequiredArgsConstructor;
    import me.ugk.springdeveloper.entity.Member;
    import me.ugk.springdeveloper.repository.MemberRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    // 이 클래스가 서비스 계층의 스프링 빈임을 나타냄 -> 컴포넌트 스캔 대상이 되어 스프링 컨테이너에 등록됨
    @Service

    // Lombok 어노테이션:final 필드(및 @NonNull)만 파라미터로 받는 성생자를 자동 생성 -> 생성자 주입에 사용됨
    @RequiredArgsConstructor
    public class MemberService {

        // 의존성 주입 어노테이션. 다만 여기서는 불필요함
        @Autowired

        // MemberRepository 타입의 의존성. final이므로 @RequiredArgsConstructor가 만든 생성자를 통해 주입됨
        private final MemberRepository memberRepository;
        // 전달받은 Member 엔티티를 DB에 저장, 저장된 엔티티를 반환하는 메서드
        public Member saveMember(Member member) {

            // JpaRepository가 제공하는 save() 호출, PK가 없으면 persist(INSERT), 있으면 merge (UPDATE) 수행
            return memberRepository.save(member);
        }

        // 멤버 테이블에 있는 모든 레코드들을 읽어서 반환
        public List<Member> getAllMembers() {
          //  JpaRepository의 findAll() 호출 -> SELECT * FROM member 결과를 List<Member>로 반환
            return memberRepository.findAll();
        }
    }