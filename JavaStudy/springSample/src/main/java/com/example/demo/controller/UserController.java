package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
  /**
   * ユーザー情報 Service
   */
  //2行追加
	@Autowired
	private UserService userService;
  /**
   * ユーザー情報一覧画面を表示
   * @param  model Model
   * @return  ユーザー情報一覧画面のHTML
   */
  @RequestMapping(value = "/user/list",method = RequestMethod.GET)
	public String displayList(Model model) {

    List<UserEntity> list = userService.searchAll();
    model.addAttribute("userlist",list);
    return "user/list";



  }
}