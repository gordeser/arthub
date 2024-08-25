package org.gordeser.arthub.Service;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.PostEntity;
import org.gordeser.arthub.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostEntity> getAll() {
        return postRepository.findAll();
    }

    public PostEntity getPostById(Long postId) throws Exception {
        return postRepository.findById(postId).orElseThrow(Exception::new);
    }

    public PostEntity createPost(PostEntity post) {
        return postRepository.save(post);
    }

    public PostEntity updatePost(Long postId, PostEntity post) throws Exception {
        PostEntity postToUpdate = postRepository.findById(postId).orElseThrow(Exception::new);

        // todo: make post updating

        return postToUpdate;
    }

    public void deletePostById(Long postId) throws Exception {
        PostEntity postToDelete = postRepository.findById(postId).orElseThrow(Exception::new);
        postRepository.delete(postToDelete);
    }
}
