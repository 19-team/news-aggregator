package com.hackathon.nineteen.repository;

import com.hackathon.nineteen.model.FeedChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Павло on 03.10.2017.
 */
public interface FeedChannelRepository extends JpaRepository<FeedChannel, Long> {
    List<FeedChannel> findFeedChannelsByChanelTitle(String chanelTitle);
}
