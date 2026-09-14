package me.ugk.springdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.ugk.springdeveloper.entity.Member;
import me.ugk.springdeveloper.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    // 멤버 테이블에 있는 모든 레코드들을 읽어서 반환
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}