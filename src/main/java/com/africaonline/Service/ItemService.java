package com.africaonline.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.africaonline.model.Item;

@Service
public class ItemService {
	
	private static List<Item> items = new ArrayList<Item>();
	private static int itemCount = 3;
	
	static {
		items.add(new Item(1, "gold", new BigDecimal(110),new Date(), "pound of gold" ));
		items.add(new Item(2, "silver", new BigDecimal(90),new Date(),"pound of silver" ));
		items.add(new Item(3, "bentonite", new BigDecimal(50),new Date(),"pound of bentonite" ));
	}
	
	public List<Item> retrieveItems(String itemName){
		List<Item> filteredItems = new ArrayList<Item>();
		for(Item item : items) {
			if (item.getItemName().equals(itemName)) {
				filteredItems.add(item);
			}
		}
		return filteredItems;
	}

	public Item retrieveItem(int itemId){
		for(Item item : items) {
			if (item.getItemId() == itemId) {
				return item;
			}
		}
		return null;
	}
	
	public List<Item> retrieveAllItems(){
		return items;
	}
	
	public void updateItem(Item item, int itemId) {
		this.deleteItem(itemId);
		items.add(item);
	}
	
	public void addItem(String itemName, BigDecimal itemPrice,Date uploadDate, String itemDescription) {
		items.add(new Item(++itemCount, itemName, itemPrice, uploadDate, itemDescription));
	}
	
	public void deleteItem(int itemId) {
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			if(item.getItemId() == itemId) {
				iterator.remove();
			}
		}
	}
	
}
