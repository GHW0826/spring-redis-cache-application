package com.redis.cache.model;

import com.redis.cache.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Cart {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "cart")
    private Member owner;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();
}
