package com.gyf.my.shop.web.admin.service;

import com.gyf.my.shop.commons.dto.BaseResult;
import com.gyf.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {

    public List<TbUser> selectAll();

    public void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String name);

    /**
     * 登录查询
     * @param email 邮箱
     * @return
     */
    TbUser login(String email,String password);

    TbUser login(String email);

    /**
     * 新增修改
     * @param tbUser
     */
    BaseResult save(TbUser tbUser);

    BaseResult checkTbUser(TbUser tbUser);

    List<TbUser> search(TbUser tbUser);
}
