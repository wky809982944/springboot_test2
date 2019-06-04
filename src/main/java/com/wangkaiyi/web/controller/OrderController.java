package com.wangkaiyi.web.controller;

import com.wangkaiyi.model.Order;
import com.wangkaiyi.model.User;
import com.wangkaiyi.service.GoodsServiceImpl;
import com.wangkaiyi.service.OrderServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/createOrderSession")
    public ResponseEntity<Void> createOrder(
            @RequestParam(value = "user_id") Long user_id,
            @RequestParam(value = "goods_id") Long goods_id,
            @RequestParam(value = "goodscout") Long goodscout,
            @RequestParam(value = "totalprice") Long totalprice,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "status") Long status,
            HttpServletRequest request) {
        orderService.createOrder(user_id, goods_id, goodscout, totalprice, address, status);
        request.getSession().setAttribute("user_id", user_id);
        request.getSession().setAttribute("goods_id", goods_id);
        request.getSession().setAttribute("goodscout", goodscout);
        request.getSession().setAttribute("totalprice", totalprice);
        request.getSession().setAttribute("address", address);
        request.getSession().setAttribute("status", status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Void> createOrder(
            @RequestParam(value = "user_id") Long user_id,
            @RequestParam(value = "goods_id")Long goods_id,
            @RequestParam(value = "goodscout")Long goodscout,
            @RequestParam(value = "totalprice")Long totalprice,
            @RequestParam(value = "address")String address,
            @RequestParam(value = "status")Long status){
        orderService.createOrder(user_id, goods_id, goodscout, totalprice, address, status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
  /*  @PostMapping("/getOrderSession")
    public ResponseEntity<Order> createOrder(
            HttpServletRequest request){
        Long user_id = (Long) request.getSession().getAttribute("Long user_id");
        Long goods_id =(Long) request.getSession().getAttribute("goods_id");
        Long goodscout=(Long) request.getSession().getAttribute("goodscout");
        Long totalprice=(Long) request.getSession().getAttribute("totalprice");
        String address=(String)request.getSession().getAttribute("address");
        Long status = (Long) request.getSession().getAttribute("status");
        Order order = new Order(user_id,goods_id,goodscout,totalprice,address,status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }*/

    /*    @PostMapping("/createOrder")
        public ModelAndView createOrder(String username,
                                  @RequestParam("totalprice") Long totalprice,
                                  String useraddress,
                                  RedirectAttributes redirectAttributes) {
            User user = new User();
            user.setUsername(username);
            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("totalprice", totalprice);
            redirectAttributes.addFlashAttribute("useraddress", useraddress);
            redirectAttributes.addFlashAttribute("totalprice", user);
            System.out.println("输出user"+user);
            return "redirect:success.html";
        }*/
    /*@PostMapping("/createOrder")
    public ModelAndView createOrder(String username,
                                    @RequestParam("totalprice") Long totalprice,
                                    String useraddress,
                                    Model model) {
        User user = new User();
        user.setUsername(username);
        model.addAttribute("username", username);
        model.addAttribute("totalprice", totalprice);
        model.addAttribute("useraddress", useraddress);
        model.addAttribute("user", user);
        return new ModelAndView("success", "user", model);
    }*/

    @PostMapping("/queryByOid")
    public ResponseEntity<Order> queryByOid(@RequestParam("Oid") Long oid) {
        return ResponseEntity.ok(orderService.queryById(oid));
    }
    @PostMapping("/queryAll")
    public ResponseEntity<List<Order>> queryAll() {
        return ResponseEntity.ok(orderService.queryAll());
    }
    @PostMapping("/deleteByOid")
    public ResponseEntity<Void> deleteByOid(@RequestParam("Oid") Long oid) {
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
   @PostMapping("/update")
    public  ResponseEntity<Void> update(
           @RequestParam(value = "user_id") Long user_id,
           @RequestParam(value = "goods_id")Long goods_id,
           @RequestParam(value = "goodscout")Long goodscout,
           @RequestParam(value = "totalprice")Long totalprice,
           @RequestParam(value = "address")String address,
           @RequestParam(value = "status")Long status
   ) {
       orderService.update(user_id, goods_id, goodscout, totalprice, address, status);
       return ResponseEntity.status(HttpStatus.OK).build();
   }

}
