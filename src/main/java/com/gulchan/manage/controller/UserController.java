package com.gulchan.manage.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gulchan.manage.entity.JsonObject;
import com.gulchan.manage.entity.ResponseCode;
import com.gulchan.manage.entity.UserQueryVo;
import com.gulchan.manage.entity.UserViewVo;
import com.gulchan.manage.pojo.User;
import com.gulchan.manage.service.UserService;
import com.gulchan.manage.service.UserServiceByJpa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Api(tags="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * by mybatis
     */
    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceByJpa userServiceByJpa;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value="/saveUser",method = RequestMethod.POST)
    @ApiOperation(value="新增/修改用户")
    public JsonObject<User> addUser(@RequestBody User user){
        if(ObjectUtil.isNull(user)){
            return new JsonObject<>("参数错误", ResponseCode.FAILURE,user);
        }
        JsonObject<User> jsonObject = new JsonObject<>();
        boolean r = false;
        if(StrUtil.isBlankIfStr(user.getId())){
            user.setId(IdUtil.randomUUID());
            user.setCreatetime(Optional.ofNullable(user.getCreatetime()).orElse(DateUtil.date()));
            r = userService.save(user);
        }else{
            user.setUpdatetime(DateUtil.date());
            r = userService.updateById(user);
        }
        jsonObject.setCode(r?ResponseCode.SUCCESS:ResponseCode.FAILURE);
        jsonObject.setMsg(r?"保存成功":"保存失败");
        jsonObject.setData(user);
        return jsonObject;
    }

    @ApiOperation(value="根据唯一标识加载用户信息")
    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    public JsonObject<User> getUserById(@RequestParam(value="id",required = false) String id){
        if(StrUtil.isBlank(id)){
            return new JsonObject<>("参数错误",ResponseCode.FAILURE,new User(id));
        }
        // 先从缓存中加载
        User user = null;
        Object obj = redisTemplate.opsForValue().get(id);
        if(Objects.nonNull(obj) && obj instanceof User){
            user  = (User)obj;
        }else {
            user = this.userService.getById(id);
        }
        return new JsonObject<>("加载成功",ResponseCode.SUCCESS,user);
    }


    @ApiOperation(value="根据条件加载用户信息")
    @RequestMapping(value="/getUsers",method = RequestMethod.POST)
    public JsonObject<UserViewVo> getUsers(@RequestBody UserQueryVo userQueryVo){
        UserViewVo userViewVo = new UserViewVo();
        LambdaQueryWrapper<User> lambdaQueryWrapper  = new LambdaQueryWrapper<>();
        if(ObjectUtil.isNotNull(userQueryVo) && StrUtil.isNotBlank(userQueryVo.getName())){
            lambdaQueryWrapper.like(User::getName,userQueryVo.getName());
        }
        List<User> userList = this.userService.list(lambdaQueryWrapper);
        userViewVo.setUsers(userList);
        return new JsonObject<>("成功加载",ResponseCode.SUCCESS,userViewVo);
    }


    @ApiOperation(value="根据id删除用户信息")
    @RequestMapping(value="/delUsers",method = RequestMethod.POST)
    public JsonObject<Object> delUsers(@RequestParam(value="ids",required = false) String [] ids){
        if(ArrayUtil.isEmpty(ids)){
            return new JsonObject<>("参数错误",ResponseCode.FAILURE,ids);
        }
        boolean f = this.userService.removeByIds(Arrays.asList(ids));
        return new JsonObject<>(f?"删除成功":"删除失败",f?ResponseCode.SUCCESS:ResponseCode.FAILURE,ids);
    }


    @ApiOperation(value="根据条件加载用户信息，使用jpa访问库")
    @RequestMapping(value="/getUsersByJpa",method = RequestMethod.POST)
    public JsonObject<UserViewVo> getUsersByJpa(@RequestBody UserQueryVo userQueryVo){
        UserViewVo userViewVo = new UserViewVo();
        List<User> userList = null;
        if(ObjectUtil.isNotNull(userQueryVo) && StrUtil.isNotBlank(userQueryVo.getName())){
            userList = userServiceByJpa.findByNameLike(userQueryVo.getName());
        }else{
            userList = userServiceByJpa.findByName(userQueryVo.getName());
        }
        userViewVo.setUsers(userList);
        return new JsonObject<>("成功加载",ResponseCode.SUCCESS,userViewVo);
    }


}

