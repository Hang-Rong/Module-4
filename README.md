[Bài tập] Ứng dụng hiển thị gia vị với Sandwich
Mục tiêu
Luyện tập sử dụng Controller trong Spring MVC.

Điều kiện
Biết cách sử dụng Controller trong Spring MVC.

Mô tả
Trong phần này, chúng ta sẽ phát triển một ứng dụng cho phép hiển thị các gia vị đi kèm với món Sandwich.

Ứng dụng hiển thị một danh sách các gia vị dạng checkbox, cho phép người dùng chọn lựa một hoặc nhiều gia vị ăn kèm với Sanwich và sau đó hiển thị danh sách các gia vị đã lựa chọn đó.

Giao diện ứng dụng có thể như sau:



Hướng dẫn
Bước 1: Tạo dự án Spring MVC

Bước 2: Cấu hình dispatcher-servlet.xml

Bước 3: Cấu hình web.xml

Bước 4: Tạo Controller

Để tiếp nhận các mục lựa chọn sử dụng đối số của phương thức trong controller như sau

@RequestMapping(“/save”)
public String save(@RequestParam(“condiment”) String[] condiment) {
    //...
}
Trong đó: condiment là tên của các checkbox

Bước 5: Tạo thư mục views bên trong thư mục WEB-INF

Bước 6: Cấu hình Artifacts

Bước 7: Cấu hình Tomcat

Bước 8: Chạy ứng dụng web 

Bước 9: Truy cập đường dẫn http://localhost:8080/... và quan sát kết quả
