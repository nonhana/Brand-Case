package com.itheima.pojo;

import java.util.List;


/**
 * 此处的<T>表示泛型，因为不知道PageBean会用来查询哪种对象的分页。
 *
 * @param <T>
 */
public class PageBean<T> {
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> row;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> row) {
        this.totalCount = totalCount;
        this.row = row;
    }

    /**
     * 获取
     *
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置
     *
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取
     *
     * @return row
     */
    public List<T> getRow() {
        return row;
    }

    /**
     * 设置
     *
     * @param row
     */
    public void setRow(List<T> row) {
        this.row = row;
    }

    public String toString() {
        return "PageBean{totalCount = " + totalCount + ", row = " + row + "}";
    }
}
