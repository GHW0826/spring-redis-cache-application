package com.redis.cache.member;

import com.redis.cache.common.DModelMapper;
import com.redis.cache.member.dto.SaveMemberRequest;
import com.redis.cache.member.dto.SaveMemberResponse;
import com.redis.cache.redis.dto.FindByIdMemberCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private DModelMapper modelMapper;

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(DModelMapper modelMapper, MemberRepository memberRepository) {
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
    }

    public SaveMemberResponse save(SaveMemberRequest saveMemberRequest) {
        Member member = modelMapper.DtoToEntity(saveMemberRequest, Member.class);
        Member save = memberRepository.save(member);
        return modelMapper.EntityToDto(save, SaveMemberResponse.class);
    }

    @Cacheable(key = "#id", cacheNames = "member")
    public FindByIdMemberCache findById(Long id) {
        Member findMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " 멤버는 존재하지 않습니다."));
        return modelMapper.DtoToDto(findMember, FindByIdMemberCache.class);
    }
}
