package com.gyf.my.shop.web.admin.service.impl;

import com.gyf.my.shop.commons.dto.BaseResult;
import com.gyf.my.shop.commons.utils.RegexpUtils;
import com.gyf.my.shop.domain.TbUser;
import com.gyf.my.shop.web.admin.dao.TbUserDao;
import com.gyf.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public void insert(TbUser tbUser) {
        tbUserDao.insert(tbUser);
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByUsername(String name) {
        return tbUserDao.selectByUsername(name);
    }

    @Override
    public TbUser login(String email,String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser!=null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后的
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    public TbUser login(String email) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        return tbUser;
    }

    /**
     * 新增修改
     * @param tbUser
     */
    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult=checkTbUser(tbUser);
        //通过验证
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());
            //新增
            if (tbUser.getId()==null){
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            //修改
            else {
                tbUserDao.insert(tbUser);
            }
            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }

    /**
     * 用户消息的有效验证
     * @param tbUser
     */
    public BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult = BaseResult.success();

       if (StringUtils.isBlank(tbUser.getEmail())){
            baseResult=BaseResult.fail("邮箱不能为空");
       }
       else if (!RegexpUtils.checkEmail(tbUser.getEmail())){
           baseResult=BaseResult.fail("邮箱格式不正确");
       }
       else if (StringUtils.isBlank(tbUser.getUsername())){
            baseResult=BaseResult.fail("用户名不能为空");
        }

       else if (StringUtils.isBlank(tbUser.getPhone())){
           baseResult=BaseResult.fail("手机号不能为空");
        }
       else if (!RegexpUtils.checkPhone(tbUser.getPhone())){
           baseResult=BaseResult.fail("手机号无效");
       }
       else if (StringUtils.isBlank(tbUser.getPassword())){
           baseResult=BaseResult.fail("密码不能为空");
       }
        return baseResult;
    }

    /**
     * 搜索功能
     * @param tbUser
     * @return
     */
    @Override
    public List<TbUser> search(TbUser tbUser) {
        List<TbUser> search = tbUserDao.search(tbUser);

        return search;
    }
}
