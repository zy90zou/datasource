package com.zouyi.test.mapper;

import com.zouyi.test.dto.OrderDTO;
import com.zouyi.test.dto.UserTDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<UserTDO> test1();

    List<OrderDTO> test2();

    UserTDO test3(Integer userId);

    OrderDTO test4(Integer userId);

}
