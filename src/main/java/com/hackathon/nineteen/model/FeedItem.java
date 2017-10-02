package com.hackathon.nineteen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Павло on 03.10.2017.
 */
@Entity(name = "FeedItem")
@Table(name = "feed_items")
public class FeedItem implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "feed_link", nullable = false, updatable = false)
    private String feedUrl;

    @Column(name = "feed_description", nullable = false, updatable = false)
    private String feedDescription;

    @Column(name = "feed_publication_date", nullable = false, updatable = false)
    private Date feedPubDate;

    @OneToMany
    private List<Category> categories;

    @Column(name = "feed_viewer_counts", nullable = false, updatable = false)
    private Integer feedViewerCount = 0;

    @OneToMany
    private FeedChannel feedChannel;

    public FeedItem() {
    }

    public FeedItem(String feedUrl, String feedDescription, Date feedPubDate, List<Category> categories, Integer feedViewerCount,
                    FeedChannel feedChannel) {
        this.feedUrl = feedUrl;
        this.feedDescription = feedDescription;
        this.feedPubDate = feedPubDate;
        this.categories = categories;
        this.feedViewerCount = feedViewerCount;
        this.feedChannel = feedChannel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getFeedDescription() {
        return feedDescription;
    }

    public void setFeedDescription(String feedDescription) {
        this.feedDescription = feedDescription;
    }

    public Date getFeedPubDate() {
        return feedPubDate;
    }

    public void setFeedPubDate(Date feedPubDate) {
        this.feedPubDate = feedPubDate;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getFeedViewerCount() {
        return feedViewerCount;
    }

    public void setFeedViewerCount(Integer feedViewerCount) {
        this.feedViewerCount = feedViewerCount;
    }

    public FeedChannel getFeedChannel() {
        return feedChannel;
    }

    public void setFeedChannel(FeedChannel feedChannel) {
        this.feedChannel = feedChannel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedItem feedItem = (FeedItem) o;
        return Objects.equals(id, feedItem.id) &&
                Objects.equals(feedUrl, feedItem.feedUrl) &&
                Objects.equals(feedDescription, feedItem.feedDescription) &&
                Objects.equals(feedPubDate, feedItem.feedPubDate) &&
                Objects.equals(categories, feedItem.categories) &&
                Objects.equals(feedViewerCount, feedItem.feedViewerCount) &&
                Objects.equals(feedChannel, feedItem.feedChannel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedUrl, feedDescription, feedPubDate, categories, feedViewerCount, feedChannel);
    }

    @Override
    public String toString() {
        return "FeedItem{" +
                "feedUrl='" + feedUrl + '\'' +
                ", feedDescription='" + feedDescription + '\'' +
                ", feedPubDate=" + feedPubDate +
                ", categories=" + categories.toArray().toString() +
                ", feedViewerCount=" + feedViewerCount +
                ", feedChannel=" + feedChannel +
                '}';
    }
}
