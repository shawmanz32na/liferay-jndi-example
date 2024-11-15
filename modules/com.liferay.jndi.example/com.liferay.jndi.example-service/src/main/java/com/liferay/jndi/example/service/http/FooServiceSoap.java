/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jndi.example.service.http;

import com.liferay.jndi.example.service.FooServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>FooServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.jndi.example.model.FooSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.jndi.example.model.Foo</code>, that is translated to a
 * <code>com.liferay.jndi.example.model.FooSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooServiceHttp
 * @generated
 */
public class FooServiceSoap {

	public static com.liferay.jndi.example.model.FooSoap getFoo(long id)
		throws RemoteException {

		try {
			com.liferay.jndi.example.model.Foo returnValue =
				FooServiceUtil.getFoo(id);

			return com.liferay.jndi.example.model.FooSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.jndi.example.model.FooSoap[] getFoos()
		throws RemoteException {

		try {
			java.util.List<com.liferay.jndi.example.model.Foo> returnValue =
				FooServiceUtil.getFoos();

			return com.liferay.jndi.example.model.FooSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.jndi.example.model.FooSoap addFoo(
			long groupId, String field1, boolean field2, int field3,
			java.util.Date field4, String field5,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.jndi.example.model.Foo returnValue =
				FooServiceUtil.addFoo(
					groupId, field1, field2, field3, field4, field5,
					serviceContext);

			return com.liferay.jndi.example.model.FooSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FooServiceSoap.class);

}