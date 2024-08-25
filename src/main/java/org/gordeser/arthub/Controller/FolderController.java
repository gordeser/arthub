package org.gordeser.arthub.Controller;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.FolderEntity;
import org.gordeser.arthub.Service.FolderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/folders/")
@CrossOrigin("")
public class FolderController {

    private final FolderService folderService;

    @GetMapping("{folder_id}")
    public FolderEntity getFolderById(@PathVariable("folder_id") Long folderId) throws Exception {
        return folderService.getFolderById(folderId);
    }

    @PostMapping
    public FolderEntity createFolder(@Validated(FolderEntity.class) @RequestBody FolderEntity folder) {
        return folderService.createFolder(folder);
    }

    @PutMapping("{folder_id}")
    public FolderEntity updateFolder(
            @PathVariable("folder_id") Long folderId,
            @Validated(FolderEntity.class) @RequestBody FolderEntity folder
    ) throws Exception {
        return folderService.updateFolder(folderId, folder);
    }

    @DeleteMapping("{folder_id}")
    public void deleteFolder(@PathVariable("folder_id") Long folderId) throws Exception {
        folderService.deleteFolderById(folderId);
    }
}

