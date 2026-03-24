package session13.hw01;
/*
 * ================== PHẦN 1 - GIẢI THÍCH ==================
 *
 * Mặc định JDBC sử dụng chế độ Auto-Commit = TRUE
 *
 * => Nghĩa là:
 * Mỗi câu lệnh executeUpdate() sẽ được commit NGAY LẬP TỨC xuống DB
 *
 * Ví dụ code lỗi ban đầu:
 *
 * updateInventory.executeUpdate();  --> ĐÃ COMMIT
 * insertHistory.executeUpdate();    --> LỖI (mạng, SQL,...)
 *
 * => KẾT QUẢ:
 * - Kho đã bị trừ thuốc (KHÔNG rollback được)
 * - Không có lịch sử kê đơn
 *
 * => VI PHẠM TÍNH ATOMIC (Transaction phải ALL hoặc NOTHING)
 */
public class Main {
    public static void main(String[] args) {
        PrescriptionService service = new PrescriptionService();

        service.dispenseMedicine(1, 100);
    }
}
