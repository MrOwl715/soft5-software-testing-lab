package student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // --- TEST FOR: countExcellentStudents ---

    @Test
    public void testCountExcellentStudents_Normal() {
        // Case: Có điểm giỏi, điểm thường, điểm không hợp lệ
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 5.0, 11.0, -2.0);
        // Kỳ vọng: 2 (là 9.0 và 8.5) - 11.0 và -2.0 bị bỏ qua
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_Empty() {
        // Case: Danh sách rỗng
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_AllInvalid() {
        // Case: Toàn điểm sai
        List<Double> scores = Arrays.asList(-1.0, 15.0, 10.1);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_Boundary() {
        // Case: Điểm ngay mốc 8.0
        List<Double> scores = Arrays.asList(8.0, 7.99);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    // --- TEST FOR: calculateValidAverage ---

    @Test
    public void testCalculateValidAverage_Normal() {
        // Case: 8.0, 9.0, và 1 điểm sai (15.0 - bỏ qua)
        // Trung bình = (8 + 9) / 2 = 8.5
        List<Double> scores = Arrays.asList(8.0, 9.0, 15.0);
        assertEquals(8.5, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_Empty() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // Không có điểm nào hợp lệ để chia
        List<Double> scores = Arrays.asList(-5.0, 20.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }
}
