package com.god23bin.commonbase.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="目录树结点", description="")
public class TNode {
    private long id;
    private String name;
    private long parentId;
    private static int idCounter = 0;
    private List<TNode> childrenList;
}
