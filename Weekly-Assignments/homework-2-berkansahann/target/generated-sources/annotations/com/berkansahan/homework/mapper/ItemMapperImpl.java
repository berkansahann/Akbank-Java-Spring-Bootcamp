package com.berkansahan.homework.mapper;

import com.berkansahan.homework.dto.ItemDTO;
import com.berkansahan.homework.dto.ItemPriceUpdateRequest;
import com.berkansahan.homework.dto.ItemSaveRequest;
import com.berkansahan.homework.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T02:20:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item convertToItem(ItemSaveRequest itemSaveRequest) {
        if ( itemSaveRequest == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( itemSaveRequest.name() );
        item.setDescription( itemSaveRequest.description() );
        item.setPrice( itemSaveRequest.price() );

        return item;
    }

    @Override
    public ItemDTO convertToItemDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        Double price = null;

        id = item.getId();
        name = item.getName();
        description = item.getDescription();
        price = item.getPrice();

        ItemDTO itemDTO = new ItemDTO( id, name, description, price );

        return itemDTO;
    }

    @Override
    public List<ItemDTO> convertToItemDTOList(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( convertToItemDTO( item ) );
        }

        return list;
    }

    @Override
    public Item convertItemPriceToItem(ItemPriceUpdateRequest itemPriceUpdateRequest) {
        if ( itemPriceUpdateRequest == null ) {
            return null;
        }

        Item item = new Item();

        item.setPrice( itemPriceUpdateRequest.price() );

        return item;
    }
}
