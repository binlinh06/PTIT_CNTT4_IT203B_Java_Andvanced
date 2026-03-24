package session13.hw02;
//1. Transaction bị "treo" (dangling transaction)
//Khi setAutoCommit(false)
//DB đang ở trạng thái transaction mở
//Nếu xảy ra lỗi:
//KHÔNG commit
//nhưng cũng KHÔNG rollback
//
//➡=> Transaction vẫn chưa kết thúc
public class Main {
    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();

        // Test thanh toán
        int patientId = 1;
        int invoiceId = 1;
        double amount = 500.0;

        paymentService.payInvoice(patientId, invoiceId, amount);
    }
}
