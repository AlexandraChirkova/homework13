package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    private static final Map<String, PostModel> posts = new HashMap<>();

    @Override
    public void createPost(PostModel postModel) {
        String id = UUID.randomUUID().toString();
        postModel.setPostId(id);
        if (postModel.getStatus() == null || postModel.getStatus().isEmpty()) {
            postModel.setStatus("CREATED");
        }
        posts.put(id, postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        PostModel post = posts.get(postId);
        if (post == null) {
            throw new NoSuchElementException("Посылка с ID " + postId + " не найдена");
        }
        return post;
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        PostModel existingPost = posts.get(postId);
        if (existingPost == null) {
            throw new NoSuchElementException("Посылка с ID " + postId + " не найдена");
        }
        existingPost.setClientId(postModel.getClientId());
        existingPost.setPostRecipientId(postModel.getPostRecipientId());
        existingPost.setPostItem(postModel.getPostItem());
        existingPost.setStatus(postModel.getStatus());
        posts.put(postId, existingPost);

    }

    @Override
    public void deletePostById(String postId) {
        posts.remove(postId);
    }
}
