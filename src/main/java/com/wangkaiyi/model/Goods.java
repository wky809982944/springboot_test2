package com.wangkaiyi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_goods")
public class Goods {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "`pid`")
    private Long pid;
    private Long price;
    private String name;
    @Column(name = "`desc`")
    private String desc;
    private Long cid;
    private String path;
    private Long stock;
}
