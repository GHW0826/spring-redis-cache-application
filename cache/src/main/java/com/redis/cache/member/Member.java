package com.redis.cache.member;

import com.redis.cache.model.Cart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
}
