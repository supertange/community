## 马匠社区

## 资料 
[Spring 文档](https://spring.io/guides)

[elasticsearch](http://elasticsearch.cn/explore)

[webjar引入bootstrap](https://www.baeldung.com/maven-webjars)

[GitHub develop key](https://github.com/supertange/community/settings/keys)

[github oauth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[thymeleaf文档](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#a-multi-language-welcome)

[Spring文档](https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/web.html)

[spring-boot文档](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
## 工具
[Visual Paradigm](https://www.visual-paradigm.com)
[flywaydb migration](https://flywaydb.org)
[lombok](https://projectlombok.org)
## 脚本
```sql
create table USER
(
    ID INT  auto_increment primary key not null,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN CHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);

comment on table USER is '用户';
```
```bash
mvn flyway:migrate
```
启动mybatis Generator
```bash
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
