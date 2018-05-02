/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hv.controller;

import com.hv.dao.CustomerDAO;
import com.hv.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HoaiVu
 */
@Controller
public class AccountController {

    /**
     * Inject từ @Repository CustomerDAO
     */
    @Autowired
    private CustomerDAO dao;
    /**
     * GET: login.html
     */
    @RequestMapping(value = "dn", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("user", new Customer());
        return "dn";
    }

    /**
     * GET: login.html
     */
    @RequestMapping(value = "dn", method = RequestMethod.POST)
    public String login(ModelMap model, @ModelAttribute("user") Customer user) {
        try {
            Customer cust = dao.getById(user.getId());
            if (cust.getPasswords().equals(user.getPasswords())) {
                return "redirect:/demo";
            } else {
                model.addAttribute("loimk", "Sai mật khẩu !");
                return "dn";
            }

        } catch (Exception ex) {
            model.addAttribute("loi", "Tên đăng nhập không tồn tại");
        }
        return "dn";
    }

}
