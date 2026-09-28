package me.ugk.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.ugk.springdeveloper.entity.Member;
import me.ugk.springdeveloper.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 모든 회원 조회
    // GET http://localhost:8080/api/members
    @GetMapping("/api/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    // 회원정보 등록
    // POST http://localhost:8080/member
    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        // 비즈니스 로직 호출
        // return ResponseEntity.ok(memberService.saveMember(member));
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(member));

    }
}