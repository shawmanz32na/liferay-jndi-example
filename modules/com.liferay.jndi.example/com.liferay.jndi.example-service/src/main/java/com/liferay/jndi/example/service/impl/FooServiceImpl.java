/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jndi.example.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.jndi.example.model.Foo;
import com.liferay.jndi.example.service.base.FooServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Brian Wing Shun Chan
 */
public class FooServiceImpl extends FooServiceBaseImpl {

    public Foo getFoo(long id) throws PortalException {

        // https://help.liferay.com/hc/en-us/articles/360018166311-Creating-Remote-Services suggests checking permissions here, but isn't clear enough about how to actually do so
        // ModelResourcePermissionHelper.check(_journalFolderModelResourcePermission, getPermissionChecker(), groupId, folderId, ActionKeys.ADD_ARTICLE);

        return fooLocalService.getFoo(id);
    }

    public List<Foo> getFoos() throws PortalException {
        return fooLocalService.getFoos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public Foo addFoo(long groupId, String field1, boolean field2, int field3, Date field4, String field5, ServiceContext serviceContext) throws PortalException {
        // Service Builder examples, e.g. https://help.liferay.com/hc/en-us/articles/360017886892-Implementing-an-Add-Method , do not show how to get the userId nor the serviceContext to provide to LocalService calls, so we're just winging it here.
        User user = getUser();
        return fooLocalService.addFoo(user.getUserId(), groupId, field1, field2, field3, field4, field5, serviceContext);
    }

}