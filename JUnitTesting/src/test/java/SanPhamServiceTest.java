import com.example.SanPham.SanPham;
import com.example.SanPham.SanPhamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SanPhamServiceTest {
    private SanPhamService sanPhamService;

    @BeforeEach
    public void upset() {
        sanPhamService = new SanPhamService();
        sanPhamService.themSanPham(new SanPham("sp3", "may tinh", 3, 20, 20, "Dien tu"));
    }


    @Test
    void testThemSanPham() {
        SanPham sp = new SanPham("SP001", "Laptop", 2, 1500.5f, 10, "Điện tử");
        sanPhamService.themSanPham(sp);
        assertEquals(2, sanPhamService.getDanhSachSanPham().size());
    }

    @Test
    void testXoaSanPham() {
        SanPham sp = new SanPham("SP002", "Điện thoại", 1, 500.0f, 5, "Điện tử");
        sanPhamService.themSanPham(sp);
        assertTrue(sanPhamService.xoaSanPham("SP002"));
        assertFalse(sanPhamService.xoaSanPham("SP999")); // Mã không tồn tại
    }

    @Test
    void testKiemTraMaTonTai() {
        SanPham sp = new SanPham("SP003", "Máy ảnh", 3, 700.0f, 3, "Máy ảnh");
        sanPhamService.themSanPham(sp);
        assertTrue(sanPhamService.kiemTraMaTonTai("SP003"));
        assertFalse(sanPhamService.kiemTraMaTonTai("SP999")); // Mã không tồn tại
    }

    @Test
    void testSuasanPham() {
        boolean ketqua = sanPhamService.suaSanPham("sp3", "may tinh1", 30, 30);
        assertTrue(ketqua, "cập nhật thất bại");
        SanPham sp = sanPhamService.getDanhSachSanPham().get(0);
        assertEquals("may tinh1", sp.getTen(), "Tên sản phẩm không đúng");
        assertEquals(30, sp.getGia(), "Giá sản phẩm không đúng");
        assertEquals(30, sp.getSoLuong(), "Số lượng sản phẩm không đúng");


        System.out.println("danh sách vừa cập nhât:");
        sanPhamService.getDanhSachSanPham().forEach(sanPham ->
                System.out.println(sanPham.getMa() + " - " + sanPham.getTen() + " - " + sanPham.getGia() + " - " + sanPham.getSoLuong())
        );
    }

    @Test
    void testSuaSanPhamTenRong() {
        boolean ketqua = sanPhamService.suaSanPham("sp3", "", 30, 30);
        assertFalse(ketqua, "Tên sản phẩm không được để trống");
    }
}
