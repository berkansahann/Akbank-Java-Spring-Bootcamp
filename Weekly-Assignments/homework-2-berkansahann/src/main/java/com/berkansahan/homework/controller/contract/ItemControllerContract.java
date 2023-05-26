package com.berkansahan.homework.controller.contract;

import com.berkansahan.homework.dto.ItemDTO;
import com.berkansahan.homework.dto.ItemPriceUpdateRequest;
import com.berkansahan.homework.dto.ItemSaveRequest;

import java.util.List;

/**
 * @author berkansahan
 */
public interface ItemControllerContract {

    ItemDTO save(ItemSaveRequest request);

    List<ItemDTO> findAll();

    ItemDTO findById(Long id);

    void deleteById(Long id);

    ItemDTO updatePriceById(Long id, ItemPriceUpdateRequest request);
}
