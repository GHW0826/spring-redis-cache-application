package com.redis.cache.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Item {
    @Id @GeneratedValue
    private Long id;

    private Integer price;

    @OneToOne(mappedBy = "item")
    private CartItem cartItem;
}
