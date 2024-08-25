package org.gordeser.arthub.Service;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.TagEntity;
import org.gordeser.arthub.Repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService {

    private final TagRepository tagRepository;

    public List<TagEntity> getAll() {
        return tagRepository.findAll();
    }

    public TagEntity getTagById(Long tagId) throws Exception {
        return tagRepository.findById(tagId).orElseThrow(Exception::new);
    }

    public TagEntity createTag(TagEntity tag) {
        tagRepository.findByName(tag.getName()).ifPresent(t -> {
            throw new RuntimeException();
        });

        return tagRepository.save(tag);
    }

    public void deleteTagById(Long tagId) throws Exception {
        TagEntity tag = tagRepository.findById(tagId).orElseThrow(Exception::new);
        tagRepository.delete(tag);
    }
}
