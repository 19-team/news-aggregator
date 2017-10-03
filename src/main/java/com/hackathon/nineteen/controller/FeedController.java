package com.hackathon.nineteen.controller;

import com.hackathon.nineteen.model.FeedChannel;
import com.hackathon.nineteen.model.FeedItem;
import com.hackathon.nineteen.service.FeedChannelService;
import com.hackathon.nineteen.service.FeedExtractor;
import com.hackathon.nineteen.service.FeedItemService;
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
    FeedItemService feedItemService;

    @Autowired
    FeedChannelService feedChannelService;

    @Autowired
    FeedExtractor feedExtractor;

    private List<FeedItem> feedItems;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getNewFeed(Model model) throws IOException, FeedException {

        List <FeedItem> items = new LinkedList<FeedItem>();

        model.addAttribute("items", feedItemService.getAllDesc());

        return "index";
    }

    @RequestMapping(value = "/desc", method = RequestMethod.GET)
    public String getOldFeed(Model model) throws IOException, FeedException {

        List <FeedItem> items = new LinkedList<FeedItem>();

        model.addAttribute("items", feedItemService.getAllAsc());

        return "index";
    }
}
