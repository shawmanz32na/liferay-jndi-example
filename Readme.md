# Liferay JNDI Example

This repository shows how to use an external JNDI datasource in Liferay 7.4 GA125.

It is completely self-contained.

## Steps to Build

So it is all pretty darn simple, the following steps should take care of everything:

```bash
$ blade gw initBundle
$ blade server start
$ cd modules/com.liferay.jndi.example/com.liferay.jndi.example.api && blade gw clean deploy
$ cd modules/com.liferay.jndi.example/com.liferay.jndi.example.service && blade gw clean deploy
```

After the modules have deployed, the service is ready to use the external database. I used the groovy script
presented in the next section to test the service.
## Testing Script

This is the groovy script that I used to test the service:

```groovy
import com.liferay.jndi.example.service.*;
import com.liferay.jndi.example.model.*;
import java.util.*;
import com.liferay.portal.kernel.service.*;

try {
  Foo foo = FooLocalServiceUtil.createFoo(1);

  ServiceContext sc = ServiceContextThreadLocal.getServiceContext();

  foo.setCompanyId(sc.getCompanyId());
  foo.setGroupId(sc.getScopeGroupId());
  foo.setUserId(sc.getUserId());
  foo.setCreateDate(new Date());
  foo.setModifiedDate(new Date());

  foo.setField1("Testing");

  Foo foo2 = FooLocalServiceUtil.addFoo(foo);

  List<Foo> foos = FooLocalServiceUtil.getFoos(-1,-1);

  out.println("Have " + foos.size() + " foos");

  for (Foo x : foos) {
    out.println(x);
  }

  out.println("done");
} catch (Exception e) {
  out.println(e.getMessage());
  e.printStackTrace(out);
}
```

## Key Points

- The `extdbDataSource` is defined in the `service.xml` file and tied to each entity in the file.
- The `ExtdbDataSourceProviderImpl` is the implementation of the `DataSourceProvider` interface that is used to 
  create the datasource.
- Tomcat has the JNDI configuration in the `server.xml` and `context.xml` files.
- portal-ext.properties has the properties for the external database.

Granted this is not a production-ready solution by any means, but it shows how to access an external database.
After all, it is using HSQL as the database for Liferay as well as for the external database.

But it does show that JNDI can work with Service Builder and external databases in Liferay.
