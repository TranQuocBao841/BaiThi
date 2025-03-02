import com.example.SanPham.tinhtong;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TongSoleTest {
    @Test
    void test(){
        tinhtong tinhtong = new tinhtong();
        assertEquals(9,tinhtong.TinhTong(5));
        assertEquals(25, tinhtong.TinhTong(10)); // 1 + 3 + 5 + 7 + 9 = 25
        assertEquals(1, tinhtong.TinhTong(1)); // 1
        assertEquals(0, tinhtong.TinhTong(0)); // Không có số lẻ nào
        assertEquals(0, tinhtong.TinhTong(-5)); // n âm → tổng = 0
    }
}
