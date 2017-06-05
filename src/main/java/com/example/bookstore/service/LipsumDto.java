package com.example.bookstore.service;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by RENT on 2017-06-05.
 */
public class LipsumDto {

    private FeedDto feed;

    public LipsumDto(FeedDto feed) {
        this.feed = feed;
    }

    public FeedDto getFeed() {
        return feed;
    }

    public static class FeedDto {
        private String lipsum;

        public FeedDto (@JsonProperty("lipsum") String lipsum){
            this.lipsum = lipsum;
        }

        public String getLipsum() {
            return lipsum;
        }
    }
}
