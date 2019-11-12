package com.zouyi.test.service.impl;

import com.zouyi.dynamicDataSource.annotation.DataSource;
import com.zouyi.dynamicDataSource.bean.DynamicDataSource;
import com.zouyi.test.config.DataSourceName;
import com.zouyi.test.dto.OrderDTO;
import com.zouyi.test.dto.UserOrderDTO;
import com.zouyi.test.dto.UserTDO;
import com.zouyi.test.mapper.TestMapper;
import com.zouyi.test.service.TestService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12 15:39
 * @Description:
 **/
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<UserTDO> test1() {
        return testMapper.test1();
    }

    @Override
    @DataSource(name = DataSourceName.TEST2)
    public List<OrderDTO> test2() {
        return testMapper.test2();
    }

    @Override
    public UserOrderDTO test3(Integer userId) {
        UserTDO userTDO = testMapper.test3(userId);
        String dataSource = DynamicDataSource.getDataSource();//get dataSource
        DynamicDataSource.setDataSource(DataSourceName.TEST2);//change dataSource
        OrderDTO orderDTO = testMapper.test4(userId);
        DynamicDataSource.setDataSource(dataSource);//recover dataSource
        UserOrderDTO userOrderDTO = new UserOrderDTO();
        BeanUtils.copyProperties(userTDO, userOrderDTO);
        userOrderDTO.setOrderNo(orderDTO.getOrderNo());
        return userOrderDTO;
    }
}
