package com.hackathon.nineteen.scheduler;

import com.hackathon.nineteen.model.FeedChannel;
import com.hackathon.nineteen.service.FeedChannelService;
import com.hackathon.nineteen.service.FeedExtractor;
import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UpdateNewsScheduler {

    @Autowired
    FeedExtractor feedExtractor;

    @Autowired
    FeedChannelService feedChannelService;


    @Scheduled(fixedRate = 600000)
    public void updateFeedItems(){
        for (FeedChannel  fc : feedChannelService.getAll()){
            try {
                feedExtractor.extractFeedItems(fc.getChannelLink());
            } catch (IOException | FeedException e) {
                e.printStackTrace();
            }
        }
    }
}
