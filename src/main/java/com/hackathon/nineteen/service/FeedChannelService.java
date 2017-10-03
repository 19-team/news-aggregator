package com.hackathon.nineteen.service;

import com.hackathon.nineteen.model.FeedChannel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FeedChannelService {

    List <FeedChannel> getAll();
}
