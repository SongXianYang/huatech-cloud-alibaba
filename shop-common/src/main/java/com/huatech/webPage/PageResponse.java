package com.huatech.webPage;




import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//分页
@Data
public class PageResponse<T> implements Serializable {
    private static final long serialVersionUID = 768549219446295665L;
    /**
     * /总条数
     */
    private Integer total;
    /**
     * 当前页显示数据
      */
    private List<T> records;
    /**
     * map 的一个集合
     */
    private  Map<Object,Object> Maptotal;
    private Map<T,T> Ttotal;

    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
}
