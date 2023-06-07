package com.berkansahan.project.dto.customer;

/**
 * @author berkansahan
 */
public record CustomerSaveRequest(String firstName,
                                  String lastName,
                                  String address,
                                  String sector) {
}
