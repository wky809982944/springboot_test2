package com.wangkaiyi.service;


import com.wangkaiyi.mapper.GoodsMapper;
import com.wangkaiyi.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GoodsServiceImpl {
    @Autowired
    private GoodsMapper goodsMapper;
    public Goods queryAllBypId(Long pid) {
        Goods goods = goodsMapper.selectByPrimaryKey(pid);
        return goods;
    }

    public List<Goods> queryAll() {
        List<Goods> list = goodsMapper.selectAll();
        return list;
    }

    public void updateById(Long pid, Long price, String name,String desc, Long cid, String path, Long stock) {
        Goods goods = new Goods();
        goods.setPid(pid);
        goods.setName(name);
        goods.setPrice(price);
        goods.setDesc(desc);
        goods.setCid(cid);
        goods.setPath(path);
        goods.setStock(stock);
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public void deleteById(Long pid) {
        goodsMapper.deleteByPrimaryKey(pid);
    }

    public List<Goods> searchByName(String name) {
        Example example = new Example(Goods.class);
        Example.Criteria  criteria = example.createCriteria();
        criteria.orLike("name","%" +name+"%");
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }

    public void insert(Long price, String name, String desc, Long cid, String path, Long stock) {
        Goods goods = new Goods();
        goods.setPrice(price);
        goods.setName(name);
        goods.setDesc(desc);
        goods.setCid(cid);
        goods.setPath(path);
        goods.setStock(stock);

        goodsMapper.insertSelective(goods);
    }
}
