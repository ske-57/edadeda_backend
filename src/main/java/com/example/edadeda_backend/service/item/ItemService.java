package com.example.edadeda_backend.service.item;

import com.example.edadeda_backend.model.dto.item.ItemCreateRequest;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemUpdateRequest;
import com.example.edadeda_backend.model.entity.Item;

import java.util.List;

public interface ItemService {
    ItemResponse save(ItemCreateRequest req);
    ItemResponse get(Long id);
    List<ItemResponse> findAll();
    ItemResponse update(Long id, ItemUpdateRequest req);
    void deleteById(Long id);
}
