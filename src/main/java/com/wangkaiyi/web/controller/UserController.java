package com.wangkaiyi.web.controller;

import com.wangkaiyi.mapper.UserMapper;
import com.wangkaiyi.model.User;
import com.wangkaiyi.service.MailService;
import com.wangkaiyi.service.UserServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@RestController //声明Rest风格的控制器
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MailService mailService;



    /*@PostMapping("/home.html")
    public String login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {
        if(userService.check(username, password)){
            return "true";
        }else {
            return "false";
        }
        *//*return "user/list";*//*
    }*/

    /*
        @RequestMapping(value="/login",method = { RequestMethod.POST, RequestMethod.GET })
        public  void login(HttpServletRequest request,HttpServletResponse response) {
            String username = request.getParameter("username");
            String password = request.getParameter("passoword");
            System.out.println(username);
            userService.check(username, password);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
           */
/* try {
            response.sendRedirect("../shop/home/home.html");
        } catch (IOException e) {
            e.printStackTrace();
        }*//*

     */
    /* return "forward:/index.action";*//*

        try {
            request.getRequestDispatcher("../shop/home/home.html").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/
    @PostMapping("/login")
    public String userLogin(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String passowrd = request.getParameter("password");
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", passowrd);
        if (userService.check(username, passowrd)) {
            return "yes";
        } else {
            return "error";
        }

    }

    @RequestMapping("/checkUser")
    public ResponseEntity<User> checkUser(HttpServletRequest request, HttpServletResponse response) {
        //编码规范
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //获取session值
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        User user = new User(username, password);
        return ResponseEntity.ok(user);
    }
    @RequestMapping("/getUser")
    public ResponseEntity<User> getUser(HttpServletRequest request, HttpServletResponse response) {
        //编码规范
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //获取session值
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.queryByName(username);
        return ResponseEntity.ok(user);
    }
    @RequestMapping("/selectAll")
    public ResponseEntity<List<User>> queryAll() {
        return ResponseEntity.ok(userService.queryAll());
    }


    @PostMapping("/save")
    @ResponseBody
    public String saveAll(
            @RequestParam(value = "name", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "gender", required = false) String gender) {
        userService.saveAll(username, password, gender);
        return "ok";
    }

    @GetMapping("/query/{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.queryById(id));
    }

    @PostMapping("/queryByName")
    public ResponseEntity<User> queryByName(
            @RequestParam(value = "username", required = true) String username
    ){
        return ResponseEntity.ok(userService.queryByName(username));
    }

    @PostMapping("/delete")

    public ResponseEntity<Void> deleteById(@RequestParam(value = "id", required = true) Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateById(
            @RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "gender", required = false) String gender
    ) {
        userService.updateById(id, username, password, gender);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/insert")
    @ResponseBody
    public String insert(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "gender", required = false) String gender
    ) {
        userService.insert(username, password, gender);
        return "ok";
    }
    @PostMapping(value = "/register")
    @ResponseBody
    public String register(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "email", required = false) String email) {
        String id = Long.toString(userService.register(username, password));
        //发送邮件
        String postEmail = "\"" + email + "\"";
        mailService.sendMail("823439163@qq.com", "主题：激活邮件", id);
        return "success";
    }

}
