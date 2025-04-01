/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author hoangxuanthuy
 */
public class Modelyeucaucd {
    // Member variables
    private String MAYC;
    private String LoaiYC;
    private String NoiDungYC;
    private String TrangThaiYC;
    private String MACD;

    public Modelyeucaucd(String MAYC, String LoaiYC, String NoiDungYC, String TrangThaiYC, String MACD) {
        this.MAYC = MAYC;
        this.LoaiYC = LoaiYC;
        this.NoiDungYC = NoiDungYC;
        this.TrangThaiYC = TrangThaiYC;
        this.MACD = MACD;
    }
    
    public Modelyeucaucd() {
        this.MAYC = "";
        this.LoaiYC = "";
        this.NoiDungYC = "";
        this.TrangThaiYC = "";
        this.MACD = "";
    }

    public String getMAYC() {
        return MAYC;
    }

    public String getLoaiYC() {
        return LoaiYC;
    }

    public String getNoiDungYC() {
        return NoiDungYC;
    }

    public String getTrangThaiYC() {
        return TrangThaiYC;
    }

    public String getMACD() {
        return MACD;
    }

    public void setMAYC(String MAYC) {
        this.MAYC = MAYC;
    }

    public void setLoaiYC(String LoaiYC) {
        this.LoaiYC = LoaiYC;
    }

    public void setNoiDungYC(String NoiDungYC) {
        this.NoiDungYC = NoiDungYC;
    }

    public void setTrangThaiYC(String TrangThaiYC) {
        this.TrangThaiYC = TrangThaiYC;
    }

    public void setMACD(String MACD) {
        this.MACD = MACD;
    }

    @Override
    public String toString() {
        return "Modelyeucaucd{" + "MAYC=" + MAYC + ", LoaiYC=" + LoaiYC + ", NoiDungYC=" + NoiDungYC + ", TrangThaiYC=" + TrangThaiYC + ", MACD=" + MACD + '}';
    }
    
    
    
        
}
