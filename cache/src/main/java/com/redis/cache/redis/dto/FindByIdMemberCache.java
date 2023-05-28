package com.redis.cache.redis.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindByIdMemberCache implements Serializable {
    private Long id;
    private String name;
}
