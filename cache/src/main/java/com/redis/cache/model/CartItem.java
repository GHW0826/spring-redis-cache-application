package com.redis.cache.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartItem {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
}
