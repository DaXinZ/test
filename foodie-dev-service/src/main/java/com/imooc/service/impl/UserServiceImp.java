package com.imooc.service.impl;




import bo.UserBo;
import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;

import com.imooc.mapper.UsersMapperCustom;
import com.imooc.pojo.Users;

import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.UserService;

import com.imooc.utils.*;
import io.swagger.annotations.ApiOperation;
import javafx.scene.control.PasswordFieldBuilder;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

import static com.imooc.utils.MD5Utils.getMD5Str;

/**
 * Date: 2021/9/27 10:43 上午
 * StuService
 * Describe：
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Sid sid;

    @Autowired
    private UsersMapperCustom usersMapperCustom;

    public static  final String  user_face = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201901%2F22%2F20190122075852_qqpst.thumb.400_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637226059&t=44137c685590cefc784c8426b088c54f";

    /**
     *
     * @param username
     * @return  查询用户名是否重复
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }

    /**
     *
     * @param nickname
     * @return  查询用户呢称是否重复
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernikenameIsExist(String nickname) {

        Example likeuserExample = new Example(Users.class);
        Example.Criteria userCriteria = likeuserExample.createCriteria();

        userCriteria.andEqualTo("nickname", nickname);
        Users result = usersMapper.selectOneByExample(likeuserExample);

        return result == null ? false : true;
    }


    /**
     *
     * @param userBO
     * @return 注册接口
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBo userBO) {
        RandomNickname randomNickname = new RandomNickname();

        String  userId =  sid.nextShort();

        Users user = new Users();
        //设置默认id
        user.setId(userId);
        //设置登录名称
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户昵称随机生成

        user.setNickname(randomNickname.RandomScale());
        //设置默认头像
        user.setFace(user_face);
        //设置默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        //设置默认性别
        user.setSex(Sex.secret.type);
        //创建时间
        user.setCreatedTime(new Date());
        //更新时间
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    /**
     *
     * @param username
     * @param password
     * @return 登录接口
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username,String password){


        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);
        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }

    /**
     *
     * @param id
     * @return  查询用户名是否重复
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUserIdIsExist(String id) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("id", id);
        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? true : false;
    }

    /**
     *
     * @param id
     * @return  查询用户信息
     */

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UsersVO> queryUsers(String id) {

        return usersMapperCustom.queryUsers(id);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UsersVO> queryUsername(String nickname){
        return usersMapperCustom.queryUsername(nickname);
    }



}
