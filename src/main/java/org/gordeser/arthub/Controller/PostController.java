package org.gordeser.arthub.Controller;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.PostEntity;
import org.gordeser.arthub.Service.PostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
@CrossOrigin("")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("{post_id}")
    public PostEntity getPostById(@PathVariable("post_id") Long postId) throws Exception {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostEntity createPost(@Validated(PostEntity.class) @RequestBody PostEntity post) {
        return postService.createPost(post);
    }

    @PutMapping("{post_id}")
    public PostEntity updatePostById(
            @PathVariable("post_id") Long postId,
            @Validated(PostEntity.class) @RequestBody PostEntity post
    ) throws Exception {
        return postService.updatePost(postId, post);
    }

    @DeleteMapping("{post_id}")
    public void deletePostById(@PathVariable("post_id") Long postId) throws Exception {
        postService.deletePostById(postId);
    }
}

