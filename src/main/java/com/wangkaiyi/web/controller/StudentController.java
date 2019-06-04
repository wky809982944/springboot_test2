package com.wangkaiyi.web.controller;

import com.wangkaiyi.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @RestController 用于写api 给移动客户端提供数据
 * @Controller 写后端有页面
 */
@Controller//restful风格的控制器
@RequestMapping("stu")
public class StudentController {
    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("username","gyf");
        model.addAttribute("age",20);
        List<Student> stuList = new ArrayList<Student>();
        stuList.add(new Student(1001,"zhangsan","男"));
        stuList.add(new Student(1002,"lisi","男"));
        stuList.add(new Student(1003,"wangwu","男"));
        model.addAttribute("stuList",stuList);

        return "stu/list";//找模版页面
    }
}
