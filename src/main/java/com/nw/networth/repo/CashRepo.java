package com.nw.networth.repo;

import com.nw.networth.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestResource(collectionResourceRel = "cash", path = "cash")
@CrossOrigin(origins = "http://localhost:4200")
public interface CashRepo extends JpaRepository<Cash, Long> {
}
