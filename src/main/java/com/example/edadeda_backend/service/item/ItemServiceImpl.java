package com.example.edadeda_backend.service.item;

import com.example.edadeda_backend.exception.NotFoundException;
import com.example.edadeda_backend.model.dto.item.ItemCreateRequest;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemUpdateRequest;
import com.example.edadeda_backend.model.entity.EnumItemStatus;
import com.example.edadeda_backend.model.entity.Item;
import com.example.edadeda_backend.model.entity.User;
import com.example.edadeda_backend.repository.ItemRepository;
import com.example.edadeda_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ItemServiceImpl(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    private ItemResponse toResponse(Item i) {
        return new ItemResponse(i.getId(), i.getTitle(), i.getDescription(),
                i.getPrice(), i.getLocation(),
                i.getStatus(), i.getAutoReportLink(),
                i.getSeller().getId());
    }

    @Override
    public ItemResponse createItem(ItemCreateRequest req) {
        User seller = userRepository.findById(req.getSellerId()).orElseThrow(
                () -> new NotFoundException("Seller not found"));

        Item i = new Item();
        i.setTitle(req.getTitle());
        i.setDescription(req.getDescription());
        i.setPrice(req.getPrice());
        i.setLocation(req.getLocation());
        i.setAutoReportLink(req.getAuto_report_link());
        i.setSeller(seller);
        return toResponse(this.itemRepository.save(i));
    }

    @Override
    public ItemResponse getItem(Long id) {
        Item i = itemRepository.findById(id).orElseThrow(() -> new NotFoundException("Item not found"));
        return toResponse(i);
    }

    @Override
    public List<ItemResponse> getAllItems() {
        return itemRepository.findAll().stream()
                .map((this::toResponse))
                .toList();
    }

    @Override
    public ItemResponse updateItem(Long id, ItemUpdateRequest req) {
        Item i = itemRepository.findById(id).orElseThrow(() -> new NotFoundException("Item not found"));

        if (req.getTitle() != null)        i.setTitle(req.getTitle());
        if (req.getDescription() != null)  i.setDescription(req.getDescription());
        if (req.getPrice() != null)        i.setPrice(req.getPrice());
        if (req.getLocation() != null)     i.setLocation(req.getLocation());
        if (req.getStatus() != null)       i.setStatus(Enum.valueOf(EnumItemStatus.class, req.getStatus()));
        if (req.getAuto_report_link() != null) i.setAutoReportLink(req.getAuto_report_link());

        return toResponse(itemRepository.save(i));
    }

    @Override
    public void deleteById(Long id) {
        if (!itemRepository.existsById(id)) throw new NotFoundException("You try to delete not existed item");
        itemRepository.deleteById(id);
    }
}
