package com.bwie.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Follow {

    private Integer id;
    private Integer complaint;
    private Integer followUser;
    private Integer satisfaction;

}
