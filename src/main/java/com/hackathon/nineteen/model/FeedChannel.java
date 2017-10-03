package com.hackathon.nineteen.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a feed channel.
 */
@Entity
@Table(name = "feed_channels")
@Data
public class FeedChannel implements Serializable {

    private static final int START_SEQ = 1;

    @Id
    @SequenceGenerator(name = "glob_seq", sequenceName = "glob_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_seq")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "channel_link", nullable = false, updatable = false)
    private String channelLink;

    @Column(name = "channel_title", nullable = false, updatable = false)
    private String channelTitle;


}
