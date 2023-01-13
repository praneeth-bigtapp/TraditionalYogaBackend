package com.traditional.yoga.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/video", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class YoutubeController {
	 @Autowired
	 private RestTemplate restTemplate;
	 
	    @GetMapping("/youtube-data-api")
	
	    public Object youTube(@RequestParam String key,@RequestParam String part,@RequestParam String q,
	            @RequestParam String channelId,@RequestParam String type,@RequestParam String maxResults)throws Exception
	    {
	        if (q == null || q.trim().isEmpty()) {
	            throw new IllegalArgumentException("'q' parameter must be provided");
	        }
	        if (channelId == null || channelId.trim().isEmpty()) {
	            throw new IllegalArgumentException("'channelId' parameter must be provided");
	        }
	        String url="https://www.googleapis.com/youtube/v3/search?key={key}&part={part}&q={q}&channelId={channelId}&type={type}&maxResults={maxResults}";
	        Map<String,String>params=new HashMap<>();
	        params.put("key", key);
	        params.put("part", part);
	        params.put("q", q);
	        params.put("channelId", channelId);
	        params.put("type", type);
	        params.put("maxResults", maxResults);
	        return restTemplate.getForObject(url, Object.class, params);
	    }

	    
	    
	    @GetMapping("/youtube-data-api-live")
	    public Object youTubelive(@RequestParam String key,@RequestParam String part,@RequestParam String q,
	            @RequestParam String channelId,@RequestParam String type,@RequestParam String event_type,@RequestParam String id)throws Exception
	    {
	        String url="https://www.googleapis.com/youtube/v3/search?key={key}&part={part}&q={q}&channelId={channelId}&type={type}&event_type={event_type}&id={id}";
	        Map<String,String>params=new HashMap<>();
	        params.put("key", key);
	        params.put("part", part);
	        params.put("q", q);
	        params.put("channelId", channelId);
	        params.put("type", type);
	        params.put("event_type", event_type);
	        params.put("id", id);


	        return restTemplate.getForObject(url, Object.class, params);

	    }
	    
	    
	   
}
