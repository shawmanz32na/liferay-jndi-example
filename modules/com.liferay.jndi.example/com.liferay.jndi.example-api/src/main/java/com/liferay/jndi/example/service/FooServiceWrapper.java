/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jndi.example.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FooService}.
 *
 * @author Brian Wing Shun Chan
 * @see FooService
 * @generated
 */
public class FooServiceWrapper
	implements FooService, ServiceWrapper<FooService> {

	public FooServiceWrapper(FooService fooService) {
		_fooService = fooService;
	}

	@Override
	public com.liferay.jndi.example.model.Foo addFoo(
			long groupId, String field1, boolean field2, int field3,
			java.util.Date field4, String field5,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fooService.addFoo(
			groupId, field1, field2, field3, field4, field5, serviceContext);
	}

	@Override
	public com.liferay.jndi.example.model.Foo getFoo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fooService.getFoo(id);
	}

	@Override
	public java.util.List<com.liferay.jndi.example.model.Foo> getFoos()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fooService.getFoos();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fooService.getOSGiServiceIdentifier();
	}

	@Override
	public FooService getWrappedService() {
		return _fooService;
	}

	@Override
	public void setWrappedService(FooService fooService) {
		_fooService = fooService;
	}

	private FooService _fooService;

}