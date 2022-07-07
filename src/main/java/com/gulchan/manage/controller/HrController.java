package com.gulchan.manage.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gulchan.manage.entity.HrQueryVo;
import com.gulchan.manage.entity.HrViewVo;
import com.gulchan.manage.entity.JsonObject;
import com.gulchan.manage.entity.ResponseCode;
import com.gulchan.manage.pojo.Hr;
import com.gulchan.manage.service.HrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 求职联系人 前端控制器
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/hr")
@Api(tags="联系人管理")
public class HrController {


    @Autowired
    private HrService hrService;

    @RequestMapping(value="/saveHr",method = RequestMethod.POST)
    @ApiOperation(value="新增/修改联系人")
    public JsonObject<Hr> addHr(@RequestBody Hr hr){
        if(ObjectUtil.isNull(hr)){
            return new JsonObject<>("参数错误", ResponseCode.FAILURE,hr);
        }
        JsonObject<Hr> jsonObject = new JsonObject<>();
        boolean r = false;
        if(StrUtil.isBlankIfStr(hr.getId())){
            hr.setId(IdUtil.randomUUID());
            hr.setCreatetime(Optional.ofNullable(hr.getCreatetime()).orElse(DateUtil.date()));
            r = hrService.save(hr);
        }else{
            hr.setUpdatetime(DateUtil.date());
            r = hrService.updateById(hr);
        }
        jsonObject.setCode(r?ResponseCode.SUCCESS:ResponseCode.FAILURE);
        jsonObject.setMsg(r?"保存成功":"保存失败");
        jsonObject.setData(hr);
        return jsonObject;
    }

    @ApiOperation(value="根据唯一标识加载联系人信息")
    @RequestMapping(value="/getHr",method = RequestMethod.POST)
    public JsonObject<Hr> getHrById(@RequestParam(value="id",required = false) String id){
        if(StrUtil.isBlank(id)){
            return new JsonObject<>("参数错误",ResponseCode.FAILURE,new Hr(id));
        }
        Hr hr = this.hrService.getById(id);
        return new JsonObject<>("加载成功",ResponseCode.SUCCESS,hr);
    }


    @ApiOperation(value="根据条件加载联系人信息")
    @RequestMapping(value="/getHrs",method = RequestMethod.POST)
    public JsonObject<HrViewVo> getHrs(@RequestBody HrQueryVo hrQueryVo){
        HrViewVo hrViewVo = new HrViewVo();
        LambdaQueryWrapper<Hr> lambdaQueryWrapper  = new LambdaQueryWrapper<>();
        if(ObjectUtil.isNotNull(hrQueryVo) && StrUtil.isNotBlank(hrQueryVo.getName())){
            lambdaQueryWrapper.like(Hr::getName,hrQueryVo.getName());
        }
        List<Hr> hrs = this.hrService.list(lambdaQueryWrapper);
        hrViewVo.setHrs(hrs);
        return new JsonObject<>("成功加载",ResponseCode.SUCCESS,hrViewVo);
    }


    @ApiOperation(value="根据id删除联系人信息")
    @RequestMapping(value="/delHrs",method = RequestMethod.POST)
    public JsonObject<Object> delHrs(@RequestParam(value="ids",required = false) String [] ids){
        if(ArrayUtil.isEmpty(ids)){
            return new JsonObject<>("参数错误",ResponseCode.FAILURE,ids);
        }
        boolean f = this.hrService.removeByIds(Arrays.asList(ids));
        return new JsonObject<>(f?"删除成功":"删除失败",f?ResponseCode.SUCCESS:ResponseCode.FAILURE,ids);
    }
}

