package com.hackathon.nineteen.controller;

import com.hackathon.nineteen.model.FeedChannel;
import com.hackathon.nineteen.model.FeedItem;
import com.hackathon.nineteen.service.FeedChannelService;
import com.hackathon.nineteen.service.FeedExtractor;
import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class FeedController {

    @Autowired
    FeedExtractor feedExtractor;

    @Autowired
    FeedChannelService feedChannelService;

    private List<FeedItem> feedItems;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFeed(Model model) throws IOException, FeedException {

        List <FeedItem> items = new LinkedList<FeedItem>();

        for(FeedChannel feedChannel : feedChannelService.getAll()){
            items.addAll(feedExtractor.extractFeedItems(feedChannel.getChannelLink()));
        }

        model.addAttribute("items", items);

        return "index";
    }
}
