#  SOFT5 - Software Testing Lab
### Đại học

<p><b>Sinh viên:</b> Đinh Trần Nguyên</p> 
<p><b>Mã sinh viên:</b> BIT230292 </p>
<p><b>Giảng viên hướng dẫn:</b> Trương Anh Hoàng</p> 

##  Bài tập Làm quen Can't Unsee
<b>Jan 5th 2026<b/>
<p>Cant's UnSee Practition Test</p>

<img width="433" height="341" alt="image" src="https://github.com/user-attachments/assets/91ee5020-5f77-451c-b2aa-1c02c24c9223" />

##  Bài tập Unit Testing với JUnit

### 1.  Mô tả bài toán
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

### 2. Cấu trúc dự án
Dự án được quản lý bằng **Maven**, tuân thủ cấu trúc chuẩn:

```bash
unit_test/
├── src/
│   ├── main/java/student/     # Source code chính (StudentAnalyzer.java)
│   └── test/java/student/     # Source code kiểm thử (StudentAnalyzerTest.java)
├── pom.xml                    # Khai báo thư viện JUnit Jupiter 5.9.2
└── README.md                  # Hướng dẫn chi tiết cho bài Lab
```
<p><b>Minh chứng</b><p/>

<img width="433" height="341" alt="image" src="https://github.com/user-attachments/assets/01c2af18-9f61-45df-867e-5506894780b5" />





Copyright © 2026 - Nguyen.DinhTran. Created for educational purpose.


