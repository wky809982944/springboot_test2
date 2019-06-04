package com.wangkaiyi.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyGoods {
    private String pid;
    private String totalprice;
    private String goodscount;
}
