package com.zhangyu.server.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyu.server.dto.MyUserDto;
import com.zhangyu.server.mapper.UserAnnotationMapper;
import com.zhangyu.server.domain.MyUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.course.server.dto.PageDto;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class MyUserService {

    @Resource
    private UserAnnotationMapper userAnnotationMapper;

    public MyUser selectUserById(Long id) {
        return userAnnotationMapper.selectUserById(id);
    }

    /**
     * 做一个转换 并且分页传出结果
     */
    public void selectUserDtoById(Long id, PageDto<MyUserDto> pageDto) {
        //会先做查询总条数，然后再分页
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());//从第一页开始，找一条， 然后遇到的第一个Mapper 执行SQL插入limit分页
        MyUser myUser = userAnnotationMapper.selectUserById(id);

        MyUserDto myUserDto = new MyUserDto();

        BeanUtils.copyProperties(myUser, myUserDto);
        //假设查出来是List
        //假设这个是结果
        List<MyUserDto> list = new ArrayList<>();
        PageInfo<MyUserDto> info = new PageInfo<>(list);
//        pageDto.setTotal(list.size()); OR
       pageDto.setTotal(info.getTotal());
       pageDto.setList(list);//处理后的结果

//        return pageDto; 最终返回这个
    }
}