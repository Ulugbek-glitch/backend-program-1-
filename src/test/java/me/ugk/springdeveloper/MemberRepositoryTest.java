package me.ugk.springdeveloper;

import me.ugk.springdeveloper.entity.Member;
import me.ugk.springdeveloper.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @DisplayName("member 테이블에서 ID가 2인 레코드 가져오기")
    @Test
    public void getMemberById2() {
        Member member = memberRepository.findById(2L).get();

        assertThat(member.getName()).isEqualTo("B");
    }

    @Sql("/insert-members.sql")
    @DisplayName("member 테이블에서 name이 'B'인 레코드 가져오기")
    @Test
    public void getMemberByName() {
        Optional<Member> member = memberRepository.findByName("B");

        assertThat(member).isPresent();
        assertThat(member.get().getId()).isEqualTo(2L);
    }

    @DisplayName("하나의 멤버 객체를 DB에 저장하기")
    @Test
    public void saveMembers() {
        memberRepository.deleteAll();

        Member member = new Member("A");

        System.out.println("Before save: " + memberRepository.findAll());
        System.out.println("New member ID: " + member.getId());
        System.out.println("New member name: " + member.getName());

        Member savedMember = memberRepository.save(member);

        assertThat(savedMember.getId()).isNotNull();
        assertThat(savedMember.getName()).isEqualTo("A");
    }

    @DisplayName("3개의 member 객체를 DB에 저장하기")
    @Test
    public void saveMember() {

        List<Member> members = List.of(new Member("A1"), new Member("A2"), new Member("A3"));

        memberRepository.saveAll(members);

        assertThat(memberRepository.findAll().size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @DisplayName("id가 2인 레코드 삭제하기")
    @Test
    public void deleteMemberById() {

        memberRepository.deleteById(2L);

        Optional<Member> member = memberRepository.findById(2L);
        assertThat(member.isEmpty()).isTrue();

    }

    @Sql("/insert-members.sql")
    @DisplayName("모든 레코드 삭제하기")
    @Test

    public void deleteAllMembers() {

        memberRepository.deleteAll();

        List<Member> members = memberRepository.findAll();
        assertThat(members).isEmpty();
        // assertThat(members.size()).isEqualTo(0);
    }

    @Sql("/insert-members.sql")
    @DisplayName("변경감지 기능을 이용해 id가 2인 레코드의 name을 '홍길동'으로 변경하기")
    @Test

    public void updateMember() {

        Member member = memberRepository.findById(2L).get();

        member.setName("홍길동");

        member = memberRepository.findById(2L).get();
        assertThat(member.getName()).isEqualTo("홍길동");
    }
}