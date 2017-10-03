package com.hackathon.nineteen.service;

import com.hackathon.nineteen.model.FeedItem;
import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface FeedExtractor {

    public void extractFeedItems(String feedUrl) throws IOException, FeedException;
}
