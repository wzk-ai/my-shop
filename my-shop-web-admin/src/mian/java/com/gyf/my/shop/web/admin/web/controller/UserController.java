package com.gyf.my.shop.web.admin.web.controller;

import com.gyf.my.shop.commons.dto.BaseResult;
import com.gyf.my.shop.domain.TbUser;
import com.gyf.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ModelAttribute
    public  TbUser getTbUser(Long id){
        TbUser tbUser=null;

        if (tbUser!=null){
            tbUser=tbUserService.getById(id);
        }
        else{
            tbUser = new TbUser();
        }
        return tbUser;
    }




    /**
     * 跳转到用户列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUser",tbUsers);
        return "user_list";
    }

    /**
     * 跳转到用户表单页
     * @return
     */
    @RequestMapping(value = "from",method = RequestMethod.GET)
    public String from(){
        return "user_from";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser,Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbUserService.save(tbUser);
       //保存成功
        if (baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return "user_from";
        }

    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(Model model,TbUser tbUser){
        System.out.println(tbUser);
        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUser",tbUsers);
        return "user_list";
    }

}
