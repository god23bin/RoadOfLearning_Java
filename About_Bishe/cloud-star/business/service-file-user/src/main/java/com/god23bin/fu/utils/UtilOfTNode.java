package com.god23bin.fu.utils;

import com.god23bin.commonbase.exception.DiyException;
import com.god23bin.commonbase.entity.TNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UtilOfTNode {
    /**
     * 插入新结点
     * @param rootNode
     * @param parentId
     * @param newNode
     */
    public static void insert(TNode rootNode, long parentId, TNode newNode) {
        // 获取根结点的孩子结点集合
        List<TNode> list = rootNode.getChildrenList();
        // nodeNameList 结点名字集合
        List<String> nodeNameList = new ArrayList<>();
        // 先将原有的孩子结点的结点名 存储到 nodeNameList
        for (TNode tNode : list) {
            nodeNameList.add(tNode.getName());
        }
        // 后将需要新插入结点的名字存储到 nodeNameList
        nodeNameList.add(newNode.getName());
        System.out.println(nodeNameList);
        // 判断是否结点名是否重复
        HashSet<String> nodeNameSet = new HashSet<>(nodeNameList);
        // nodeNameList 的大小大于 nodeNameSet 的话，就说明有重复的结点名字
        if (nodeNameList.size() > nodeNameSet.size()) {
            System.out.println("结点名字不可重复");
            throw new DiyException(2021, "名字不可重复");
        }
        if (parentId == rootNode.getId()) {
            rootNode.getChildrenList().add(newNode);
            return;
        }
        //System.out.println(list.size());
        if (list.isEmpty()) {
            return;
        } else {
            for (TNode tNode : list) {
                if (nodeNameList.size() == nodeNameSet.size()) {
                    insert(tNode, parentId, newNode);
                }
            }
        }
    }

    public static void delete(TNode rootNode, long parentId, StringBuffer sb) {
        sb.append("/").append(rootNode.getName());
        List<TNode> list = rootNode.getChildrenList();
        if (list == null || list.isEmpty()) {
            return;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (parentId == list.get(i).getId()) {
                    list.remove(i);
                    delete(new TNode(), parentId, sb);
                    break;
                } else {
                    delete(list.get(i), parentId, sb);
                }
            }
        }
    }

    public static int update(TNode rootNode, long parentId, String folderName, int d) {
        //result = d;
        //System.out.println(result);
        if (rootNode.getId() == parentId) {
            rootNode.setName(folderName + "/");
            // System.out.println(d);
//            result = d; // 这是什么鬼？
            return d;
        }
        List<TNode> sonList = rootNode.getChildrenList();
        if (sonList == null || sonList.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < sonList.size(); i++) {
                //result++;
                update(sonList.get(i), parentId, folderName, d + 1);
            }
        }
        return 0;
    }
}
