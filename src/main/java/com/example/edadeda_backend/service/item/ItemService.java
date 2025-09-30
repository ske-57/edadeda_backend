package com.example.edadeda_backend.service.item;

import com.example.edadeda_backend.model.dto.item.ItemCreateRequest;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemUpdateRequest;

import java.util.List;

public interface ItemService {
    ItemResponse createItem(ItemCreateRequest req);
    ItemResponse getItem(Long id);
    List<ItemResponse> getAllItems();
    ItemResponse updateItem(Long id, ItemUpdateRequest req);
    void deleteById(Long id);
}
