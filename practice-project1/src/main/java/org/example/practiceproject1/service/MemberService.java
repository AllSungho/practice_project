package org.example.practiceproject1.service;

import lombok.RequiredArgsConstructor;
import org.example.practiceproject1.dto.MemberRequestDto;
import org.example.practiceproject1.dto.MemberResponseDto;
import org.example.practiceproject1.entity.Member;
import org.example.practiceproject1.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto saveMember(MemberRequestDto memberRequestDto) {
        Member member = this.memberRepository.save(new Member(memberRequestDto.getName()));
        return new MemberResponseDto(member.getId(), member.getName());
    }
    @Transactional(readOnly = true)
    public List<MemberResponseDto> findMembers() {
        List<Member> members = this.memberRepository.findAll();
        return members.stream().map(member -> new MemberResponseDto(member.getId(), member.getName())).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public MemberResponseDto findMember(Long memberId) {
        Member member = this.memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );
        return new MemberResponseDto(member.getId(), member.getName());
    }
    @Transactional
    public MemberResponseDto updateMember(Long memberId, MemberRequestDto memberRequestDto) {
        Member member = this.memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );
        member.changeName(memberRequestDto.getName());
        return new MemberResponseDto(memberId, member.getName());
    }
    @Transactional
    public void deleteMember(Long memberId) {
        this.memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );
        this.memberRepository.deleteById(memberId);
    }
}
