package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EntryRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public UserEntity findById(Integer id) {
		return userRepository.getOne(id);
	}
	
	public List<UserEntity> searchAll() {
		return userRepository.findAll();
	}
	
	public void create(EntryRequest entryRequest) {
		UserEntity user = new UserEntity();
		user.setName(entryRequest.getName());
		user.setAge(entryRequest.getAge());
		user.setPhone(entryRequest.getPhone());
		userRepository.save(user);
	}

	/**
	 * ユーザー情報 更新
	 * @param user ユーザー情報
	 */
	public void update(UserUpdateRequest userUpdateRequest) {
		UserEntity user = findById(userUpdateRequest.getId());
		user.setName(userUpdateRequest.getName());
		user.setAge(userUpdateRequest.getAge());
		user.setPhone(userUpdateRequest.getPhone());
		userRepository.save(user);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		UserEntity userEntity = findById(id);
		userRepository.delete(userEntity);
	}
}