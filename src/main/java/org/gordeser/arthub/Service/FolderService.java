package org.gordeser.arthub.Service;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.FolderEntity;
import org.gordeser.arthub.Repository.FolderRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FolderService {

    private final FolderRepository folderRepository;

    public FolderEntity getFolderById(Long folderId) throws Exception {
        return folderRepository.findById(folderId).orElseThrow(Exception::new);
    }

    public FolderEntity createFolder(FolderEntity folder) {
        folderRepository.findByUserAndTitle(folder.getUser(), folder.getTitle()).ifPresent(f -> {
            throw new RuntimeException();
        });

        return folderRepository.save(folder);
    }

    public FolderEntity updateFolder(Long folderId, FolderEntity folder) throws Exception {
        FolderEntity folderToUpdate = folderRepository.findById(folderId).orElseThrow(Exception::new);

        // todo: make folder updating

        return folderRepository.save(folderToUpdate);
    }

    public void deleteFolderById(Long folderId) throws Exception {
        FolderEntity folderToDelete = folderRepository.findById(folderId).orElseThrow(Exception::new);
        folderRepository.delete(folderToDelete);
    }
}
