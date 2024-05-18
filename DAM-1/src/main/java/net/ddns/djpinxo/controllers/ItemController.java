package net.ddns.djpinxo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ddns.djpinxo.models.Item;
import net.ddns.djpinxo.repositories.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/items")
	public Iterable<Item> getItems() {
		return itemRepository.findAll();
	}

	@GetMapping("/items/{id}")
	public Optional<Item> getItem(@PathVariable Long id) {
		return itemRepository.findById(id);
	}

	@PostMapping("/items")
	public Optional<Item> postItem(@RequestBody Item item) {
		Optional<Item> itemSaved = itemRepository.findById(item.getId());
		if (itemSaved.isEmpty()) {
			return Optional.of(itemRepository.save(item));
		}
		else return Optional.empty();
	}

	@PutMapping("/items/{id}")
	public Optional<Item> putItem(@RequestBody Item item,@PathVariable Long id) {
		Optional<Item> itemSaved = itemRepository.findById(id);
		if (!itemSaved.isEmpty()) {
			item.setId(id);
			itemSaved =Optional.of(itemRepository.save(item));
		}
		return itemSaved;
	}
	
	@DeleteMapping("/items/{id}")
	public void deleteItem(@PathVariable Long id) {
		itemRepository.deleteById(id);
	}

}
