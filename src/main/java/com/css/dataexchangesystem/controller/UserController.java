package com.css.dataexchangesystem.controller;


import com.css.dataexchangesystem.entity.User;
import com.css.dataexchangesystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @Description:
* @Param:
* @return:
* @Author: mxc
* @Date: 2019/11/13
* @Version：1.0
*/
@RestController
@RequestMapping("/testBoot")
@Api(value="用户controller",tags={"用户操作接口"})
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping(value = "getUser/{userId}",method = {RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "获取用户信息", notes = "通过用户ID获取用户信息")
    @ApiImplicitParam(paramType ="path",name= "userId" ,value = "用户名",dataType = "int")
    /*@ApiImplicitParam中的参数说明：
    dataType="int" 代表请求参数类型为int类型，当然也可以是Map、User、String等；
    paramType="body" 代表参数应该放在请求的什么地方：
               header-->放在请求头。请求参数的获取：@RequestHeader(代码中接收注解)
               query-->用于get请求的参数拼接。请求参数的获取：@RequestParam(代码中接收注解)
               path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
               body-->放在请求体。请求参数的获取：@RequestBody(代码中接收注解)*/
    public String GetUser(@PathVariable int userId){
        try{
            return userService.Sel(userId).toString();
        }catch (NullPointerException e){
            return "userId为"+userId+"的用户不存在，请确认后重试";
        }
}



    @RequestMapping(value = "getUserList",method = {RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表(select *)")
    public List getUserList(){
        return userService.getUserList();
    }


    @RequestMapping(value = "testRedis",method = {RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "RedisTemplateService测试", notes = "Redis存储对象")
    public void teRedis(){
        List<User> userList = userService.getUserList();
        redisTemplate.opsForValue().set("1",userList);
        redisTemplate.opsForList().leftPushAll("userList",userList);
        //stringRedisTemplate.opsForValue().set("name","mxc", Duration.ofMinutes(1));
    }
}
