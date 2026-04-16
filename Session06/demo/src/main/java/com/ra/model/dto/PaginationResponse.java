package com.ra.model.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaginationResponse<T> {
    private List<T> data;
    private int totalPage;
    private int totalElement;
    private int currentPage;
}
