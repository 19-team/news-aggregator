package com.hackathon.nineteen.service;

import com.hackathon.nineteen.model.Category;
import com.hackathon.nineteen.model.FeedChannel;
import com.hackathon.nineteen.model.FeedItem;
import com.hackathon.nineteen.repository.CategoryRepository;
import com.hackathon.nineteen.repository.FeedChannelRepository;
import com.hackathon.nineteen.repository.FeedItemRepository;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Service
public class RomeFeedExtractor implements FeedExtractor {

    @Autowired
    FeedChannelRepository feedChannelRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FeedItemRepository feedItemRepository;

    public void extractFeedItems(String feedUrl) throws IOException, FeedException {

        URL url = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));

        FeedChannel channel = feedChannelRepository.findFeedChannelsByChannelLink(feed.getLink());

        if (channel == null) {
            channel = new FeedChannel();
            channel.setChannelLink(feed.getLink());
            channel.setChannelTitle(feed.getTitle());
            feedChannelRepository.save(channel);
        }


        for (SyndEntry syndEntry : feed.getEntries()) {

            FeedItem feedItem = feedItemRepository.findFeedItemByFeedUrl(syndEntry.getLink());

            if (feedItem == null) {
                feedItem = new FeedItem();
                feedItem.setFeedTitle(syndEntry.getTitle());
                feedItem.setFeedUrl(syndEntry.getLink());
                feedItem.setFeedDescription(syndEntry.getDescription().getValue());
                feedItem.setFeedPubDate(syndEntry.getPublishedDate());


                List<Category> categories = new LinkedList<Category>();

                for (SyndCategory c : syndEntry.getCategories()) {
                    Category category = categoryRepository.findCategoryByCategoryName(c.getName());
                    if (category == null) {
                        category = new Category();
                        category.setCategoryName(c.getName());
                        categoryRepository.save(category);
                    }
                    categories.add(category);
                }

                feedItem.setCategories(categories);

                feedItem.setFeedChannel(channel);
                feedItemRepository.save(feedItem);
            }
        }
    }
}
