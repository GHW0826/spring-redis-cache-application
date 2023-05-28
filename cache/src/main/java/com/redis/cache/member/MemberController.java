package com.redis.cache.member;

import com.redis.cache.common.DModelMapper;
import com.redis.cache.member.dto.FindByIdMemberResponse;
import com.redis.cache.member.dto.SaveMemberRequest;
import com.redis.cache.member.dto.SaveMemberResponse;
import com.redis.cache.redis.dto.FindByIdMemberCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    private DModelMapper modelMapper;
    private MemberService memberService;

    @Autowired
    public MemberController(DModelMapper modelMapper, MemberService memberService) {
        this.modelMapper = modelMapper;
        this.memberService = memberService;
    }

    @PostMapping
    public SaveMemberResponse save(@RequestBody SaveMemberRequest saveMemberRequest){
        SaveMemberResponse response = memberService.save(saveMemberRequest);
        log.info("save to DB : " + saveMemberRequest);
        return response;
    }

    @GetMapping("/{id}")
    public FindByIdMemberResponse getMember(@PathVariable Long id){
        FindByIdMemberCache byId = memberService.findById(id);
        log.info("Member fetching from DB : "  + byId);
        return modelMapper.DtoToDto(byId, FindByIdMemberResponse.class);
    }
}
