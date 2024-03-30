- Chọn: kiến trúc “Layered architecture”
-Lý do: 
+ Tính cô lập và tái sử dụng: Kiến trúc Layered Architecture cho phép phân chia hệ thống thành các lớp độc lập, giúp dễ dàng quản lý và bảo trì mã nguồn. Các lớp có thể được tái sử dụng trong các dự án khác nhau hoặc trong các tính năng mới.
+ Dễ mở rộng: Cấu trúc phân tầng cho phép mở rộng hệ thống một cách linh hoạt bằng cách thêm các lớp mới hoặc mở rộng các lớp hiện có mà không ảnh hưởng đến các phần khác của hệ thống.
+ Phù hợp với yêu cầu của ngân hàng: Kiến trúc Layered Architecture phản ánh cách mà ngân hàng XYZ hoạt động với các tầng khác nhau trong hệ thống, từ giao diện người dùng đến xử lý logic kinh doanh và quản lý dữ liệu.
=> Với mô hình này, các chức năng của ngân hàng như đăng ký tài khoản, thực hiện giao dịch và quản lý tài chính có thể được triển khai một cách hiệu quả và linh hoạt.
- Ưu điểm và các vấn đề liên quan:
+Tính cấu trúc và dễ hiểu: Kiến trúc phân tầng giúp dễ dàng hiểu và quản lý mã nguồn. 
=>Tăng cường tiện lợi, tính bảo mật thông qua các biện pháp xác thực.
+ Tính linh hoạt và dễ mở rộng: Các lớp độc lập cho phép mở rộng hệ thống một cách linh hoạt. => Giảm thời gian và chi phí cho cả ngân hàng và khách hàng.
+ Tính tái sử dụng: Các lớp có thể được tái sử dụng trong các dự án khác nhau.
- Nhược điểm và vấn đề liên quan:
+ Khả năng xử lý tải lớn: Kiến trúc phân tầng có thể gây ra vấn đề về hiệu suất nếu không được thiết kế đúng cách. Cần đảm bảo tính bảo mật cao để ngăn chặn các hoạt động gian lận và truy cập trái phép.
+ Khó khăn trong việc thay đổi cấu trúc: Các thay đổi trong cấu trúc của một lớp có thể ảnh hưởng đến các lớp khác và đòi hỏi sự thay đổi lớn trong mã nguồn. 
+ Trong một tầng đóng, các yêu cầu di chuyển từ trên xuống dưới từ tầng này sang tầng khác phải đi qua tầng ngay phía dưới của nó để tiếp tục di chuyển xuống. Trong khi đó, trong một tầng mở, các yêu cầu có thể tránh qua các tầng khác mà không cần phải đi qua tầng ngay phía dưới của chúng. Có sự phụ thuộc lẫn nhau giữa các tầng vì một tầng phụ thuộc vào tầng ở phía trên nó để nhận dữ liệu. 
- Nêu lại ý sinh viên:
+ Trong Presentation Layer sẽ chứa lớp: templates, controllers
+ Trong Business Layer sẽ chứa lớp: service, models
+ Trong Persistence Layer sẽ chứa: repositories
+ Trong Database Layer sẽ chứa:
+ - Diễn giải:
+ Presentation Layer: Đây là tầng mà người dùng tương tác trực tiếp, thông qua giao diện người dùng của trang web và ứng dụng di động. Nó tương tác trực tiếp với người dùng và chuyển các yêu cầu của họ đến các lớp dưới của hệ thống. Đối với tầng này mỗi người dùng cần nhập cccd để đăng ký tài khoản và làm thẻ. Cung cấp giao diện cho người dùng giao dịch với máy ATM. Quy trình:
Khách hàng truy cập vào trang web hoặc ứng dụng di động của ngân hàng.
Đăng ký tài khoản và thực hiện các thao tác cần thiết thông qua giao diện người dùng
+ Business Layer: là nơi xử lý logic nghiệp vụ kinh doanh từ tầng presentation của ngân hàng như quản lý tài khoản thẻ, xác thực người dùng dựa trên cccd hoặc thẻ và xử lý yêu cầu đăng ký tài khoản và làm thẻ, quản lý thông tin giao dịch được thcujw hiện tại các chi nhánh hoặc máy ATM và lưu trữ vào hệ thống nhằm gọi các phương thức từ tầng persistence để tương tác với dữ liệu và đảm bảo logic kinh doanh được thực hiện một cách đúng đắn. 
quy trình:
Xác thực thông tin khách hàng và yêu cầu giao dịch dựa trên các quy định và chính sách của ngân hàng.
Quản lý thông tin tài khoản và lịch sử giao dịch của khách hàng.
+ Persistence Layer: Là nơi thực hiện các truy vấn CRUD và thao tác với cơ sở dữ liệu. Nó làm cầu nối giữa Business Layer và Database Layer, đảm bảo rằng dữ liệu được truy xuất và cập nhật một cách hiệu quả và an toàn.
+ Database Layer: Là nơi lưu trữ thực sự của dữ liệu của ngân hàng, bao gồm thông tin về khách hàng, tài khoản và giao dịch và các dữ liệu khác có liên quan. Đây là cơ sở dữ liệu mà Persistence Layer sẽ truy cập và thực hiện các truy vấn và thao tác.

