package com.hackathon.nineteen.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a feed item.
 */
@Entity
@Table(name = "feed_items")
@Data
public class FeedItem implements Serializable {

    private static final int START_SEQ = 1;

    @Id
    @SequenceGenerator(name = "glob_seq", sequenceName = "glob_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_seq")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "feed_title", nullable = false, updatable = false)
    private String feedTitle;

    @Column(name = "feed_link", nullable = false, updatable = false)
    private String feedUrl;

    @Column(name = "feed_description", nullable = false, updatable = false)
    private String feedDescription;

    @Column(name = "feed_publication_date", nullable = false, updatable = false)
    private Date feedPubDate;

    @Column(name = "feed_viewer_counts", nullable = false)
    private Integer feedViewerCount = 0;

    @ManyToMany
    @JoinTable(name = "items_categories", joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "feed_channel_id")
    private FeedChannel feedChannel;

}
