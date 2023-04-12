import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class CreateDatabase extends SQLiteOpenHelper {

    public static String TBL_NHANVIEN = "NHANVIEN";
    public static String TBL_MON = "MON";
    public static String TBL_LOAIMON = "LOAIMON";
    public static String TBL_BAN = "BAN";
    public static String TBL_DONDAT = "DONDAT";
    public static String TBL_CHITIETDONDAT = "CHITIETDONDAT";
    public static String TBL_QUYEN = "QUYEN";

    //Bảng nhân viên
    public static String TBL_NHANVIEN_MANV = "MANV";
    public static String TBL_NHANVIEN_HOTENNV = "HOTENNV";
    public static String TBL_NHANVIEN_TENDN = "TENDN";
    public static String TBL_NHANVIEN_MATKHAU = "MATKHAU";
    public static String TBL_NHANVIEN_EMAIL = "EMAIL";
    public static String TBL_NHANVIEN_SDT = "SDT";
    public static String TBL_NHANVIEN_GIOITINH = "GIOITINH";
    public static String TBL_NHANVIEN_NGAYSINH = "NGAYSINH";
    public static String TBL_NHANVIEN_MAQUYEN= "MAQUYEN";

    //Bảng quyền
    public static String TBL_QUYEN_MAQUYEN = "MAQUYEN";
    public static String TBL_QUYEN_TENQUYEN = "TENQUYEN";

    //Bảng món
    public static String TBL_MON_MAMON = "MAMON";
    public static String TBL_MON_TENMON = "TENMON";
    public static String TBL_MON_GIATIEN = "GIATIEN";
    public static String TBL_MON_TINHTRANG = "TINHTRANG";
    public static String TBL_MON_HINHANH = "HINHANH";
    public static String TBL_MON_MALOAI = "MALOAI";

    //Bảng loại món
    public static String TBL_LOAIMON_MALOAI = "MALOAI";
    public static String TBL_LOAIMON_TENLOAI = "TENLOAI";
    public static String TBL_LOAIMON_HINHANH = "HINHANH";

    //Bảng bàn
    public static String TBL_BAN_MABAN = "MABAN";
    public static String TBL_BAN_TENBAN = "TENBAN";
    public static String TBL_BAN_TINHTRANG = "TINHTRANG";

    //Bảng đơn đặt
    public static String TBL_DONDAT_MADONDAT = "MADONDAT";
    public static String TBL_DONDAT_MANV = "MANV";
    public static String TBL_DONDAT_NGAYDAT = "NGAYDAT";
    public static String TBL_DONDAT_TINHTRANG = "TINHTRANG";
    public static String TBL_DONDAT_TONGTIEN = "TONGTIEN";
    public static String TBL_DONDAT_MABAN = "MABAN";

    //Bảng chi tiết đơn đặt
    public static String TBL_CHITIETDONDAT_MADONDAT = "MADONDAT";
    public static String TBL_CHITIETDONDAT_MAMON = "MAMON";
    public static String TBL_CHITIETDONDAT_SOLUONG = "SOLUONG";


    public CreateDatabase(Context context) {
        super(context, "OrderDrink", null, 1);
    }


}
