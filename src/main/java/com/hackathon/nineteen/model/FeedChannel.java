package com.hackathon.nineteen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a feed channel.
 */
@Entity(name = "FeedChannel")
@Table(name = "feed_channels")
public class FeedChannel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "chanel_link", nullable = false, updatable = false)
    private String channelLink;

    @Column(name = "channel_title", nullable = false, updatable = false)
    private String channelTitle;

    public FeedChannel() {
    }

    public FeedChannel(String channelLink, String channelTitle) {
        this.channelLink = channelLink;
        this.channelTitle = channelTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelLink() {
        return channelLink;
    }

    public void setChannelLink(String channelLink) {
        this.channelLink = channelLink;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedChannel that = (FeedChannel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(channelLink, that.channelLink) &&
                Objects.equals(channelTitle, that.channelTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, channelLink, channelTitle);
    }

    @Override
    public String toString() {
        return "FeedChannel{" +
                "channelLink='" + channelLink + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                '}';
    }
}
