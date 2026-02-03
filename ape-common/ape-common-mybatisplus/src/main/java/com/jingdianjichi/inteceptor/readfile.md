您提供的这段代码是一个用于 MyBatis 的 SQL 美化与性能监控拦截器。它的核心功能是在 SQL 语句执行前后进行拦截，将带有 ? 占位符的原始 SQL 替换为填充了实际参数的、格式化的完整 SQL，并记录 SQL 的执行耗时，最后打印输出，极大地方便了开发调试和性能监控。
下面我将对代码的各个部分进行详细解释：
1. 拦截器声明与核心方法

@Intercepts 注解：定义了该拦截器要拦截的目标。代码指定拦截 StatementHandler 接口的 query、update 和 batch 方法。StatementHandler 是 MyBatis 中直接与数据库交互、执行 SQL 语句的核心对象，拦截它意味着可以捕获所有类型的 SQL 操作（查询、更新、批量）。
intercept(Invocation invocation) 方法：这是拦截器的核心。它使用环绕通知（Around Advice）的模式：

记录 SQL 开始执行的时间 (startTime)。
调用 invocation.proceed() 让原始方法继续执行，即真正执行 SQL。
在 finally 块中，计算 SQL 执行耗时 (sqlCost)，并调用 formatSql 方法生成美化后的完整 SQL，最后通过 System.out.println 打印出来。

2. SQL 格式化逻辑 (formatSql 方法)
   这是代码中最复杂的部分，负责将 SELECT * FROM user WHERE id = ? 这样的 SQL 转换为 SELECT * FROM user WHERE id = 1。它根据传入的参数对象 (parameterObject) 类型进行不同的处理：

处理 StrictMap：StrictMap 是 MyBatis 内部类，常用于处理集合参数（如 IN 查询 WHERE id IN (?, ?, ?)）。handleListParameter 方法会遍历集合，依次替换 SQL 中的占位符 ?。
处理普通 Map：当参数是一个 Map 时（例如 @Param 注解传递的参数），handleMapParameter 方法会根据 Map 的 key（对应参数名）获取 value，并替换到 SQL 中。
处理自定义对象：当参数是一个普通的 JavaBean 时，handleCommonParameter 方法会通过反射获取该对象及其父类的所有字段，然后根据参数映射 (ParameterMapping) 中的属性名找到对应字段的值，进行替换。

参数值处理细节：在替换时，代码会判断参数值的类型。如果是字符串 (String)，会在值两边添加双引号（例如 "张三"）；如果是数字、布尔等基本类型或其包装类，则直接转换为字符串。
3. 辅助方法与插件集成

plugin(Object o) 方法：这是 MyBatis 拦截器规范的一部分。它通过 Plugin.wrap(o, this) 将当前拦截器包装到目标对象（这里是 StatementHandler）上，从而创建动态代理。这是 MyBatis 拦截器能够生效的关键，其内部基于 JDK 动态代理和责任链模式实现。
setProperties(Properties properties) 方法：允许通过 MyBatis 配置文件向拦截器传递参数，本例中未使用。
beautifySql 等方法：提供简单的 SQL 美化（压缩多余空白），并包含一些工具方法用于判断参数类型是否为基本类型、Map 或 List 等。

4. 优化与扩展建议（对比搜索结果）
   您提供的代码是一个基础且功能完整的实现。结合搜索结果，我们可以发现一些可以增强或优化的点：

使用专业的 SQL 格式化库：您的 beautifySql 方法仅压缩了空白。更佳实践是引入专业的 sql-formatter 库（如搜索结果所示），它可以对 SQL 进行关键字高亮、智能缩进、统一大小写等深度格式化，使输出更加清晰易读。
集成日志框架：直接使用 System.out.println 不利于日志管理和收集。应改为使用 SLF4J 或 Log4j2 等日志框架（如搜索结果中提到的），可以方便地控制日志级别（如开发环境开启 INFO，生产环境关闭）、输出到文件或日志系统。
更健壮的条件判断：代码中 if (sql == "" || sql.length() == 0) 判断空字符串的方式，建议改为 if (sql == null || sql.trim().isEmpty())，更为严谨。
配置化：可以参考搜索结果的实现，通过 Spring Boot 的 @ConditionalOnProperty 注解，实现拦截器的可配置化（例如在 application.yml 中通过 sql.beauty.enabled: true 来动态启用或禁用），增加灵活性。

总结
总而言之，您提供的 SqlBeautyInterceptor 是一个典型的 MyBatis 插件（拦截器），它巧妙地利用了 MyBatis 的插件机制，在 SQL 执行的生命周期中切入，实现了 SQL 语句的完整化、格式化输出以及执行时间监控 这一非常实用的开发调试功能。其原理是通过动态代理拦截 StatementHandler，在 intercept 方法中获取原始 SQL 和参数，并通过反射等手段将参数值填充到 SQL 中。在此基础上，可以借鉴业界实践，引入更专业的格式化工具和日志框架，使其更加强大和实用。