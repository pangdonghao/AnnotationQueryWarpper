# AnnotationQueryWarpper

#### 介绍
AnnotationQueryWarper是一个mybatis plus的扩展
可通过注解方式生成QueryWarper

[demo地址](https://gitee.com/ayezs/annotation-query-warpper-demo)


#### 使用说明
1. 引用方式： 

```xml
        <dependency>
            <groupId>com.gitee.ayezs</groupId>
            <artifactId>AnnotationQueryWrapper</artifactId>
            <version>1.0.0</version>
        </dependency>
```

2. 在条件中加上 在querywapper中需要调用的方法对应的注解,如：

   ```java
   
   @Data
   public class User implements Serializable {
   
       private static final long serialVersionUID = 1L;
   
       @TableId(value = "id", type = IdType.AUTO)
       private Integer id;
       @Like
       private String name;
       @Ge
       private Integer age;
       @Eq
       private Integer sex;
   
   }
   ```

   意思是，模糊查询name， 大于等于age， sex=sex

   注意：在生成sql时，属性名默认会转驼峰，若想自定义字段名可使用 @TableField("")注解指定

   若想直接使用属性名作为查询字段可在属性上加上 @RemainUnchanged注解， 此时如果使用 @TableField，@RemainUnchanged将不会生效

3. 使用：

   使用时非常简单，直接在创建QueryWrapper时使用AnnotationQueryWrapper创建就可以了

   ```java
   @Service
   public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
       public void test(){
           User user1 = new User();
           user1.setName("的");
           user1.setSex(1);
           user1.setAge(23);
           QueryWrapper<User> queryWrapper = new AnnotationQueryWrapper<>(user1);
           for (User user : baseMapper.selectList(queryWrapper)) {
               System.out.println(user);
           }
       }
   }	
   ```

   

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


