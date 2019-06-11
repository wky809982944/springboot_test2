package com.wangkaiyi.web.controller;

import com.wangkaiyi.mapper.UserMapper;
import com.wangkaiyi.model.User;
import com.wangkaiyi.service.GoodsServiceImpl;
import com.wangkaiyi.service.Impl.MailServiceImpl;
import com.wangkaiyi.service.MailService;
import com.wangkaiyi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.zip.CheckedInputStream;

@Controller
public class Jump {
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MailServiceImpl mailService;
    @PostMapping("/shop/home/goods_search_name")
    public ModelAndView goods_search_name(
            String goods_search_name,
            Model model
    ) {
        model.addAttribute("goods_search_name", goods_search_name);
        return new ModelAndView("search","goods_search_name",model);
    }
    @RequestMapping("/shop/home/login")
    public String login(){
        return "/shop/home/login";
    }

    @PostMapping("/user/updateAddress")
    public String updateAddress(
            @RequestParam("id") Long id,
            @RequestParam("address") String address
    ) {
        System.out.println(address);
        userService.updateAddress(id, address);
        return "redirect:/shop/person/address.html";
    }
    @PostMapping("/user/updateUserInfo")
    public String updateUserInfo(String userGender,@RequestParam("userId")Long userId) {
        userService.updateGender(userGender,userId);
        return "redirect:/shop/person/information.html";
    }

    @PostMapping("/user/updateUserPassword")
    public String updateUserPassword(
            String userOldPassword,
            String userNewPassword,
            String userConfirmPassword,
            @RequestParam("userId") Long userId) {
        System.out.println(userConfirmPassword);
        System.out.println(userId);
        if (userConfirmPassword.equals(userNewPassword) && (!userOldPassword.equals(userNewPassword))) {
            userService.updatePassword(userId, userConfirmPassword);
        }
        return "redirect:/shop/person/index.html";
    }
    @RequestMapping(value = "/user/activation/{id}", method = RequestMethod.GET)
    public String activation(@PathVariable Long id,HttpServletRequest request) {
        userService.activation(id);
        User user = userService.queryById(id);
        request.getSession().setAttribute("username", user.getUsername());
        return "redirect:/shop/home/home.html";
    }

}
