/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jndi.example.service;

import com.liferay.jndi.example.model.Foo;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Foo. This utility wraps
 * <code>com.liferay.jndi.example.service.impl.FooServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FooService
 * @generated
 */
public class FooServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.jndi.example.service.impl.FooServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Foo addFoo(
			long groupId, String field1, boolean field2, int field3,
			java.util.Date field4, String field5,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addFoo(
			groupId, field1, field2, field3, field4, field5, serviceContext);
	}

	public static Foo getFoo(long id) throws PortalException {
		return getService().getFoo(id);
	}

	public static List<Foo> getFoos() throws PortalException {
		return getService().getFoos();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FooService getService() {
		return _service;
	}

	public static void setService(FooService service) {
		_service = service;
	}

	private static volatile FooService _service;

}