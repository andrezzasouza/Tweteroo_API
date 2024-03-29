package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/tweets")
public class TweetController {
  final TweetService tweetService;

  TweetController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @PostMapping
  public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
    Optional<TweetModel> tweet = tweetService.save(body);

    if (!tweet.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o autor do tweet!");
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
  }

  @GetMapping
  public ResponseEntity<List<TweetModel>> getTweets() {
    List<TweetModel> tweets = tweetService.getAll();

    return ResponseEntity.status(HttpStatus.OK).body(tweets);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<Object> getTweetsByUser(@PathVariable Long userId) {
    Optional<List<TweetModel>> tweetsByUser = tweetService.getTweetsByUser(userId);

    if (!tweetsByUser.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar os tweets do usuário!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(tweetsByUser);
  }

}
