package com.ccoupang.domain.product;

import com.ccoupang.domain.category.Category;
import com.ccoupang.domain.orderproduct.OrderProduct;
import com.ccoupang.domain.review.Review;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int price;

  private String description;

  private String manufacturer;

  private String image;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "product")
  private List<OrderProduct> orderProducts = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<Review> reviews = new ArrayList<>();
}
