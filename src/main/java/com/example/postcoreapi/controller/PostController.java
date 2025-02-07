package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/post")
@Validated
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("post-core-api is working");
    }


    @PostMapping
    public ResponseEntity<PostModel> createPost(@Valid @RequestBody PostModel postModel) {
        postService.createPost(postModel);
        return new ResponseEntity<>(postModel, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostModel>> getAllPosts() {
        List<PostModel> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }


    @GetMapping("/{postId}")
    public ResponseEntity<PostModel> getPostById(@PathVariable String postId) {
        try {
            PostModel post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostModel> updatePostById(@PathVariable String postId,
                                                    @Valid @RequestBody PostModel postModel) {
        try {
            postService.updatePostById(postId, postModel);
            PostModel updatedPost = postService.getPostById(postId);
            return ResponseEntity.ok(updatedPost);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostById(@PathVariable String postId) {
        postService.deletePostById(postId);
        return ResponseEntity.noContent().build();
    }
}

