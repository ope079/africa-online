package com.africaonline.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.africaonline.Service.ItemRepository;
import com.africaonline.Service.ItemService;
import com.africaonline.model.Item;

@Controller
@SessionAttributes(value={"itemName", "name"})

public class ItemController {
	
//		@Autowired
//		ItemService service;
		
		@Autowired
		ItemRepository repository;
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}

		@RequestMapping(value="/categories", method = RequestMethod.GET)
		public String showCategoriesPage(ModelMap model) {
			return "categories";
		}
		
		@RequestMapping(value="/itemPage", method = RequestMethod.GET)
		public String showItemPage(ModelMap model) {
			//String itemName = (String) model.get("itemName");
			model.put("items", repository.findAll());
//			model.put("items", service.retrieveAllItems());
			return "itemPage";
		}
		
		
		private String getLoggedInUserName() {
			Object principal = 
					SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(principal instanceof UserDetails) {
				return ((UserDetails)principal).getUsername();
			}
			return principal.toString();
		}
		
		@RequestMapping(value="/addItem", method = RequestMethod.GET)
		public String showAddItem(ModelMap model) {	
			model.addAttribute("item", new Item(0,"Default Item", new BigDecimal(0),new Date(), ""));
			return "addItem";
		}
		
		@RequestMapping(value="/addItem", method = RequestMethod.POST)
		public String addItem(ModelMap model, @Valid Item item, BindingResult result) {
			if(result.hasErrors()) {
				return "addItem";
			}
			
			repository.save(item);
//			service.addItem(item.getItemName(), item.getItemPrice(),item.getUploadDate(), item.getItemDescription());
			return "redirect:/itemPage";
		}
		
		@RequestMapping(value="/deleteItem", method = RequestMethod.GET)
		public String deleteItem(@RequestParam int itemId) {
			repository.deleteById(itemId);
//			service.deleteItem(itemId);
			return "redirect:itemPage";
		}
		

		@RequestMapping(value="/updateItem", method = RequestMethod.GET)
		public String showUpdateItemPage(@RequestParam int itemId, ModelMap model) {
			Item item = repository.findById(itemId).get();
//			Item item = service.retrieveItem(itemId);
			model.put("item", item);
			return "updateItem";
		}
		
		@RequestMapping(value="/updateItem", method = RequestMethod.POST)
		public String updateItem(ModelMap model, @Valid Item item, BindingResult result, @RequestParam int itemId) {
			
			if(result.hasErrors()) {
				return "updateItem";
			}
			repository.save(item);
//			service.updateItem(item, itemId);
			return "redirect:itemPage";
		}
}
