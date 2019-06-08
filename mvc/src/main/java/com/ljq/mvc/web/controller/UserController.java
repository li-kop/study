package com.ljq.mvc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ljq.mvc.dto.User;
import com.ljq.mvc.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LJQ
 * @date : 2019/6/6 18:18
 */
@RestController
public class UserController {
@GetMapping(value = "/user1")
@JsonView(User.SimpleView.class)
    public List<User> query1(@RequestParam(required = false) String userName){
        System.out.println(userName);
        List<User> users=new ArrayList<>(5);
        for (int i = 0; i <3 ; i++) {
            users.add(new User());
        }
        return users;
    }
    @GetMapping(value = "/user")
        public List<User> query(UserQueryCondition userCondition,@PageableDefault(page = 3,size = 12,sort = "name,desc") Pageable pageable){
        System.out.println(userCondition+"\t"+pageable);
        List<User> users=new ArrayList<>(5);
        for (int i = 0; i <3 ; i++) {
            users.add(new User());
        }
        return users;
    }

    /**
     *  加入正则校验
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id:\\d+}")
    @JsonView(User.DetailView.class)
    public User getInfo(@PathVariable String id){
        System.out.println("调用接口");
        //throw new UserNotExsitException(id);
    User user=new User();
    user.setUserName("LiGe");
    return user;
    }

}
