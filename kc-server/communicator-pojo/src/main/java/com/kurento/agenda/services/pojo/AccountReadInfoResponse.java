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

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountReadInfoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attributes

	@XmlElement(required = true)
	private Long id;

	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private Long serverTime;

	@XmlElement(required = true)
	private Boolean userAutoregister;

	@XmlElement(required = true)
	private Boolean groupAutoregister;

	// Getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getServerTime() {
		return this.serverTime;
	}

	public void setServerTime(Long serverTime) {
		this.serverTime = serverTime;
	}

	public Boolean getUserAutoregister() {
		return userAutoregister;
	}

	public void setUserAutoregister(Boolean userAutoregister) {
		this.userAutoregister = userAutoregister;
	}

	public Boolean getGroupAutoregister() {
		return groupAutoregister;
	}

	public void setGroupAutoregister(Boolean groupAutoregister) {
		this.groupAutoregister = groupAutoregister;
	}

}
