package bean;

public class UserInfo {
    private int uid;
    private String acc;
    private String pwd;
    private String phone;
    private String email;

    public UserInfo() {
    }

    public UserInfo(int uid, String acc, String pwd, String phone, String email) {
        this.uid = uid;
        this.acc = acc;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
    }
    public UserInfo(String acc, String pwd){
        this.acc = acc;
        this.pwd = pwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", acc='" + acc + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
