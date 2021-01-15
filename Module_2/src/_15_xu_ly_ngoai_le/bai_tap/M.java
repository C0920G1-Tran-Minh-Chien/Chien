package _15_xu_ly_ngoai_le.bai_tap;

import java.io.IOException;

class M {
    void method() throws IOException {
        throw new IOException("Thiet bi");
    }
}

class TestThrows2 {
    public static void main(String args[]) throws IOException {
        M m = new M();
        m.method();
        System.out.println("Luong binh thuong...");
    }
}
