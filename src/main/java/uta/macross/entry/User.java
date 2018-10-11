package uta.macross.entry;

public class User {
    private String dbid;
    private String username;
    private String password;
    private Long is_show;
    private String realname;
    private String birthday;
    private int sex;
    private String minzu;
    private String xueli;
    private String hunyin;
    private String bumen;
    private String sfz;
    private String ah;
    private String address;
    private String tel;

    public User() {
    }

    public User(String dbid, String username, String password, Long is_show) {
        this.dbid = dbid;
        this.username = username;
        this.password = password;
        this.is_show = is_show;
    }

    public User(String dbid, String username, String password, Long is_show, String realname, String birthday, int sex, String minzu, String xueli, String hunyin, String bumen, String sfz, String ah, String address, String tel) {
        this.dbid = dbid;
        this.username = username;
        this.password = password;
        this.is_show = is_show;
        this.realname = realname;
        this.birthday = birthday;
        this.sex = sex;
        this.minzu = minzu;
        this.xueli = xueli;
        this.hunyin = hunyin;
        this.bumen = bumen;
        this.sfz = sfz;
        this.ah = ah;
        this.address = address;
        this.tel = tel;
    }

    public String getDbid() {
        return dbid;
    }

    public void setDbid(String dbid) {
        this.dbid = dbid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIs_show() {
        return is_show;
    }

    public void setIs_show(Long is_show) {
        this.is_show = is_show;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getHunyin() {
        return hunyin;
    }

    public void setHunyin(String hunyin) {
        this.hunyin = hunyin;
    }

    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



    @Override
    public String toString() {
        return "User{" +
                "dbid='" + dbid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", is_show=" + is_show +
                '}';
    }

    public String all2String() {
        return "User{" +
                "dbid='" + dbid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", is_show=" + is_show +
                ", realname='" + realname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex=" + sex +
                ", minzu='" + minzu + '\'' +
                ", xueli='" + xueli + '\'' +
                ", hunyin='" + hunyin + '\'' +
                ", bumen='" + bumen + '\'' +
                ", sfz='" + sfz + '\'' +
                ", ah='" + ah + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

}
