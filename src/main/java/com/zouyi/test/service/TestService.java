package com.zouyi.test.service;

import com.zouyi.test.dto.OrderDTO;
import com.zouyi.test.dto.UserOrderDTO;
import com.zouyi.test.dto.UserTDO;

import java.util.List;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:
 **/
public interface TestService {
    List<UserTDO> test1();

    List<OrderDTO> test2();

    UserOrderDTO test3(Integer userId);
}
