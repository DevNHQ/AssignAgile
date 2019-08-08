package androidagile.it.thanh.assignagile.model;

public class LuuKetQua {
    int id;
    String name;
    String monhoc;
    String diem;

    public LuuKetQua(int id, String name, String monhoc, String diem) {
        this.id = id;
        this.name = name;
        this.monhoc = monhoc;
        this.diem = diem;
    }

    public LuuKetQua() {

    }

    public LuuKetQua(String name, String monhoc, String diem) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}
