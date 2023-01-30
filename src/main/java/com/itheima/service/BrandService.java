package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有的数据
     *
     * @return
     */
    List<Brand> selectAll();

    void add(Brand brand);

    /**
     * 根据id数组进行批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页展示的条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);


    /**
     * 根据id查询具体的数据
     *
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 更新已有的Brand
     *
     * @param brand
     */
    void update(Brand brand);


    /**
     * 根据id删除某条数据
     *
     * @param id
     */
    void deleteById(int id);
}
