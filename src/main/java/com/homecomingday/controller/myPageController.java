package com.homecomingday.controller;

import com.homecomingday.controller.response.ArticleResponseDto;
import com.homecomingday.controller.response.MyPageDetailResponseDto;
import com.homecomingday.controller.response.MyPageResponseDto;
import com.homecomingday.domain.Member;
import com.homecomingday.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class myPageController {

    private MyPageService myPageService;

    //유저 정보 조회
    @GetMapping("/myPage")
    public MyPageResponseDto readMyPage( @AuthenticationPrincipal Member member){
        return myPageService.readMyPage(member);
    }

    // 내가 쓴 게시글 조회
    @GetMapping("/myPage/myArticle")
    public MyPageDetailResponseDto readDetailMyPage(@AuthenticationPrincipal Member member){
        return myPageService.readDetailMyPage(member);
    }


}
