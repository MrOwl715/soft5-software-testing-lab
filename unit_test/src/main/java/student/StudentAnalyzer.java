package student;

import java.util.List;

public class StudentAnalyzer {

    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (Double score : scores) {
            // Validate: ignore score <0 and >10
            // FIX: Changed condition from (score < 0 && score > 10) to (score < 0 || score
            // > 10)
            if (score < 0 || score > 10) {
                continue;
            }

            // Logic: Excellent score >= 8.0
            if (score >= 8.0) {
                count++;
            }
        }
        return count;
    }

    public double calculateValidAverage(List<Double> scores) {
        // FIX: Changed condition from (scores == null && scores.isEmpty()) to (scores
        // == null || scores.isEmpty())
        // Although the original code was: if (scores == null && scores.isEmpty()) which
        // is safer to fix to ||
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;

        for (Double score : scores) {
            // Validate: count score between 0 and 10
            // FIX: Changed condition from (score >= 0 || score <= 10) to (score >= 0 &&
            // score <= 10)
            if (score >= 0 && score <= 10) {
                sum += score;
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }
}
