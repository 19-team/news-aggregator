package com.hackathon.nineteen.repository;

import com.hackathon.nineteen.model.FeedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Павло on 03.10.2017.
 */
public interface FeedItemRepository extends JpaRepository<FeedItem, Long> {

    FeedItem findFeedItemByFeedUrl(String feedUrl);

    List <FeedItem> findAllByOrderByFeedPubDateDesc();

    List <FeedItem> findAllByOrderByFeedPubDateAsc();
}
