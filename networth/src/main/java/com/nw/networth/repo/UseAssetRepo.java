package com.nw.networth.repo;

import com.nw.networth.entity.UseAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseAssetRepo extends JpaRepository<UseAsset, Long> {
}
