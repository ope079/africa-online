package com.africaonline.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.africaonline.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByItemName(String itemName);
}
