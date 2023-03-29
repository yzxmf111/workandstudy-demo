package cn.xiaotian.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiaotian
 * @description Mybatis的使用过程和生命周期：
 *                  使用过程如下
 *                  生命周期：一般说的MyBatis生命周期就是这些组件的生命周期。SqlSessionFactoryBuilder、SqlSessionFactory、SqlSession、mapper
 *                      SqlSessionFactoryBuilder
 *                      一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的生命周期只存在于方法的内部。
 *                      SqlSessionFactory
 *                      SqlSessionFactory 是用来创建SqlSession的，相当于一个数据库连接池，每次创建SqlSessionFactory都会使用数据库资源，多次创建和销毁是对资源的浪费。所以SqlSessionFactory是应用级的生命周期，而且应该是单例的。
 *                      SqlSession
 *                      SqlSession相当于JDBC中的Connection，SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的生命周期是一次请求或一个方法。
 *                      Mapper
 *                      映射器是一些绑定映射语句的接口。映射器接口的实例是从 SqlSession 中获得的，它的生命周期在sqlsession事务方法之内，一般会控制在方法级。
 * @date 2023-03-28 15:29
 */
public class MybatisDemo {


    public static void main(String[] args) throws IOException {
        //1、创建SqlSessionFactory
        //可以从配置或者直接编码来创建SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2、通过SqlSessionFactory创建SqlSession
        //SqlSession（会话）可以理解为程序和数据库之间的桥梁
        SqlSession session = sqlSessionFactory.openSession();
        //3、通过sqlsession执行数据库操作
        //可以通过 SqlSession 实例来直接执行已映射的 SQL 语句：
        Blog blog = (Blog)session.selectOne("cn.xiaotian.mybatis.BlogMapper.selectBlog", 101);
        //更常用的方式是先获取Mapper(映射)，然后再执行SQL语句：
        //BlogMapper mapper = session.getMapper(BlogMapper.class);
        //Blog blog = mapper.selectBlog(101);
        //4、调用session.commit()提交事务：如果是更新、删除语句，我们还需要提交一下事务。
        //5、调用session.close()关闭会话
        session.close();
    }
}

