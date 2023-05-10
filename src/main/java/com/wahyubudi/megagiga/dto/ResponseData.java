package com.wahyubudi.megagiga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponseData<T> {
    private boolean status;
    private List<String> message = new ArrayList<>();
    private T payload;
}
