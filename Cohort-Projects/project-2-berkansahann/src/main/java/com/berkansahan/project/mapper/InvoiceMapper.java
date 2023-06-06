package com.berkansahan.project.mapper;

import com.berkansahan.project.dto.invoice.InvoiceDTO;
import com.berkansahan.project.dto.invoice.InvoiceSaveRequest;
import com.berkansahan.project.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author berkansahan
 */
@Mapper
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    Invoice convertToInvoice(InvoiceSaveRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    InvoiceDTO convertToInvoiceDTO(Invoice invoice);

    List<InvoiceDTO> convertToInvoiceDTOList(List<Invoice> invoiceList);
}
