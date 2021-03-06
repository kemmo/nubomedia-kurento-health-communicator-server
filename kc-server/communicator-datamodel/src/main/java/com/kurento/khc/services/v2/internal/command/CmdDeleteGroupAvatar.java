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

package com.kurento.khc.services.v2.internal.command;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kurento.agenda.datamodel.pojo.Command;
import com.kurento.agenda.datamodel.pojo.Content;
import com.kurento.agenda.datamodel.pojo.Group;
import com.kurento.agenda.services.pojo.GroupInfo;
import com.kurento.khc.datamodel.ChannelEntity;
import com.kurento.khc.datamodel.GroupEntity;

@Component(Command.METHOD_DELETE_GROUP_AVATAR)
public class CmdDeleteGroupAvatar extends AbstractCommand {

	@Override
	@Transactional
	public void exec(Command command, Boolean asServer) {

		// Parse params
		Group groupParam = parseParam(command, GroupInfo.class)
				.buildGroupPojo();
		ChannelEntity invoker = asServer ? null : getInvoker(command
				.getChannelId());
		GroupEntity group;
		group = groupDao.findGroupByUUID(groupParam.getId());
		if (asServer) {
			groupDao.setPicture(group, null);
		} else {
			groupSecureDao.setPicture(group, null);
		}

		sendDeleteGroupAvatar(invoker, group);

	}

	@Override
	@Transactional
	public void exec(Command command, Content content, Boolean asServer) {
		exec(command, asServer);
	}

}
