/*
 * package com.kirana.transactions.controller;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; 
 * import org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class RateLimitedController {
 * 
 * private final Bucket bucket;
 * 
 * public RateLimitedController() { Bandwidth limit = Bandwidth.classic(10,
 * Refill.greedy(10, Duration.ofMinutes(1))); this.bucket =
 * Bucket4j.builder().addLimit(limit).build(); }
 * 
 * @GetMapping("/rate-limited-api") public String callRateLimitedApi() { if
 * (bucket.tryConsume(1)) { return "API called successfully!"; } return
 * "Too many requests!";
 * 
 * 
 * }
 */