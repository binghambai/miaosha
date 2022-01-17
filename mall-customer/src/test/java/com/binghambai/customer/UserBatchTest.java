package com.binghambai.customer;

import com.binghambai.customer.service.UserCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBatchTest {

    @Autowired
    UserCartService userCartService;

    @Test
    public void testSelect() {

    }
}
