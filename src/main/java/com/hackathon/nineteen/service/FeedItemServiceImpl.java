package com.hackathon.nineteen.service;

import com.hackathon.nineteen.model.FeedItem;
import com.hackathon.nineteen.repository.FeedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedItemServiceImpl implements  FeedItemService{


    @Autowired
    FeedItemRepository feedItemRepository;


    @Override
    public List<FeedItem> getAll() {
       return  feedItemRepository.findAllByOrderByFeedPubDateAsc();
    }
}
