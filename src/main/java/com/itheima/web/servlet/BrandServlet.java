package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")// 接收所有/brand开头的路径
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.调用service查询
        List<Brand> brands = brandService.selectAll();
        //2.转为JSON
        String jsonString = JSON.toJSONString(brands);
        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收品牌的数据
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.add(brand);
        //响应成功标识
        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收传过来的id数组
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //转成int类型的数组
        int[] ids = JSON.parseObject(params, int[].class);
        //调用brandService进行删除
        brandService.deleteByIds(ids);
        //删除成功，进行返回响应
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收当前页码和每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //调用service查询
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);
        //2.转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);
        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收当前页码和每页展示条数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取查询条件对象
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用service查询
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        //2.转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);
        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收要查询的brand id
        int id = Integer.parseInt(request.getParameter("id"));
        //1.调用service查询
        Brand brand = brandService.selectById(id);
        //2.转为JSON
        String jsonString = JSON.toJSONString(brand);
        //3.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收修改的Brand对象
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //将接收的JSON字符串转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用service的update方法，进行update
        brandService.update(brand);
        //响应成功标识
        response.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取要删除的数据id
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        //调用service的delete方法删除数据
        brandService.deleteById(id);
        //响应成功标识
        response.getWriter().write("success");
    }
}
