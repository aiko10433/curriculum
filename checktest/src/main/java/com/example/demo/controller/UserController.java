package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.EntryRequest;
import com.example.demo.dto.UserUpdateRequest;
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
	@Autowired
	private UserService userService;
	
	/**
	 * マイページを表示
	 */
	@GetMapping("/mypage")
	public String displayList(Model model) {
		return "mypage";
	}
	
	@GetMapping(value = "/list")
	public String List(Model model) {
    List<UserEntity> list = userService.searchAll();
    model.addAttribute("list",list);
    return "list";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("/entry")
	public String displayAdd(Model model) {
		model.addAttribute("entryRequest", new EntryRequest());
		return "entry";
	}	
	
	@PostMapping(value="/create")
	public String create(@Validated @ModelAttribute EntryRequest entryRequest, BindingResult result,  Model model) {

		if(result.hasErrors()) {
			List<String> errorList= new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "entry";
		}
		userService.create(entryRequest);
		return "mypage";
	}

	/**
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/{id}/edit")
	public String displayEdit(@PathVariable Integer id, Model model) {
		UserEntity userEntity = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(userEntity.getId());
		userUpdateRequest.setName(userEntity.getName());
		userUpdateRequest.setAge(userEntity.getAge());
		userUpdateRequest.setPhone(userEntity.getPhone());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "edit";
	}

	/**
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@PostMapping(value="/update")
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "edit";
		}
		// ユーザー情報の更新
		userService.update(userUpdateRequest);
		return String.format("redirect:/list", userUpdateRequest.getId());
	}

	/**
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		// ユーザー情報の削除
		userService.delete(id);
		List<UserEntity> list = userService.searchAll();
	    model.addAttribute("list",list);
		return "list";
	}
}