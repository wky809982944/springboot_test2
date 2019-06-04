package com.wangkaiyi.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    /*    BRAND_NOT_FOUNT(404, "品牌不存在"),
        CATEGORY_NOT_FOND(404, "商品分类没查到"),
        SPEC_GROUP_NOT_FOND(404, "商品规格组不存在"),
        SPEC_PARAM_NOT_FOND(404, "商品规格参数不存在"),
        GOODS_NOT_FOND(404, "商品不存在"),
        GOODS_DETAIL_NOT_FOND(404, "商品详情不存在"),
        GOODS_SKU_NOT_FOND(404, "商品SKU不存在"),
        GOODS_STOCK_NOT_FOND(404, "商品库存不存在"),
        BRAND_SAVE_ERROR(500, "新增品牌失败"),
        UPLOAD_FILE_ERROR(500, "文件上传失败"),
        INVALID_FILE_TYPE(400, "无效的文件类型"),
       GOODS_SAVE_ERROR(500, "新增商品失败"),*/
    REGISTER_ERROR(500, "用户名重复"),
    ;
    private int code;
    private String msg;
}
