# 🧪 SOFT5 - Software Testing Lab
### CMC University

> **Student:** Dinh Tran Nguyen
> **ID:** BIT230292 
> **Instructor:** Truong Anh Hoang

## 📂 Bài tập Làm quen Can't Unsee
<b>Jan 5th 2026<b/>
<p>Cant's See Practition Test</p>

<img width="433" height="341" alt="image" src="https://github.com/user-attachments/assets/91ee5020-5f77-451c-b2aa-1c02c24c9223" />

## 📂 Bài tập Unit Testing với JUnit

### 1. 📝 Mô tả bài toán (Problem Description)
**Chủ đề:** Phân tích dữ liệu điểm số học sinh (`StudentAnalyzer`).

Mục tiêu là xây dựng một lớp xử lý logic để phân tích danh sách điểm số và viết các Test Case tự động để đảm bảo logic chạy đúng.

**Yêu cầu chức năng:**
1.  **`countExcellentStudents(List<Double> scores)`**:
    * Đếm số lượng học sinh Giỏi (điểm `>= 8.0`).
    * Bỏ qua các điểm không hợp lệ (nhỏ hơn 0 hoặc lớn hơn 10).
    * Trả về 0 nếu danh sách rỗng.
2.  **`calculateValidAverage(List<Double> scores)`**:
    * Tính điểm trung bình cộng của các điểm hợp lệ.
    * Bỏ qua điểm sai (`< 0` hoặc `> 10`).
    * Trả về 0 nếu không có điểm nào hợp lệ.

### 2. 🛠️ Cấu trúc dự án (Project Structure)
Dự án được quản lý bằng **Maven**, tuân thủ cấu trúc chuẩn:

```bash
unit_test/
├── src/
│   ├── main/java/student/     # Source code chính (StudentAnalyzer.java)
│   └── test/java/student/     # Source code kiểm thử (StudentAnalyzerTest.java)
├── pom.xml                    # Khai báo thư viện JUnit Jupiter 5.9.2
└── README.md                  # Hướng dẫn chi tiết cho bài Lab
```
<details> <summary><b>📸 Bấm vào đây để xem ảnh chụp màn hình Test Result</b></summary>
<img width="1223" height="789" alt="image" src="https://github.com/user-attachments/assets/01c2af18-9f61-45df-867e-5506894780b5" />



</details>

Copyright © 2026 - [Tên Của Bạn]. Created for educational purpose.


