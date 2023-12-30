package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
public class EntryRequest implements Serializable {


	@NotEmpty(message="名前を入力してください")
	private String name;

	@NotEmpty(message="年齢を入力してください")
	private String age;

	@NotEmpty(message="電話番号を入力してください")
	private String phone;
}