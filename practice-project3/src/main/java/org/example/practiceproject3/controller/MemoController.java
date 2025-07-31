package org.example.practiceproject3.controller;

import lombok.RequiredArgsConstructor;
import org.example.practiceproject3.dto.MemoRequestDto;
import org.example.practiceproject3.dto.MemoResponseDto;
import org.example.practiceproject3.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/memos")
    public MemoResponseDto createMemo(
            @RequestBody MemoRequestDto memoRequestDto
    ){
        return this.memoService.createMemo(memoRequestDto);
    }
    @GetMapping("/memos")
    public List<MemoResponseDto> findMemos(){
        return this.memoService.findMemos();
    }
    @GetMapping("/memos/{memoId}")
    public MemoResponseDto findMemoById(
            @PathVariable Long memoId
    ){
        return this.memoService.findMemoById(memoId);
    }
    @PutMapping("/memos/{memoId}/titles")
    public MemoResponseDto updateMemoTitle(
            @PathVariable Long memoId,
            @RequestBody MemoRequestDto memoRequestDto
    ){
        return this.memoService.updateMemoTitle(memoId, memoRequestDto);
    }
    @PutMapping("/memos/{memoId}/contents")
    public MemoResponseDto updateMemoContent(
            @PathVariable Long memoId,
            @RequestBody MemoRequestDto memoRequestDto
    ){
        return  this.memoService.updateMemoContent(memoId, memoRequestDto);
    }
    @DeleteMapping("/memos/{memoId}")
    public void deleteMemo(
            @PathVariable Long memoId
    ){
        this.memoService.deleteMemoById(memoId);
    }
}
