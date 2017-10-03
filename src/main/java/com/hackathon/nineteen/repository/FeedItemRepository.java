package com.hackathon.nineteen.repository;

import com.hackathon.nineteen.model.Category;
import com.hackathon.nineteen.model.FeedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Павло on 03.10.2017.
 */
public interface FeedItemRepository extends JpaRepository<FeedItem, Long> {

    List<FeedItem> findFeedItemsByCategory(Category category);
    List<FeedItem> findFeedItemsByFeedChannelId(Long id);

}
