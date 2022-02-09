package com.god23bin.fu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.god23bin.fu.entity.TNode;
import com.god23bin.fu.entity.User;
import com.god23bin.fu.mapper.UserMapper;
import com.god23bin.fu.service.UserService;
import com.god23bin.fu.utils.UtilOfTNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FUApplicationTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void testMapperSelectAll() {
        System.out.println("Mapper-------查询全部-------selectAll");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testMapperInsert() {
        System.out.println("Mapper-------插入记录-------insert");
        User user = new User();
        // 没有设置id，会有主键生成策略，保证id唯一
        user.setNickname("Kobe");
        user.setPassword("1234");
        // 插入时会自动填充设置好的字段
        int insert = userMapper.insert(user);
        if (insert >= 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testMapperDelete() {
        System.out.println("Mapper-------删除记录---根据id删除-------deleteById");
        // 如果实体主键id是Long型这种的，那么后面需要加个L
        // 由于这里实体主键id是String类型，所以直接用字符串
        int i = userMapper.deleteById("1485966454716178433");
        if (i >= 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testServiceSave() {
        System.out.println("Service-------插入记录-------save");
        User user = new User();
        // 没有设置id，会有主键生成策略，保证id唯一
        user.setNickname("Kobe");
        user.setPassword("1234");
        // 插入时会自动填充设置好的字段
        boolean save = userService.save(user);
        if (save) {
            System.out.println("插入成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testServiceRemove() {
        System.out.println("Service-------删除记录---根据id删除-------removeById");
        // 如果实体主键id是Long型这种的，那么后面需要加个L
        // 由于这里实体主键id是String类型，所以直接用字符串
        boolean b = userService.removeById("1485995435641303041");
        if (b) {
            System.out.println("删除成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void testServiceGet() {
        System.out.println("Service-------Get 查询---根据id获取实体类-------getById");
        User user = userService.getById("1");
        System.out.println(user);

        System.out.println("Service-------Get 查询---根据wrapper获取实体类-------getByOne");
        QueryWrapper<User> w1 = new QueryWrapper<>();
        w1.eq("nickname", "god23bin");
        User one = userService.getOne(w1);
        System.out.println(one);

        System.out.println("Service-------List 查询");
        System.out.println("Service-------List 查询--------wrapper为null，查全部");
        List<User> list = userService.list(null);
        System.out.println(list);

        System.out.println("Service-------List 查询--------wrapper为模糊查询");
        QueryWrapper<User> w2 = new QueryWrapper<>();
        w2.like("phone_number", "1");
        List<User> list1 = userService.list(w2);
        System.out.println(list1);


    }


    @Test
    public void testTNode() {
        // 原始结点
        TNode curTNode = new TNode();
        curTNode.setId(1L);
        curTNode.setName("root/");
        curTNode.setParentId(0L);
        curTNode.setChildrenList(new ArrayList<>());

        // 新结点，需要插入的新结点
        TNode node_1 = new TNode();
        node_1.setName("node-1");
        node_1.setParentId(curTNode.getId());
        node_1.setChildrenList(new ArrayList<>());
        UtilOfTNode.insert(curTNode, curTNode.getId(), node_1);

        TNode node_1_1 = new TNode();
        node_1_1.setName("node-1/node-1-1");
        node_1_1.setParentId(curTNode.getId());
        node_1_1.setChildrenList(new ArrayList<>());
        UtilOfTNode.insert(curTNode, node_1.getId(), node_1_1);

        TNode node_2 = new TNode();
        node_2.setName("node-2");
        node_2.setParentId(curTNode.getId());
        node_2.setChildrenList(new ArrayList<>());
        UtilOfTNode.insert(curTNode, curTNode.getId(), node_2);

        TNode node_2_1 = new TNode();
        node_2_1.setName("node-2/node-2-1");
        node_2_1.setParentId(curTNode.getId());
        node_2_1.setChildrenList(new ArrayList<>());
        UtilOfTNode.insert(curTNode, node_2.getId(), node_2_1);

        System.out.println(curTNode);
        UtilOfTNode.delete(curTNode, node_2.getId(), new StringBuffer());
        System.out.println(curTNode);

    }
}
