package com.berkansahan.homework.controller.contract.impl;

import com.berkansahan.homework.controller.contract.ItemControllerContract;
import com.berkansahan.homework.dto.ItemDTO;
import com.berkansahan.homework.dto.ItemPriceUpdateRequest;
import com.berkansahan.homework.dto.ItemSaveRequest;
import com.berkansahan.homework.entity.Item;
import com.berkansahan.homework.mapper.ItemMapper;
import com.berkansahan.homework.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class ItemControllerContractImpl implements ItemControllerContract {

    private final ItemService itemService;

    @Override
    public ItemDTO save(ItemSaveRequest request) {
        Item item = ItemMapper.INSTANCE.convertToItem(request);
        item = itemService.save(item);
        return ItemMapper.INSTANCE.convertToItemDTO(item);
    }

    @Override
    public List<ItemDTO> findAll() {
        List<Item> itemList = itemService.findAll();
        return ItemMapper.INSTANCE.convertToItemDTOList(itemList);
    }

    @Override
    public ItemDTO findById(Long id) {
        Item item = itemService.findByIdWithControl(id);
        return ItemMapper.INSTANCE.convertToItemDTO(item);
    }

    @Override
    public void deleteById(Long id) {
        itemService.deleteById(id);
    }

    @Override
    public ItemDTO updatePriceById(Long id, ItemPriceUpdateRequest request) {
        Item item = itemService.findByIdWithControl(id);
        item.setPrice(request.price());
        itemService.save(item);
        return ItemMapper.INSTANCE.convertToItemDTO(item);
    }
}
