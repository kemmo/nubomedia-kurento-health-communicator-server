// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.kurento.agenda.services.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kurento.agenda.datamodel.pojo.Group;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attributes
	@XmlElement(required = true)
	private Long id;

	@XmlElement(required = true)
	private String name;

	@XmlElement
	private String phone;

	@XmlElement
	private String phoneRegion;

	@XmlElement
	private Long picture;

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneRegion() {
		return phoneRegion;
	}

	public void setPhoneRegion(String phoneRegion) {
		this.phoneRegion = phoneRegion;
	}

	public Long getPicture() {
		return picture;
	}

	public void setPicture(Long picture) {
		this.picture = picture;
	}

	// //////////////////////////////////////
	// Format converters
	// //////////////////////////////////////

	public Group buildGroupPojo() {
		Group group = new Group();
		group.setId(this.id);
		group.setName(this.name);
		group.setPhone(this.phone);
		group.setPhoneRegion(this.phoneRegion);
		group.setPicture(this.picture);
		return group;
	}

}
