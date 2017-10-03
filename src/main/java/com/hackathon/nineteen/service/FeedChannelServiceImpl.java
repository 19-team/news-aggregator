package com.hackathon.nineteen.service;

import com.hackathon.nineteen.model.FeedChannel;
import com.hackathon.nineteen.repository.FeedChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedChannelServiceImpl implements FeedChannelService{

    @Autowired
    FeedChannelRepository feedChannelRepository;

    public List<FeedChannel> getAll(){
        return feedChannelRepository.findAll();
    }
}
