package bean;

public class AdminInfo {
    private int aid;
    private String acc;
    private String pwd;

    public AdminInfo() {
    }
    public AdminInfo(String acc, String pwd) {
        this.acc = acc;
        this.pwd = pwd;
    }
    public AdminInfo(int aid, String acc, String pwd) {
        this.aid = aid;
        this.acc = acc;
        this.pwd = pwd;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    @Override
    public String toString() {
        return "AdminInfo{" +
                "aid=" + aid +
                ", acc='" + acc + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
