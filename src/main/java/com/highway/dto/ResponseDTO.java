package com.highway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/13.
 */
@Data
@NoArgsConstructor
public class ResponseDTO <T> {

    private int count;

    private List<T> list;

    public ResponseDTO(List<T> list) {

        if(list.size() > 0) {
            this.count = list.size();
            this.list = list;
        }

    }

}
