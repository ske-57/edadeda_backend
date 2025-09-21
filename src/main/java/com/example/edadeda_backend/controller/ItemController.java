package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.item.ItemCreateRequest;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemUpdateRequest;
import com.example.edadeda_backend.service.item.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Items")
@RequestMapping("api/v1/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Get items list")
    @GetMapping
    public List<ItemResponse> getItems() {
        return itemService.getAllItems();
    }

    @Operation(summary = "Create new item")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse createItem(@RequestBody ItemCreateRequest req) {
        return itemService.createItem(req);
    }

    @Operation(summary = "Get item by id")
    @GetMapping("/{id}")
    public ItemResponse getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @Operation(summary = "Partially change item")
    @PatchMapping("/{id}")
    public ItemResponse updateItem(@PathVariable Long id, @RequestBody ItemUpdateRequest req) {
        return itemService.updateItem(id, req);
    }

    @Operation(summary = "Delete item by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable Long id) {
        this.itemService.deleteById(id);
    }


}
