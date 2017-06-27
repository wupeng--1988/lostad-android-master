/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// FIXME: review and cleanup

package com.lostad.app.demo.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.io.Serializable;

@Table(name = "UserInfo")
public class UserInfo implements Serializable {
	/**
	 *
	 */
	@Column(name = "id", isId = true)
	public String id;
	@Column(name="name")
	public String name;
	@Column(name="nickname")
	public String nickname;
	@Column(name="pwd")
	public String pwd;
	@Column(name="headUrl")
	public String headUrl;
	@Column(name="phone")
	public String phone;
	@Column(name="phoneType")
	public String phoneType;
	// 贝壳数目
	@Column(name="loginType")
	public String loginType="0" ;//0:表示跑伴登录1:表示QQ登录2:微信登录3:新浪微博登录
	@Column(name="uid3")
	public String uid3;//第三方登录 ｉｄ
	@Column(name="sex")
	public String sex;
	@Column(name="token")
	public String token;// 用于推送
	@Column(name="longitude")
	public Double longitude;
	@Column(name="latitude")
	public Double latitude;

	public UserInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUid3() {
		return uid3;
	}

	public void setUid3(String uid3) {
		this.uid3 = uid3;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
