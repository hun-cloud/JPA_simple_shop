package com.example.demo.shop.service;

import com.example.demo.shop.domain.Book;
import com.example.demo.shop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("saveItem")
    @Test
    void 아이템_저장() {
        // given
        Book book = new Book();
        book.setAuthor("me");
        // when
        itemService.saveItem(book);
        // then
        assertThat(book).isEqualTo(itemRepository.findOne(book.getId()));
    }
}