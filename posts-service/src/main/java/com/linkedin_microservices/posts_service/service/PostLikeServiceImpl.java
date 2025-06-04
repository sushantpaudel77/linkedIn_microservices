package com.linkedin_microservices.posts_service.service;

import com.linkedin_microservices.posts_service.entity.PostLike;
import com.linkedin_microservices.posts_service.exception.BadRequestException;
import com.linkedin_microservices.posts_service.exception.ResourceNotFoundException;
import com.linkedin_microservices.posts_service.repository.PostLikeRepository;
import com.linkedin_microservices.posts_service.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;

    public void likePost(Long postId, Long userId) {
        log.info("Attempting to like the post with ID: {}", postId);
        boolean exists = postRepository.existsById(postId);
        if (!exists) throw new ResourceNotFoundException("Post not found with ID: " + postId);

        boolean alreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId, postId);
        if (alreadyLiked) throw new BadRequestException("Cannot like the same post again.");

        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);

        postLikeRepository.save(postLike);
        log.info("Post with ID: {} liked successfully", postId);
    }

    @Transactional
    @Override
    public void unlikePost(Long postId, long userId) {
        log.info("Attempting to unlike the post with ID: {}", postId);
        boolean exists = postRepository.existsById(postId);
        if (!exists) throw new ResourceNotFoundException("Post not found with ID: " + postId);

        boolean alreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId, postId);
        if (!alreadyLiked) throw new BadRequestException("Cannot unlike the post which is not liked.");

        postLikeRepository.deleteByUserIdAndPostId(userId, postId);

        log.info("Post with ID: {} unliked successfully", postId);
    }
}

