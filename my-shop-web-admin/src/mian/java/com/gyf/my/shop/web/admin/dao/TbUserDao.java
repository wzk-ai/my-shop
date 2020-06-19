package com.gyf.my.shop.web.admin.dao;

import com.gyf.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {

    public List<TbUser> selectAll();

    public void insert(TbUser tbUser);

    public void delete(Long id);

    TbUser getById(Long id);

    public void update(TbUser tbUser);

    List<TbUser> selectByUsername(String name);

    TbUser getByEmail(String email);

    //搜索
    List<TbUser> search(TbUser tbUser);
}
