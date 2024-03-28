package bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Date: 2021/12/23 8:13 下午
 * UserBo
 * Describe：
 */
@ApiModel(value = "用户对象BO", description = "从客户端，由用户传入的数据封装在此entity中")
public class UserBo {
    @ApiModelProperty(value = "用户名", name = "username", example = "imooc", required = true)
    private  String username;
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private  String password;

    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "123456", required = true)
    private  String confirmPassword;


    @ApiModelProperty(value = "用户昵称", name = "nickname", example = "不填则随机", required = false)
    private  String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }




    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}
