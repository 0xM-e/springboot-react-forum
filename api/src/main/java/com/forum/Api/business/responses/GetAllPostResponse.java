package com.forum.Api.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllPostResponse {
    private int id;
    private String title;
    private String content;
}
