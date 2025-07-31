package org.example.practiceproject3.service;

import lombok.RequiredArgsConstructor;
import org.example.practiceproject3.dto.MemoRequestDto;
import org.example.practiceproject3.dto.MemoResponseDto;
import org.example.practiceproject3.entity.Memo;
import org.example.practiceproject3.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    // 메모 저장
    @Transactional
    public MemoResponseDto createMemo(MemoRequestDto memoRequestDto) {
        Memo memo = this.memoRepository.save(new Memo(memoRequestDto.getTitle(), memoRequestDto.getContent()));
        return new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent());
    }
    // 전체 메모 조회
    @Transactional(readOnly = true)
    public List<MemoResponseDto> findMemos() {
        List<Memo> memos = this.memoRepository.findAll();
        return memos.stream().map(map -> new MemoResponseDto(map.getId(), map.getTitle(), map.getContent())).toList();
    }
    // 아이디로 메모 조회
    @Transactional(readOnly = true)
    public MemoResponseDto findMemoById(Long id) {
        Memo memo = this.memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모 없습니다.")
        );
        return new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent());
    }
    // 메모 제목 변경
    @Transactional
    public MemoResponseDto updateMemoTitle(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = this.memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모 없습니다.")
        );
        memo.changeTitle(memoRequestDto.getTitle());
        return new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent());
    }
    // 메모 내용 변경
    @Transactional
    public MemoResponseDto updateMemoContent(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = this.memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모 없습니다.")
        );
        memo.changeContent(memoRequestDto.getContent());
        return new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent());
    }
    // 메모 제거
    @Transactional
    public void deleteMemoById(Long id) {
        Memo memo = this.memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모 없습니다.")
        );
        this.memoRepository.delete(memo);
    }
}
