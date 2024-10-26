package com.zeotap.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeotap.model.Node;

@Repository
public interface RuleRepository extends JpaRepository<Node, Long> {
}

