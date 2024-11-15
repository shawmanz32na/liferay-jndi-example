/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jndi.example.service.impl;

import java.util.Date;

import com.liferay.jndi.example.model.Foo;
import com.liferay.jndi.example.service.base.FooLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Brian Wing Shun Chan
 */
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {

    public Foo addFoo(long userId, long groupId, String field1, boolean field2, int field3, Date field4, String field5, ServiceContext serviceContext) throws PortalException {
        // TODO: Validate the inputs as described at https://help.liferay.com/hc/en-us/articles/360017886892-Implementing-an-Add-Method

        User user = userLocalService.getUser(userId);

        long fooId = counterLocalService.increment(Foo.class.getName());
        Foo foo = fooPersistence.create(fooId);

        foo.setUuid(serviceContext.getUuid());
        foo.setGroupId(groupId);
        foo.setCompanyId(user.getCompanyId());
        foo.setUserId(user.getUserId());
        foo.setUserName(user.getFullName());
        // https://help.liferay.com/hc/en-us/articles/360017886892-Implementing-an-Add-Method doesn't demonstrate using these fields, which makes it unclear when/how to handle them ourselves or if they are handled automatically by Liferay
        // foo.setCreateDate(null);
        // foo.setModifiedDate(null);

        foo.setField1(field1);
        foo.setField2(field2);
        foo.setField3(field3);
        foo.setField4(field4);
        foo.setField5(field5);

        fooPersistence.update(foo);

        return foo;
    }

}