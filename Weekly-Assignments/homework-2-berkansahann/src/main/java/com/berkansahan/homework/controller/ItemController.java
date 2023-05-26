package com.berkansahan.homework.controller;

import com.berkansahan.homework.controller.contract.ItemControllerContract;
import com.berkansahan.homework.dto.ItemDTO;
import com.berkansahan.homework.dto.ItemPriceUpdateRequest;
import com.berkansahan.homework.dto.ItemSaveRequest;
import com.berkansahan.homework.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author berkansahan
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemControllerContract itemControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<ItemDTO>> save(@RequestBody ItemSaveRequest itemSaveRequest){
        var itemDTO = itemControllerContract.save(itemSaveRequest);
        return ResponseEntity.ok(RestResponse.of(itemDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ItemDTO>>> findAll() {
        var itemDTOList = itemControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(itemDTOList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ItemDTO>> findById(@PathVariable Long id) {
        var itemDTO = itemControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(itemDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> deleteById(@PathVariable Long id) {
        itemControllerContract.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ItemDTO>> updatePriceById(@PathVariable Long id, @RequestBody ItemPriceUpdateRequest request) {
        var itemDTO = itemControllerContract.updatePriceById(id, request);
        return ResponseEntity.ok(RestResponse.of(itemDTO));
    }

}
