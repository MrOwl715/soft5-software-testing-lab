package student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // ==========================================
    // PHẦN 1: TEST HÀM countExcellentStudents
    // ==========================================

    // --- EP Partition: Invalid Input ( < 0 or > 10 ) ---
    @Test
    public void testCountExcellentStudents_Partition_Invalid() {
        // EP: Đảm bảo vùng giá trị sai hoàn toàn không được đếm
        List<Double> scores = Arrays.asList(-1.0, 10.1, -100.0, 15.5);
        assertEquals(0, analyzer.countExcellentStudents(scores), "Invalid scores partition should return 0");
    }

    // --- EP Partition: Valid - Not Excellent ( 0 <= x < 8 ) ---
    @Test
    public void testCountExcellentStudents_Partition_ValidNotExcellent() {
        // EP: Đảm bảo vùng hợp lệ nhưng không giỏi không được đếm
        List<Double> scores = Arrays.asList(0.0, 5.5, 7.9, 7.999);
        assertEquals(0, analyzer.countExcellentStudents(scores), "Valid non-excellent partition should return 0");
    }

    // --- EP Partition: Valid - Excellent ( 8 <= x <= 10 ) ---
    @Test
    public void testCountExcellentStudents_Partition_ValidExcellent() {
        // EP: Đảm bảo vùng giỏi được đếm chính xác
        List<Double> scores = Arrays.asList(8.0, 8.1, 9.5, 10.0);
        assertEquals(4, analyzer.countExcellentStudents(scores), "Excellent partition should count all items");
    }

    // --- Mixed Scenarios (Integration of partitions) ---
    @Test
    public void testCountExcellentStudents_MixedPartitions() {
        // Kịch bản thực tế: Trộn lẫn các vùng
        List<Double> scores = Arrays.asList(9.0, 5.0, 11.0, -2.0, 8.0);
        // Kỳ vọng: 9.0 (Yes), 5.0 (No), 11.0 (No), -2.0 (No), 8.0 (Yes) -> Total 2
        assertEquals(2, analyzer.countExcellentStudents(scores), "Mixed partition logic failed");
    }

    // --- Edge Cases (Null/Empty) ---
    @Test
    public void testCountExcellentStudents_EdgeCases() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    // ==========================================
    // PHẦN 2: TEST HÀM calculateValidAverage
    // ==========================================

    @Test
    public void testCalculateValidAverage_Normal() {
        // Case: Tính trung bình các điểm hợp lệ
        // Valid: 8.0, 9.0
        // Invalid: 15.0 (Bỏ qua)
        // TB = (8.0 + 9.0) / 2 = 8.5
        List<Double> scores = Arrays.asList(8.0, 9.0, 15.0);
        assertEquals(8.5, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_Boundary_Zero() {
        // Case: Điểm biên 0.0 (Hợp lệ)
        // TB = (0.0 + 0.0) / 2 = 0.0
        List<Double> scores = Arrays.asList(0.0, 0.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // Case: Không có điểm nào hợp lệ để chia
        List<Double> scores = Arrays.asList(-5.0, 20.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_NullOrEmpty() {
        // Case: Rỗng
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);

        // Case: Null
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }
}