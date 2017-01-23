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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kurento.agenda.datamodel.pojo.Command;
import com.kurento.agenda.datamodel.pojo.Content;
import com.kurento.agenda.datamodel.pojo.KhcInvalidDataInfo.Code;
import com.kurento.agenda.datamodel.pojo.Timeline.State;
import com.kurento.khc.KhcException;
import com.kurento.khc.KhcInvalidDataException;
import com.kurento.khc.datamodel.ChannelEntity;
import com.kurento.khc.datamodel.TimelineEntity;
import com.kurento.khc.datamodel.UserEntity;

@Component(Command.METHOD_UPDATE_TIMELINE)
public class CmdUpdateTimeline extends AbstractCommand {

	@Autowired
	public void setAntecessor(CmdUpdateContact updateContact) {
		updateContact.registerInitChannelSuccessor(this);
	}

	@Override
	@Transactional
	public void exec(Command command, Boolean asServer) {
		throw new KhcInvalidDataException("Command not supported by server: "
				+ Command.METHOD_UPDATE_TIMELINE, Code.COMMAND_NOT_FOUND);
	}

	@Override
	public void exec(Command command, Content content, Boolean asServer) {
		exec(command, asServer);
	}

	@Override
	public void initializeChannel(ChannelEntity channel) {

		log.debug("Initialize channel: Update timelines");

		// Send an update for all enabled timelines of channel owner
		UserEntity user = notchDao.getUser(channel);
		for (TimelineEntity timeline : userDao.getUserTimelines(user)) {
			try {
				if (timeline.getState().equals(State.ENABLED)) {
					sendUpdateTimeline(channel, channel, timeline);
				}
			} catch (KhcException e) {
				log.warn(
						"Unable to synchronize timeline:" + timeline.getUUID(),
						e);
			}
		}

		// Call all successors
		for (AbstractCommand cmd : successors) {
			cmd.initializeChannel(channel);
		}
	}
}
