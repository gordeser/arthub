package org.gordeser.arthub.Repository;

import org.gordeser.arthub.Entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<FolderEntity, Long>, JpaSpecificationExecutor<FolderEntity> {
}