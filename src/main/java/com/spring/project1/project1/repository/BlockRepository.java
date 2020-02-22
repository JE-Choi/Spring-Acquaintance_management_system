package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
