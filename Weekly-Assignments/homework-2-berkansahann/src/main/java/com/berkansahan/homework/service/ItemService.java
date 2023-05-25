package com.berkansahan.homework.service;

import com.berkansahan.homework.entity.Item;
import com.berkansahan.homework.general.BaseEntityService;
import com.berkansahan.homework.repository.ItemRepository;
import org.springframework.stereotype.Service;

/**
 * @author berkansahan
 */
@Service
public class ItemService extends BaseEntityService<Item, ItemRepository> {

    public ItemService(ItemRepository repository) {
        super(repository);
    }
}
