package com.wangkaiyi.service;

import com.wangkaiyi.mapper.OrderMapper;
import com.wangkaiyi.mapper.UserMapper;
import com.wangkaiyi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderMapper orderMapper;
    public void createOrder(Long user_id, Long goods_id, Long goodscout, Long totalprice, String address, Long status) {
        Order order = new Order();
        order.setUser_id(user_id);
        order.setGoods_id(goods_id);
        order.setGoodscount(goodscout);
        order.setTotalprice(totalprice);
        order.setAddress(address);
        order.setStatus(status);
        orderMapper.insertSelective(order);
    }

    public Order queryById(Long oid) {
        return orderMapper.selectByPrimaryKey(oid);
    }

    public void deleteByOid(Long oid) {
        orderMapper.deleteByPrimaryKey(oid);
    }

    public void update(Long user_id, Long goods_id, Long goodscout, Long totalprice, String address, Long status) {
        Order order = new Order(user_id, goods_id, goodscout, totalprice, address, status);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public List<Order> queryAll() {
        List<Order> list = orderMapper.selectAll();
        return list;
    }
}
