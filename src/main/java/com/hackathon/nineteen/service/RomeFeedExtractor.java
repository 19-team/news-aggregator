package com.hackathon.nineteen.service;

import com.hackathon.nineteen.model.FeedChannel;
import com.hackathon.nineteen.model.FeedItem;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Service
public class RomeFeedExtractor implements FeedExtractor {

    public List<FeedItem> extractFeedItems(String feedUrl) throws IOException, FeedException {

        URL url = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));

        FeedChannel channel = new FeedChannel();
        channel.setChanelLink(feed.getLink());
        channel.setChanelTitle(feed.getTitle());

        List<FeedItem> feedItems = new LinkedList<FeedItem>();

        for (SyndEntry syndEntry : feed.getEntries()) {

            FeedItem feedItem = new FeedItem();
            feedItem.setFeedUrl(syndEntry.getLink());
            feedItem.setFeedDescription(syndEntry.getDescription().getValue());
            feedItem.setFeedPubDate(syndEntry.getPublishedDate());
            feedItem.setFeedCategory(syndEntry.getCategories().get(0).getName());
            feedItem.setFeedChannel(channel);

            feedItems.add(feedItem);
        }

        return feedItems;
    }
}
