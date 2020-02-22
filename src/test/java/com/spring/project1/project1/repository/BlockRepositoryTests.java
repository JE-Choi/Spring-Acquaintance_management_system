package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTests {
    @Autowired
    BlockRepository blockRepository;

    @Test
    void crud(){
        Block block = new Block();
        block.setName("martin");
        block.setReason("욕");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);
        // 객체 타입 지정 안 해주면, 메소드 자동완성 안됨.
        List<Block> block_list = blockRepository.findAll();
        assertThat(block_list.size()).isEqualTo(1);
        assertThat(block_list.get(0).getName()).isEqualTo("martin");
    }
}