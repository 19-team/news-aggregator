package com.hackathon.nineteen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Павло on 03.10.2017.
 */
@Entity(name = "FeedItem")
@Table(name = "feed_channels")
public class FeedChannel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "chanel_link", nullable = false, updatable = false)
    private String chanelLink;

    @Column(name = "channel_title", nullable = false, updatable = false)
    private String chanelTitle;

    public FeedChannel() {
    }

    public FeedChannel(String chanelLink, String chanelTitle) {
        this.chanelLink = chanelLink;
        this.chanelTitle = chanelTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChanelLink() {
        return chanelLink;
    }

    public void setChanelLink(String chanelLink) {
        this.chanelLink = chanelLink;
    }

    public String getChanelTitle() {
        return chanelTitle;
    }

    public void setChanelTitle(String chanelTitle) {
        this.chanelTitle = chanelTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedChannel that = (FeedChannel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(chanelLink, that.chanelLink) &&
                Objects.equals(chanelTitle, that.chanelTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chanelLink, chanelTitle);
    }

    @Override
    public String toString() {
        return "FeedChannel{" +
                "chanelLink='" + chanelLink + '\'' +
                ", chanelTitle='" + chanelTitle + '\'' +
                '}';
    }
}
