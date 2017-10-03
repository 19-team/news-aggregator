package com.hackathon.nineteen.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a feed category
 */
@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {

    private static final int START_SEQ = 1;

    @Id
    @SequenceGenerator(name = "glob_seq", sequenceName = "glob_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_seq")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true, updatable = false)
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private List<FeedItem> items;

}
