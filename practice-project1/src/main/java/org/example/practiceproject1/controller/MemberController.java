package org.example.practiceproject1.controller;

import lombok.RequiredArgsConstructor;
import org.example.practiceproject1.dto.MemberResponseDto;
import org.example.practiceproject1.dto.MemberRequestDto;
import org.example.practiceproject1.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public MemberResponseDto saveMember(
            @RequestBody MemberRequestDto memberRequestDto
    ){
        return this.memberService.saveMember(memberRequestDto);
    }
    @GetMapping("/members")
    public List<MemberResponseDto> findMembers(){

        return this.memberService.findMembers();
    }
    @GetMapping("/members/{memberId}")
    public MemberResponseDto findMember(
            @PathVariable Long memberId
    ){
        return this.memberService.findMember(memberId);
    }
    @PutMapping("/members/{memberId}")
    public MemberResponseDto updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberRequestDto memberRequestDto
    ){
        return this.memberService.updateMember(memberId, memberRequestDto);
    }
    @DeleteMapping("/members/{memberId}")
    public void deleteMember(
            @PathVariable Long memberId
    ){
        this.memberService.deleteMember(memberId);
    }
}
