# OSSRH-93452 web4j
##### [介绍] web4j 包含了很多javaweb开发过程中常用的高性能易用的封装

##### 工具类：$

- 字符串相关(均返回新的字符串)

  - `$.format(String oldStr, Object... placeholder)` 字符串占位(%s)替换

  - `$.concatUnSafe(String... targetStr)`  字符串拼接(线程不安全)

  - `$.concatSafe(String... targetStr)`  字符串拼接(线程安全)

  - `$.appendPrefix(String oldStr, String prefix)`  字符串添加前缀

  - `$.appendSuffix(String oldStr, String suffix)`  字符串添加后缀

  - `$.repeat(String oldStr, int cnt)`  字符串额外重复?次

- 实体相关(均返回新的实体)

  - `$.copy(S source, Class<T> target)` 把source实体属性深拷贝到target实体，并返回新的实体
  - `$.copyList(List<S> sourceList, Class<T> target)` 把sourceList所有实体属性深拷贝到target实体，并返回新的实体列表

##### 统一的返回值

- R 统一的返回实体
- RCode 统一返回实体内的消息和消息码

##### 统一的业务异常封装

- BizException 统一的业务异常
