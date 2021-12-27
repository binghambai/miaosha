package com.binghambai.customer.service;

import com.binghambai.customer.pojo.model.MallUser;
import com.binghambai.customer.pojo.request.Customer;
import com.binghambai.customer.pojo.request.CustomerLogin;
import com.binghambai.customer.pojo.response.LoginResponse;
import com.binghambai.customer.repository.CustomerRepository;
import com.mall.common.provider.Exception.SbcException;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Slf4j
public class CustomerInfoService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public BaseResponse createCustomer(Customer customer) {
        MallUser mallUser = new MallUser();
        mallUser.setUserName(customer.getCustomerName());
        mallUser.setUserPassword(customer.getCustomerPassword());
        mallUser.setUserPhone(customer.getCustomerPhone());

        boolean exists = customerRepository.existsByUserPhone(customer.getCustomerPhone());
        if (exists) {
            return BaseResponse.info(ErrorCode.SUCCESS, "已经存在");
        }
        try {
            customerRepository.save(mallUser);
        } catch (Exception e) {
            log.error("保存数据失败");
            return BaseResponse.error(ErrorCode.FAILED, "保存数据失败");
        }
        return BaseResponse.SUCCESSFUL();
    }

    public BaseResponse login(CustomerLogin customerLogin) {
        try {
            MallUser user = customerRepository.findByUserNameAndUserPassword(customerLogin.getUserName(), customerLogin.getPassword());
            if (Objects.isNull(user)) {
                log.error("账户名或密码错误");
                return BaseResponse.info(ErrorCode.LOGIN_FAILED, "账户名或密码错误");
            }

            return BaseResponse.success(new LoginResponse(user.getUserName(), user.getUserPic(),user.getUserPhone()));
        } catch (Exception e) {
            log.error("数据库操作失败");
            return BaseResponse.info(ErrorCode.EXC_DATABASE_ERROR, "数据库操作失败");
        }
    }

    public BaseResponse getUserInfoByPhone(String phone) {
        try {
            return BaseResponse.success(customerRepository.findByUserPhone(phone));
        } catch (Exception e) {
            log.error("数据库操作失败");
            return BaseResponse.error(ErrorCode.EXC_DATABASE_ERROR, "数据库操作失败");
        }
    }
}
