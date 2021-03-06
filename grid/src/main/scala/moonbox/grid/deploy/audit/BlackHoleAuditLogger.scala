/*-
 * <<
 * Moonbox
 * ==
 * Copyright (C) 2016 - 2019 EDP
 * ==
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
 * >>
 */

package moonbox.grid.deploy.audit
import moonbox.common.MbLogging
import moonbox.grid.deploy.ConnectionInfo



class BlackHoleAuditLogger extends AuditLogger with MbLogging {

	override def log(user: String, action: String, param: Map[String, String])
		(implicit connectionInfo: ConnectionInfo): Unit = {
		logInfo(s"$user | $action | $param")
	}

	override def log(user: Option[String], action: String, param: Map[String, String])
		(implicit connectionInfo: ConnectionInfo): Unit = {
		logInfo(s"${user.getOrElse("Illegal user")} | $action | $param | $connectionInfo")
	}

	override def log(user: Option[String], action: String)(implicit connectionInfo: ConnectionInfo): Unit = {
		logInfo(s"${user.getOrElse("Illegal user")} | $action | ${Map()} | $connectionInfo")
	}

	override def log(user: String, action: String)(implicit connectionInfo: ConnectionInfo): Unit = {
		logInfo(s"$user | $action | ${Map()} | $connectionInfo")
	}
}
