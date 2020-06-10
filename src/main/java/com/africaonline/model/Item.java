package com.africaonline.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int itemId;
	
	@Size(min=5, message="Enter at least 5 Characters...")
	private String itemName;
	
	
	private BigDecimal itemPrice;
	
	private Date uploadDate;
	
	@Size(min=10, message="Enter at least 10 Characters...")
	private String itemDescription;
	
	public Item() {
		super();
	}
	
	public Item(int itemId, String itemName, BigDecimal itemPrice, Date uploadDate, String itemDescription) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.uploadDate = uploadDate;
		this.itemDescription = itemDescription;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", uploadDate="
				+ uploadDate + ", itemDescription=" + itemDescription + "]";
	}
	
	
	
}
