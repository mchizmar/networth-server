package com.nw.networth.repo;

import com.nw.networth.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepo extends JpaRepository<Investment, Long> {
}
