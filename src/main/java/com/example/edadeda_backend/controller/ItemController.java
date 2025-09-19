package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.item.ItemCreateRequest;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemUpdateRequest;
import com.example.edadeda_backend.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemResponse> getItems() {
        return itemService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse create(@RequestBody ItemCreateRequest req) {
        return itemService.save(req);
    }

    @GetMapping("/{id}")
    public ItemResponse getItem(@PathVariable Long id) {
        return itemService.get(id);
    }

    @PutMapping("/{id}")
    public ItemResponse updateItem(@PathVariable Long id, @RequestBody ItemUpdateRequest req) {
        return itemService.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        this.itemService.deleteById(id);
    }


}
