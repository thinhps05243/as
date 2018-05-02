/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hv.controller;

import com.hv.dao.DemoDAO;
import com.hv.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HoaiVu
 */
@Controller
@RequestMapping(value = "demo")
public class DemoController {

    /**
     * Inject từ @Repository ForumDAO
     */
    @Autowired
    private DemoDAO dao;

    /**
     * GET|POST: crud.html
     */
    @RequestMapping()
    public String initiate(ModelMap model) {
        model.addAttribute("stu", new Demo());
        model.addAttribute("stus", dao.getAll());
        return "demo";
    }

    /**
     * POST: crud.html?insert
     */
    @RequestMapping(params = "insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("stu") Demo stu, ModelMap model) {

        try {
            dao.insert(stu);
            return initiate(model);
        } catch (Exception ex) {
            model.addAttribute("errors", "Id đã tồn tại");
            return initiate(model);
        }

    }

    /**
     * POST: crud.html?update
     */
    @RequestMapping(params = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("stu") Demo stu, ModelMap model) {
        dao.update(stu);
        model.addAttribute("stus", dao.getAll());
        return initiate(model);
    }
    
    @RequestMapping(params = "find", method = RequestMethod.POST)
    public String find(@ModelAttribute("name1") String name,ModelMap model) {
        model.addAttribute("stus", dao.getByName(name));
       
        return "demo";
    }

    /**
     * GET|POST: crud.html?delete
     */
    @RequestMapping(params = "delete")
    public String delete(@RequestParam("id") Integer id, ModelMap model) {
        dao.delete(id);
        return initiate(model);
    }

    /**
     * GET: crud.html?edit
     */
    @RequestMapping(params = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") Integer id, ModelMap model) {
        Demo f = dao.getById(id);
        model.addAttribute("stu", f);
        model.addAttribute("stus", dao.getAll());       
        return "demo";
    }
    
    
}
