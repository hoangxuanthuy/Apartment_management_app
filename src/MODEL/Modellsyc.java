/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author hoangxuanthuy
 */
public class Modellsyc {
    private String MAYC; // VARCHAR2(6)
    private String MABQL; // VARCHAR2(6)
    private String NoiDungXuLy; // VARCHAR2(100)
    private String ThoiGianXuLy; // DATE

    public Modellsyc(String MAYC, String MABQL, String NoiDungXuLy,String ThoiGianXuLy) {
        this.MAYC = MAYC;
        this.MABQL = MABQL;
        this.NoiDungXuLy = NoiDungXuLy;
        this.ThoiGianXuLy = ThoiGianXuLy;
    }

    public String getMAYC() {
        return MAYC;
    }

    public String getMABQL() {
        return MABQL;
    }

    public String getNoiDungXuLy() {
        return NoiDungXuLy;
    }

    public String getThoiGianXuLy() {
        if (ThoiGianXuLy == null) {
            return null;
        }
        try {
            // Định dạng đầu vào (thay đổi nếu định dạng của bạn khác)
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Chuyển đổi từ chuỗi định dạng đầu vào sang đối tượng Date
            Date date = inputFormat.parse(ThoiGianXuLy);

            // Chuyển đổi từ đối tượng Date sang chuỗi định dạng đầu ra
            return outputFormat.format(date);
        } catch (ParseException es) {
            return ThoiGianXuLy; // Hoặc bạn có thể trả về một giá trị mặc định hoặc chuỗi thông báo lỗi
        }
    }

    public void setMAYC(String MAYC) {
        this.MAYC = MAYC;
    }

    public void setMABQL(String MABQL) {
        this.MABQL = MABQL;
    }

    public void setNoiDungXuLy(String NoiDungXuLy) {
        this.NoiDungXuLy = NoiDungXuLy;
    }

    public void setThoiGianXuLy(String ThoiGianXuLy) {
        this.ThoiGianXuLy = ThoiGianXuLy;
    }

    @Override
    public String toString() {
        return "lsyc{" + "MAYC=" + MAYC + ", MABQL=" + MABQL + ", NoiDungXuLy=" + NoiDungXuLy + ", ThoiGianXuLy=" + ThoiGianXuLy + '}';
    }
    
}
