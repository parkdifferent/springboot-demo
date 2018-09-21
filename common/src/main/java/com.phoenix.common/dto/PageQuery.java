package com.phoenix.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tianFeng
 * @version 1.0, 2018/06/15
 */

@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = -2261297137167970438L;

    private Integer offset = 0;

    private Integer limit = 10;

}
