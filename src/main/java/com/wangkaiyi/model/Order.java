package com.wangkaiyi.model;

import jdk.net.SocketFlow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_order")
public class Order {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long oid;
    private Long totalprice;
    private Long goodscount;
    private String address;
    private Long status;
    private Long user_id;
    private Long goods_id;

    public Order(Long user_id, Long goods_id, Long goodscout, Long totalprice, String address, Long status) {

    }
}
