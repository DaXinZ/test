package bo;

/**
 * Date: 2021/12/23 8:13 下午
 * UserBo
 * Describe：
 */
public class UserBo {
    private  String username;
    private  String password;
    private  String cofirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCofirmPassword(String cofirmPassword) {
        this.cofirmPassword = cofirmPassword;
    }

    public String getPassword() {
        return password;
    }
    public String getCofirmPassword() {
        return cofirmPassword;
    }
}
