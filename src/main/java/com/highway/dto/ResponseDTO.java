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

    private Integer pageSize;

    private Integer pageNumber;

    public ResponseDTO(List<T> list,Integer pageSize,Integer pageNumber) {

        if(list.size() > 0) {
            this.count = list.size();
            this.list = list;
            this.pageSize = pageSize;
            this.pageNumber = pageNumber;
        }

    }

}
