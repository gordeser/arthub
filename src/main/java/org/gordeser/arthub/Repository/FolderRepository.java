package org.gordeser.arthub.Repository;

import org.gordeser.arthub.Entity.FolderEntity;
import org.gordeser.arthub.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
    Optional<FolderEntity> findByUserAndTitle(UserEntity user, String title);
}