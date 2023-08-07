package com.sq.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
public class CollectionVo {
    private Integer [] arr;
    private List list;
    private Set set;
    private Map map;
    private Properties properties;
}
