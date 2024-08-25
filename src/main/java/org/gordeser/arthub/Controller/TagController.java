package org.gordeser.arthub.Controller;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.TagEntity;
import org.gordeser.arthub.Service.TagService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tags")
@CrossOrigin("")
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<TagEntity> getAllTags() {
        return tagService.getAll();
    }

    @GetMapping("{tag_id}")
    public TagEntity getTagById(@PathVariable("tag_id") Long tagId) throws Exception {
        return tagService.getTagById(tagId);
    }

    @PostMapping
    public TagEntity createTag(@Validated(TagEntity.class) @RequestBody TagEntity tag) {
        return tagService.createTag(tag);
    }

    @DeleteMapping("{tag_id}")
    public void deleteTagById(@PathVariable("tag_id") Long tagId) throws Exception {
        tagService.deleteTagById(tagId);
    }
}

