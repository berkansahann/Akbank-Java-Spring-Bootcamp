package com.berkansahan.homework.mapper;

import com.berkansahan.homework.dto.ItemDTO;
import com.berkansahan.homework.dto.ItemPriceUpdateRequest;
import com.berkansahan.homework.dto.ItemSaveRequest;
import com.berkansahan.homework.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author berkansahan
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item convertToItem(ItemSaveRequest itemSaveRequest);

    ItemDTO convertToItemDTO(Item item);

    List<ItemDTO> convertToItemDTOList(List<Item> itemList);

    Item convertItemPriceToItem(ItemPriceUpdateRequest itemPriceUpdateRequest);
}
