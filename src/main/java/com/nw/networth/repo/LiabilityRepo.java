package com.nw.networth.repo;

import com.nw.networth.entity.Liability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LiabilityRepo extends JpaRepository<Liability, Long> {

}
