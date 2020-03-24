package com.allen.controller;

import com.allen.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把msg=美美存入到session域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了。。。");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") String id){
        System.out.println("执行了。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了。。。");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @param cookieValue
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了。。。");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }
    /**
     * 该方法先执行

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
     */
    /**
     * SessionAttributes注解
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes。。。");
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("testSessionAttributes。。。");
        String msg = (String)modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("testSessionAttributes。。。");
        status.setComplete();
        return "success";
    }
}
