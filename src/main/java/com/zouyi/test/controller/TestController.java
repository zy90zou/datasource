package com.zouyi.test.controller;

import com.zouyi.test.api.APIResult;
import com.zouyi.test.api.APIResultUtil;
import com.zouyi.test.dto.OrderDTO;
import com.zouyi.test.dto.UserOrderDTO;
import com.zouyi.test.dto.UserTDO;
import com.zouyi.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test1")//测试获取数据库1数据
    public APIResult<List<UserTDO>> test1() {
        List<UserTDO> list = testService.test1();
        return APIResultUtil.success(list);
    }

    @GetMapping("/test2")//测试获取数据库2数据
    public APIResult<List<OrderDTO>> test2() {
        List<OrderDTO> list = testService.test2();
        return APIResultUtil.success(list);
    }

    @GetMapping("/test3/{userId}")//同时获取两个数据库数据
    public APIResult<UserOrderDTO> test3(@PathVariable(value = "userId") Integer userId) {
        UserOrderDTO userOrderDTO = testService.test3(userId);
        return APIResultUtil.success(userOrderDTO);
    }
}
