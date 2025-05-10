package com.qiangi.user.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
public class PageResult<T>implements Serializable {


    private Long total;

    private Long size;

    private Long current;

    private Long pages;

    private List<T> recodes = Collections.emptyList();

    public void loadData(IPage<T> iPage) {
        this.setTotal(iPage.getTotal());
        this.setSize(iPage.getSize());
        this.setCurrent(iPage.getCurrent());
        this.setPages(iPage.getPages());
        this.setRecodes(iPage.getRecords());
    }
}
