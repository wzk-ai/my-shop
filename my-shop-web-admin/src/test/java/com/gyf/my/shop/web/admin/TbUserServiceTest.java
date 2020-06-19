package com.gyf.my.shop.web.admin;

import com.gyf.my.shop.domain.TbUser;
import com.gyf.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        System.out.println(tbUsers);
    }

    @Test
    public void insertTest(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("gyf");
        tbUser.setPassword("123");
        tbUser.setPhone("13326361689");
        tbUser.setEmail("gyf@163.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.insert(tbUser);
    }

    @Test
    public void deleteTest(){
        tbUserService.delete(37L);
    }

    @Test
    public void getById(){
        TbUser byId = tbUserService.getById(36L);
        System.out.println(byId);
    }

    @Test
    public void updateTest(){
        TbUser byId = tbUserService.getById(38L);
        byId.setUsername("gyfaa");

        tbUserService.update(byId);
    }

    @Test
    public void selectByUsernameTest(){
        List<TbUser> uni = tbUserService.selectByUsername("uni");
        System.out.println(uni);

    }

    @Test
    public void getByEmailTest(){
        TbUser byEmail = tbUserService.login("gyf@163.com");
        System.out.println(byEmail);
    }

}
