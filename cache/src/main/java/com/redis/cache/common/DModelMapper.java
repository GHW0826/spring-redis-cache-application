package com.redis.cache.common;

import com.redis.cache.member.Member;
import com.redis.cache.member.dto.FindByIdMemberResponse;
import com.redis.cache.member.dto.SaveMemberRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DModelMapper {

    private ModelMapper modelMapper;

    @Autowired
    public DModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, E> E DtoToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <D, E> D EntityToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <S, T> T DtoToDto(S dto, Class<T> targetDto) {
        return modelMapper.map(dto, targetDto);
    }
}
