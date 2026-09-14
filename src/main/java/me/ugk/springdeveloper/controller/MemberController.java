package me.ugk.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.ugk.springdeveloper.entity.Member;
import me.ugk.springdeveloper.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}