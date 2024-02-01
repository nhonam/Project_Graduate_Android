  
BỘ THÔNG TIN VÀ TRUYỀN THÔNG
HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG
KHOA CÔNG NGHỆ THÔNG TIN
------------------------------
 

BÁO CÁO ĐỒ ÁN
TỐT NGHIỆP ĐẠI HỌC

Đề tài: 
“XÂY DỰNG ỨNG DỤNG DI ĐỘNG KINH DOANH DỤNG CỤ THỂ THAO CÓ TÍNH NĂNG
 KHUYẾN NGHỊ SẢN PHẨM”

Người hướng dẫn	: Th.S Nguyễn Ngọc Duy
Sinh viên thực hiện	: ĐINH NHO NAM
Mã số sinh viên		: N19DCCN113
Lớp			: D19CQCNPM01-N
Khóa			: 2019 - 2024
Hệ			: ĐẠI HỌC CHÍNH QUY

TP. HCM, tháng 12 năm 2023


 BỘ THÔNG TIN VÀ TRUYỀN THÔNG
HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG
KHOA CÔNG NGHỆ THÔNG TIN
--------------------------------------

 

BÁO CÁO ĐỒ ÁN TỐT NGHIỆP ĐẠI HỌC
Đề tài:
XÂY DỰNG ỨNG DỤNG DI ĐỘNG KINH DOANH DỤNG CỤ THỂ THAO CÓ TÍNH NĂNG
 KHUYẾN NGHỊ SẢN PHẨM

Người hướng dẫn	: Th.S. Nguyễn Ngọc Duy
Sinh viên thực hiện	: ĐINH NHO NAM
Mã số sinh viên	: N19DCCN113
Lớp			: D19CQCNPM01-N
Khóa			: 2019 - 2024
Hệ			: ĐẠI HỌC CHÍNH QUY
TP. HCM, tháng 12 năm 2023
 
LỜI CẢM ƠN

	Trong quá trình thực hiện đề tài “Xây dựng ứng dụng di động kinh doanh dụng cụ thể thao có tính năng khuyến nghị sản phẩm”, em đã nhận được rất nhiều sự giúp đỡ, tạo điều kiện cửa tập thể Ban Giám Hiệu, Khoa Công Nghệ Thông Tin, giảng viên, cán bộ các phòng ban chức năng Học Viện Công Nghệ Bưu Chính Viễn Thông tại TP.HCM. Em xin bày tỏ lòng cảm ơn chân thành về sự giúp đỡ đó.
	Em xin bày tỏ lòng biết ơn sâu sắc tới Th.S Nguyễn Ngọc Duy – thầy giáo trực tiếp hướng dẫn và chỉ bảo em hoàn thành đề tài này.
	Và em cũng chân thành cảm ơn Tập đoàn VPNT, cảm ơn các anh chị đồng nghiệp đã góp ý hỗ trợ giúp đỡ em trong thời gian em làm đồ án này.
	Sau cùng, em xin kính chúc quý Thầy Cô trong Khoa Công Nghệ Thông Tin và Th.S Nguyễn Ngọc Duy thật dồi dào sức khỏe, niềm tin để tiếp tục sứ mệnh cao đẹp của mình là truyền đạt kiến thức cho thế hệ mai sau. 
Trân trọng.

TP.Hồ Chí Minh, ngày    tháng 12 năm 2023
Sinh viên thực hiện




									Đinh Nho Nam 

MỤC LỤC
CHƯƠNG 1: GIỚI THIỆU ĐỀ TÀI	1
1.1. Tổng quan đề tài	1
1.1.1.	Tổng quan	1
1.1.2.	Mô tả chức năng ứng dụng	1
1.1.3.	Yêu cầu phi chức năng	1
1.1.4.	Mục tiêu đề tài	1
CHƯƠNG 2: CƠ SỞ LÝ THUYẾT VÀ CÔNG NGHỆ	3
2.1.	Giới thiệu Spring Boot	3
2.3.1.	Khái niệm RESTful API	4
2.3.2.	Cách thức hoạt động của RESTful API	5
2.3.3.	Các tiêu chí về API RESTful	5
2.3.4.	Ưu và nhược điểm của RESTful API	6
2.4.	Nền tảng và công nghệ lập trình Android	6
2.4.1.	Tổng quan	6
2.4.2.	Android Studio	7
2.4.3.	Thị trường ứng dụng di động	7
2.4.4.	Đánh giá	7
2.5.	Hệ cơ sở dữ liệu MySQL	8
2.5.1.	Tổng quan	8
2.5.2.	So Sánh với SQL Server	8
2.6.	Thuật toán KNN (K-Nearest Neighbors)	9
2.6.1.	Định nghĩa	9
2.6.2.   Nguyên tắc hoạt động	9
2.6.3. Ví dụ minh họa	10
2.6.4. Ưu điểm và nhược điểm của thuật toán KNN	11
2.7.	Thuật toán maximum matching	11
2.7.1. Định nghĩa	11
2.7.2. Các bước thực hiện	12
2.7.3. Ví dụ minh họa	12
2.7.4. Ưu điểm và nhược điểm	14
CHƯƠNG 3: PHÂN TÍCH THIẾT KẾ HỆ THỐNG	16
3.1.	Khảo sát và phân tích hệ thống	16
3.1.1.	Phân tích hệ thống	16
3.1.2.	Xác định các Use case và xây dựng Biểu Use case chi tiết	16
3.2.	Lược đồ usecase tổng quát	17
3.3.	Các use case trong hệ thống	18
3.3.1.	Use case của nhân viên	18
3.3.2.	Use Case của Quản trị viên	19
3.3.3.	Use case của khách hàng	31
3.4.	Biểu đồ tuần tự các chức năng chính	44
3.4.1.	Khách hàng	44
3.4.2.	Admin	45
3.4.3.	Nhân viên	48
CHƯƠNG 4: THIẾT KẾ DỮ LIỆU	49
4.1.	Mô hình thực thể quan hệ	49
4.2.	Lược đồ cơ sở dữ liệu mức khái niệm	51
4.3.	Lược đồ cơ sở dữ liệu mức vật lý	51
4.3.	Các bảng dữ liệu	52
4.3.1.	Bảng User	52
4.3.2.	Bảng Product	52
4.3.3.	Bảng Category	53
4.3.4.	Bảng CartItem	53
4.3.5.	Bảng Order	53
4.3.6.	Bảng OrderItem	54
4.3.7.	Bảng Supplier	54
4.3.8.	Bảng Environment	54
4.3.9.	Bảng OrderStatus	55
4.3.10.	Bảng Banner	55
4.3.11.	Bảng Import_Product_Detail	55
4.3.12.	Bảng Import_Product	55
4.3.13.	Bảng Evaluate	56
4.3.14.	Bảng Brand	56
4.3.15.	Bảng Unit	56
4.3.16.	Bảng Activity	57
4.3.17.	Bảng Roles	57
CHƯƠNG 5: SẢN PHẨM MINH HỌA ĐỀ TÀI	58
5.1.	Giao diện khách hàng	58
5.1.2.	Trang chủ	58
5.1.2.	Đăng nhập	59
5.1.3.	Đăng ký	60
5.1.4.	Trang tìm kiếm sản phẩm	61
5.1.5.	Chi tiết sản phẩm	62
5.1.6.	Giỏ hàng	63
5.1.7.	Sửa thông tin cá nhân	64
5.1.8.	Thông tin cá nhân	65
5.1.9.	Đơn hàng đã mua	66
5.2.0.	Đánh giá sản phẩm	67
5.2.	Giao diện nhân viên	68
5.2.1.	Quản lý đơn hàng	68
5.2.2.	Xem chi tiết đơn hàng và xuất hóa đơn	69
5.3.	Giao diện Admin	70
5.3.1.	Quản lí sản phẩm	70
5.3.2.	Quản lí nhà cung cấp	70
5.3.3.	Quản lí nhân viên	71
5.3.4.	Thống kê doanh thu và xuất báo cáo	71
5.3.5.	Quản lý banner	72
5.3.6.	Quản lý thương hiệu	72
5.3.7.	Quản lý danh mục sản phẩm	73
5.3.8.	Quản lý môi trường sử dụng sản phẩm	73
CHƯƠNG 6: KẾT LUẬN	74
6.1.	Kết luận	74
6.1.1.	Những kết quả đạt được	74
6.1.2.	Hạn chế	74
6.1.3.	Hướng phát triển	74
TÀI LIỆU THAM KHẢO	75
 

DANH MỤC CÁC KÝ HIỆU VÀ CHỮ VIẾT TẮT
JVM: Java Virtual Machine	Máy ảo Java
SDK: Software Development Kit	Bộ công cụ phát triển ứng dụng
IDE: Integrated Development Environment	Môi trường tích hợp phát triển ứng dụng
API: Application Programming Interface	Phương thức trung gian kết nối các ứng dụng và thư viện
ERD: Entity Relationship Diagram	Sơ đồ quan hệ thực thể






	 

DANH MỤC CÁC BẢNG
Bảng 1: So sánh MYSQL và SQL Server.	9
Bảng 2: Bảng Quản lý đơn đặt hàng.	14
Bảng 3: Bảng Quản lý hóa đơn nhập sản phẩm.	15
Bảng 4: Bảng đặc tả use case Quản lý sản phẩm.	18
Bảng 5: Bảng đặc tả use case Thống kê.	19
Bảng 6: Bảng đặc tả use case Quản lý nhân viên.	21
Bảng 7: Bảng đặc tả use case Quản lý khách hàng.	23
Bảng 8: Bảng đặc tả use case Quản lý danh mục sản phẩm.	24
Bảng 9: Bảng đặc tả use case Quản lý banner.	26
Bảng 10: Bảng đặc tả use case Mua hàng.	28
Bảng 11: Bảng đặt tả use case Quản lý đơn hàng.	29
Bảng 12: Bảng đặc tả use case Đánh giá sản phẩm.	31
Bảng 13: Bảng đặc tả use case Đăng ký thành viên.	32
Bảng 14: Bảng đặc tả use case Đăng nhập.	33
Bảng 15: Bảng đặc tả use case Xem thông tin cá nhân.	34
Bảng 16: Bảng đặc tả use case Cập nhật thông tin cá nhân.	35
Bảng 17: Bảng đặc tả use case Quản lý giỏ hàng.	36
Bảng 18: Bảng đặc tả use case Tìm kiếm sản phẩm.	37
Bảng 19: Bảng đặc tả use case Xem danh sách sản phẩm.	38
Bảng 20: Bảng đặc tả use case Thêm sản phẩm vào giỏ hàng.	39
Bảng 21: Bảng User.	47
Bảng 22: Bảng Product.	48
Bảng 23: Bảng Category.	48
Bảng 25: Bảng CartItem.	48
Bảng 26: Bảng Order.	49
Bảng 27: Bảng OrderItem.	49
Bảng 28: Bảng Supplier.	49
Bảng 29: Bảng Environment.	50
Bảng 30: Bảng OrderStatus.	50
Bảng 31: Bảng Banner.	50
Bảng 32: Bảng Import_Product_Detail	50
Bảng 33: Bảng Import_Product.	51
Bảng 34: Bảng Evaluate.	51
Bảng 35: Bảng Brand.	51
Bảng 36: Bảng Unit.	52
Bảng 37: Bảng Activity	52
Bảng 38: Bảng Roles.	52


 

DANH MỤC CÁC HÌNH
Hình 1: Cách thức hoạt động RESTful API.	6
Hình 2: Biểu đồ thị trường ứng dụng di động 2022-2030.	8
Hình 3: Logo Hệ quản trị cơ sở dữ liệu MYSQL	9
Hình 4: Bộ dữ liệu đặc trưng.	11
Hình 5: Gán nhãn cho dấu hiệu huấn luyện.	11
Hình 6: Giải thuật tách thực thể từ trái qua.	14
Hình 7: Giải thuật tách thực thể từ phải qua	15
Hình 8: Lược đồ use case Tổng quát.	18
Hình 9:Biểu đồ Use case quản lý đơn đặt hàng.	19
Hình 10:Biểu đồ Use case quản lý hóa đơn nhập sản phẩm.	20
Hình 11:Biểu đồ Use case Quản lý sản phẩm.	22
Hình 12:Biểu đồ Use case Thống kê.	24
Hình 13: Biểu đồ Usecase Quản lý khách hàng.	28
Hình 14:Biểu đồ Use case Quản lý danh mục sản phẩm.	29
Hình 15:Biểu đồ Use case Quản lý banner.	31
Hình 16:Biểu đồ Use Case Mua hàng.	33
Hình 17: Biểu đồ Use case Quản lý đơn hàng.	34
Hình 18:Biểu đồ Use case Đánh giá sản phẩm.	36
Hình 19:Biểu đồ Use case đăng ký tài khoản.	37
Hình 20:Biểu đồ Use Case đăng ký đăng nhập.	38
Hình 21: Biểu đồ Use case quản lý tài khoản cá nhân.	39
Hình 22: Biểu đồ Use case quản lý giỏ hàng.	41
Hình 23:Biểu đồ Use case Tìm kiếm sản phẩm.	42
Hình 24:Biểu đồ Use case Xem danh sách sản phẩm.	43
Hình 25:Biểu đồ Use case Thêm sản phẩm vào giỏ hàng.	44
Hình 26: Biểu đồ tuần tự Mua hàng.	45
Hình 27: Biểu đồ tuần tự Đánh giá sản phẩm.	46
Hình 28: Biểu đồ tuần tự Quản lý đơn hàng.	46
Hình 29: Biểu đồ tuần tự Quản lý hóa đơn nhập sản phẩm.	47
Hình 30: Biểu đồ tuần tự Thống kê.	47
Hình 31: Biểu đồ tuần tự Quản lý sản phẩm.	48
Hình 32: Biểu đồ tuần tự Quản lý đơn đặt hàng.	49
Hình 33: Mô hình thực thể quan hệ (ERD)	50
Hình 34: Lược đồ cơ sở dữ liệu mức khái niệm	52
Hình 35: Lược đồ cơ sở dữ liệu mức vật lý	52
Hình 36: Màn hình trang chủ	59
Hình 37: Màn hình đăng nhập	60
Hình 38: Màn hình đăng ký	61
Hình 39: Màn hình tìm kiếm sản phẩm	62
Hình 40 :Màn hình chi tiết sản phẩm	63
Hình 41: Giỏ hàng	64
Hình 42: Cập nhật thông tin cá nhân	65
Hình 43: Thông tin cá nhân	66
Hình 44: Đơn hàng đã mua	67
Hình 45: Đơn hàng đã mua	68
Hình 46: Quản lí sản phẩm	71
Hình 47 : Quản lí nhà cung cấp	71
Hình 48: Quản lí tài khoản nhân viên	72
Hình 49: Thống kê doanh thu và xuất báo cáo	72
Hình 50: Quản lý banner	73
Hình 51 : Quản lý thương hiệu	73
Hình 52 : Quản lý danh mục sản phẩm	74
Hình 53 : Quản lý môi trường sử dụng sản phẩm	74 

 
CHƯƠNG 1: GIỚI THIỆU ĐỀ TÀI

1.1. Tổng quan đề tài
1.1.1.	Tổng quan
-	Tên ứng dụng: AppSportShop
-	Mô tả: Ứng dụng di động kinh doanh dụng cụ thể thao, hỗ trợ người dùng mua hàng một cách nhanh chóng và thuận tiện, giúp người dùng có thể mua hàng mà không cần phải ra tận cửa hàng, hỗ trợ nhân viên và chủ cửa hàng quản lí quản trị và bán hàng một cách chuyên nghiệp và thuận tiện.
-	Nền tảng: Android
1.1.2.	Mô tả chức năng ứng dụng
Hệ thống của ứng dụng sẽ quản lý thông tin cá nhân của mỗi người dùng và tài khoản của họ, mỗi một tài khoản sẽ tương ứng với một email và một người dùng. Người dùng không cần thiết phải thực hiện đăng nhập để truy cập được ứng dụng, nhưng sẽ bị hạn chế các chức năng thêm xoá sửa và quản lý tài khoản, mua hàng, thêm vào giỏ hàng.
Có ba loại tài khoản trong ứng dụng: Quản trị viên (ADMIN), Nhân viên (EMPLOYEE), Khách hàng (CUSTOMER). Tài khoản quản trị viên là tài khoản toàn quyền trên ứng dụng quản lí, tài khoản này sẽ được hệ thống cung cấp và là duy nhất. Tài khoản nhân viên sẽ được quản trị viên cấp, và khách hàng sẽ tự đăng ký tài khoản với hệ thống.
Ứng dụng sẽ cung cấp một kho sản phẩm rộng lớn về các mặt hàng liên quan tới dụng cụ thể thao, cùng với mô tả chi tiết về sản phẩm. Ngoài ra ứng dụng cho phép người dùng tìm kiếm sản phẩm theo tên, danh mục và đề xuất cho người dùng những sản phẩm bán chạy nhất của cửa hàng.
Ngoài ra ứng dụng còn có chức năng khuyến nghị những sản phẩm theo mô tả của khách hàng.
1.1.3.	Yêu cầu phi chức năng
-	Hệ thống đáng tin cậy, chính xác, giao diện thân thiện, truy cập dữ liệu nhanh chóng
-	Đảm bảo tính bảo mật cho người điều hành và khách hàng sử dụng hệ thống
-	Phải có tính linh hoạt cao, có khả năng nâng cấp.
1.1.4.	Mục tiêu đề tài
Xây dựng được ứng dụng mua bán dụng cụ thể thao online cho phép người bán có thể quản lý sản phẩm, thông tin đơn hàng, thống kê… Xây dựng giao diện ứng dụng dành cho người mua hàng, giúp cho người mua hàng có thể xem thông tin và đặt hàng ngay tại ứng một cách nhanh chóng và tiện lợi. Tiết kiệm thời gian và chi phí, loại bỏ các thông tin không cần thiết và cho phép đạt được các mục tiêu về thời gian một cách hiệu quả, cải thiện khả năng quản lý. Người dùng có thể ngay lập tức truy cập dữ liệu từ hệ thống và đưa ra các thao tác xử lý một cách nhanh chóng. Đáp ứng nhu cầu hiện nay.


1.2.	Tổng quan ngành Thương mại điện tử 


Công nghệ thông tin và thương mại điện tử đã được ứng dụng rộng rãi vào đời sống xã hội nói chung và doanh nghiệp nói riêng. Đối với doanh nghiệp, thương mại điện tử góp phần hình thành những mô hình kinh doanh mới, tăng doanh thu, giảm chi phí, nâng cao hiệu quả kinh doanh và mở ra một thị trường rộng lớn với mọi đối tượng khách hàng trong và ngoài nước.
Đối với người tiêu dùng, thương mại điện tử giúp người mua chỉ ngồi tại nhà mà vẫn có thể lựa chọn hàng hóa, dịch vụ trên các thị trường ở mọi nơi trên thế giới bằng một vài động tác kích chuột. Thương mại điện tử là một trong những động lực quan trọng thúc đẩy sự phát triển kinh tế, là nhân tố chính đẩy nhanh quá trình quốc tế hóa đời sống kinh tế thế giới. Nhờ ứng dụng thương mại điện tử mà bất kỳ doanh nghiệp nào, thậm chí ở một nước nghèo nhất, một vùng xa xôi hẻo lánh trên địa cầu, cũng có thể dễ dàng tiếp cận với các thị trường rộng lớn thông qua mạng Internet.
Đối với sự phát triển nhanh chóng của thời kỳ công nghiệp hóa, hiện đại hóa. Internet đang dần trở nên phổ biến và là một phần không thể thiếu trong cuộc sống hiện nay. Có rất nhiều công nghệ mới được ra đời để giúp con người có thể quản lý công việc của mình một cách hiệu quả và tiết kiệm chi phí. 
Với những lý do trên “Xây dựng ứng dụng di động kinh doanh dụng cụ thể thao có tính năng khuyến nghị sản phẩm” là chủ đề được em quyết định lựa chọn thực hiện đề tài.

Theo thống kê của Statista – công ty về thị trường và dữ liệu người tiêu dùng, thời trang là phân khúc thị trường thương mại điện tử B2C (Business to Consumer) lớn nhất với quy mô toàn cầu năm 2021 là 759,5 tỷ USD.
Trong bối cảnh đại dịch hiện nay, người tiêu dùng đặc biệt hạn chế đến nơi đông người. Chính vì thế, hình thức mua sắm trực tuyến trở thành lựa chọn hàng đầu. Lazada – một trong những sàn thương mại điện tử lớn nhất Việt Nam cho biết trong năm 2022, có đến 58% khách hàng ưu tiên mua sắm trực tuyến, đặc biệt trên nền tảng thương mại điện tử.
  

CHƯƠNG 2: CƠ SỞ LÝ THUYẾT VÀ CÔNG NGHỆ

2.1.	Giới thiệu Spring Boot
Spring Boot chính là một Java framework, có nhiều khả năng hữu ích vì nó có thể giúp lập trình viên giải quyết rất nhiều vấn đề. So với framework Spring thông thường, Spring Boot tỏ ra những lợi thế vượt trội. Khi sử dụng Spring Boot, rất nhiều thứ được cải tiến hỗ trợ lập trình viên như:
-	Auto config: tự động cấu hình thay lập trình viên, bạn chỉ cần viết code và tiến hành chạy hệ thống là được.
-	Dựa trên các Annotation để tạo lập các bean thay vì XML.
-	Server Tomcat có thể được nhúng ngay trong file JAR build ra và có thể chạy ở bất kì đâu mà java chạy được.
-	Khi sử dụng Spring Boot, lập trình viên chỉ cần:
+	Sử dụng Spring Initializr: nhập các thông tin của dự án (project), chọn thư viện (Library) và tải code về máy.
+	Mở mã nguồn (source code) và bắt đầu viết code.
-	Có thể chạy ngay trong IDE, hoặc build thành file JAR mà không cần cấu hình config cho server.

Ưu điểm nổi bật của Spring Boot:
•	Phát triển web một cách đơn giản và nhanh chóng.
•	Config an toàn
•	Có thể hỗ trợ YAML
•	Có tính quản trị cao
•	Dễ dàng ứng dụng Spring và các sự kiện.
•	Có thể cấu hình ở bên ngoài và tạo ra những tệp thuộc tính.
•	Tính bảo mật cao.
•	Ghi log

2.2.	Giới thiệu về ReactJS
-	ReactJS là một opensource được phát triển bởi Facebook, ra mắt vào năm 2013, bản thân nó là một thư viện Javascript được dùng để để xây dựng các tương tác với các thành phần trên website. Một trong những điểm nổi bật nhất của ReactJS đó là việc render dữ liệu không chỉ thực hiện được trên tầng Server mà còn ở dưới Client nữa.
-	Kiến trúc dựa trên thành phần: ReactJS tuân theo mô hình kiến trúc dựa trên thành phần, trong đó giao diện người dùng được chia thành các thành phần độc lập và có thể tái sử dụng. Tiếp cận theo cách này giúp tăng tính tái sử dụng mã, dễ dàng bảo trì và quản lý các giao diện phức tạp.
-	DOM ảo: ReactJS sử dụng DOM ảo (Virtual DOM) để cập nhật và hiển thị giao diện người dùng một cách hiệu quả. DOM ảo là một bản sao nhẹ của DOM thực tế, cho phép React thực hiện so sánh hiệu quả và chỉ cập nhật những phần cần thiết của giao diện. Tiếp cận này giảm thiểu việc thao tác trên DOM và giúp cải thiện hiệu suất.
-	Luồng dữ liệu một chiều: React tuân theo luồng dữ liệu một chiều, còn được gọi là one-way data binding. Dữ liệu chảy theo một hướng, từ thành phần cha đến thành phần con, giúp dễ dàng hiểu và gỡ rối các thay đổi trạng thái của ứng dụng. Mô hình này giúp duy trì trạng thái dự đoán được và giảm thiểu những tác động phụ không mong đợi.
-	JSX: ReactJS sử dụng cú pháp JSX (JavaScript XML), cho phép nhà phát triển viết mã giống HTML trong JavaScript. JSX giúp đơn giản hóa việc tạo các thành phần giao diện, cải thiện khả năng đọc mã và cung cấp kiểm tra lỗi tại thời gian biên dịch.
-	Hệ sinh thái và cộng đồng phong phú: ReactJS có một hệ sinh thái phong phú với nhiều thư viện, công cụ và tiện ích từ bên thứ ba. Hệ sinh thái này cung cấp các giải pháp cho các tác vụ như quản lý trạng thái (ví dụ: Redux, MobX), định tuyến (ví dụ: React Router), xử lý biểu mẫu (ví dụ: Formik), và nhiều hơn nữa. Hơn nữa, React còn có một cộng đồng lớn và tích cực, đóng góp vào sự phát triển của nó, cung cấp hỗ trợ và chia sẻ tài nguyên.
-	Trải nghiệm phát triển tốt: React cung cấp trải nghiệm phát triển tuyệt vời với các tính năng như hot module replacement, cho phép cập nhật mã trong thời gian thực trong quá trình phát triển mà không mất trạng thái của ứng dụng. React Developer Toolslà một tiện ích mở rộng trình duyệt cung cấp khả năng gỡ lỗi mạnh mẽ và cung cấp thông tin về cấu trúc thành phần.
-	Phát triển ứng dụng di động: React Native, một framework được xây dựng dựa trên React, cho phép nhà phát triển xây dựng ứng dụng di động native cho các nền tảng iOS và Android bằng JavaScript. Bằng cách tận dụng kiến thức ReactJS, nhà phát triển có thể chia sẻ mã nguồn và xây dựng ứng dụng di động với giao diện người dùng native.
-	Tối ưu hóa hiệu năng: ReactJS cung cấp các công cụ và kỹ thuật tối ưu hiệu năng. Ví dụ, nhà phát triển có thể sử dụng shouldComponentUpdate hoặc React.memo để kiểm soát việc cập nhật thành phần, thực hiện chia nhỏ mã nguồn để giảm kích thước bundle, và sử dụng bộ phân tích hiệu năng của React để xác định các vấn đề về hiệu năng.
2.3.	Giới thiệu RESTful API
2.3.1.	Khái niệm RESTful API
RESTful API (hay REST API) là một giao diện lập trình ứng dụng (API hay web API) tuân theo các ràng buộc của kiểu kiến trúc REST, cho phép tương tác với các dịch vụ web RESTful. Hay nói đơn giản, RESTful API là một tiêu chuẩn được dùng trong việc thiết kế API dành cho các ứng dụng web (thiết kế Web Services) để hỗ trợ cho việc quản lý các resource. REST là viết tắt của cụm từ Representational state transfer (ứng dụng chuyển đổi cấu trúc dữ liệu), được tạo ra lần đầu bởi nhà khoa học máy tính Roy Fielding ở những năm 2000.

2.3.2.	Cách thức hoạt động của RESTful API
Hình 1: Cách thức hoạt động RESTful API.
RESTful API chia một transaction (giao dịch) ra thành nhiều module nhỏ, mỗi module giải quyết một phần cơ bản của transaction. Việc này giúp tăng tính linh hoạt nhưng đôi khi lại tương đối khó khăn cho các developer khi muốn thiết kế REST API từ đầu. Hiện tại có khá 

nhiều công ty cung cấp model cho các developer sử dụng, trong đó phổ biến nhất gồm có Amazon S3, CDMI hay OpenStack Swift.
Một RESTful API sử dụng các câu lệnh để lấy tài nguyên, trạng thái của tài nguyên ở bất kỳ timestamp nào được gọi là một biểu diễn của tài nguyên đó. Các phương thức HTTP mà RESTful API sử dụng được xác định bởi giao thức RFC 2616:
-	GET: Trả về một tài nguyên.
-	PUT: Thay đổi trạng thái hoặc cập nhật tài nguyên (có thể là đối tượng, file hay block).
-	POST: Tạo tài nguyên.
-	DELETE: Xoá một tài nguyên.
 
2.3.3.	Các tiêu chí về API RESTful
-	Một kiến trúc client-server tạo bởi các client, server, tài nguyên và có request được quản lý thông qua HTTP.
-	Giao tiếp client-server không trạng thái (stateless), tức là thông tin client không được lưu trữ giữa các request, đồng thời mỗi request đều tách biệt với nhau.
-	Dữ liệu có thể được cache, giúp streamline giao tiếp giữa client và server.
-	Có giao diện thống nhất (uniform interface – UI) giữa các thành phần để thông tin được truyền ở dạng chuẩn. Tức là các tài nguyên chỉ được nhận dạng duy nhất thông qua một URL, đồng thời việc xử lý tài nguyên chỉ được thực hiện thông qua các phương pháp cơ bản của giao thức mạng, chẳng hạn như DELETE, PUT, và GET với HTTP.
-	Hệ thống phân lớp tổ chức mỗi loại server (chịu trách nhiệm bảo mật, cân bằng tải,…) liên quan đến việc truy xuất thông tin được request thành những cấu trúc phân cấp.
-	Code-on-demand. Chủ yếu thì server sẽ gửi lại các biểu diễn tĩnh của tài nguyên dưới dạng XML hoặc JSON. Tuy nhiên khi cần thiết thì các server vẫn có thể gửi executable code đến client.

2.3.4.	Ưu và nhược điểm của RESTful API
Ưu điểm:
-	Dễ hiểu, dễ học, đơn giản.
-	Cho phép tổ chức các ứng dụng phức tạp, dễ dàng sử dụng tài nguyên.
-	Quản lý tải cao nhờ HTTP proxy server và cache.
-	Các client mới có thể dễ dàng làm việc trên những ứng dụng khác.
-	Cho phép sử dụng các lệnh gọi thủ tục HTTP tiêu chuẩn để truy xuất dữ liệu và request.
-	RESTful API dựa trên code và có thể sử dụng nó để đồng bộ hoá dữ liệu bằng website.
-	Cung cấp các định dạng linh hoạt bằng cách tuần tự hoá (serialize) dữ liệu ở dạng XML hay JSON.
-	Cho phép sử dụng các giao thức OAuth để xác thực request REST.

Nhược điểm:
-	Không có trạng thái: Hầu hết các ứng dụng web đều yêu cầu cơ chế stateful (có trạng thái). Giả sử ta cần mua một website có cơ chế giỏ hàng, khi đó ta cần biết số lượng sản phẩm có trong giỏ hàng trước khi thực hiện thanh toán. Việc duy trì trạng thái này là nhiệm vụ của phía client, do đó ứng dụng client có thể cồng kềnh và khó bảo trì hơn.
-	Bảo mật: REST có thể phù hợp với các URL public, nhưng không phải là một lựa chọn tốt nếu cần truyền dữ liệu nhạy cảm giữa client và server.

2.4.	Nền tảng và công nghệ lập trình Android
2.4.1.	Tổng quan
Theo Techopedia giải thích về nền tảng Android, đây là một nền tảng được ra mắt năm 2007 bởi Open Handset Alliance, một liên minh các công ty nổi tiếng như Google, HTC, Motorola, Texas Instruments, … Mặc dù hầu hết các nền tảng Android đều được viết bằng Java, nhưng không có JVM (Java Virtual Machine – Máy ảo Java) trong hệ điều hành Android. Mà thay vào đó, các lớp Java được biên dịch thành Dalvik Executables trước và chạy được trên DVM (Dalvik Virtual Machine).
Android là một nền tảng phát triển mở. Tuy nhiên, nó không mở theo nghĩa mọi người có thể đóng góp trong khi một phiên bản đang phát triển. Đúng hơn, tính chất mở của Android bắt đầu khi mã nguồn của nó được phát hành ra công chúng khi nó được hoàn thiện bởi Google. Và sau đó, bất kì ai quan tâm cũng có thể lấy mã và thay đổi nó nếu họ thấy phù hợp.
Để tạo ứng dụng cho nền tảng, nhà phát triển yêu cầu có một Bộ công cụ phát triển phần mềm Android (Android SDK), bao gồm các công cụ và API. Để tiết kiệm thời gian gian phát triển, nhà phát triển ứng dụng Android thường tích hợp SDK vào Môi trường phát triển tích hợp (IDE), mà thường thấy và phổ biến nhất là Android Studio, Visual Code, …
2.4.2.	Android Studio
Là một môi trường phát triển tích hợp chính thức cho tất cả các ứng dụng Android, Android Studio dường như luôn đứng đầu trong danh sách các công cụ ưa thích của các nhà phát triển.
Google tạo ra Android Studio năm 2013, làm thay thế công cụ phát triển ứng dụng Android gốc Android Eclipse.
Android Studio cung cấp các công cụ chỉnh sửa, gỡ lỗi và kiểm tra mã trong một giao diện kéo thả dễ sử dụng. Nó được tải xuống miễn phí vả hỗ trợ không chỉ bởi Google mà còn một cộng đồng rất lớn các nhà phát triển Android.
2.4.3.	Thị trường ứng dụng di động
Quy mô thi trường ứng dụng di động toàn cầu lên tới 187,58 tỷ USD vào năm 2021 và dự kiến sẽ tăng trưởng với tốc độ tăng trưởng kép hằng năm là 13.4% từ năm 2022 đến năm 2030. Các ứng dụng trò chơi, sức khoẻ, âm nhạc, giải trí, mẹo vặt, mạng xã hội, bán lẻ và thương mại điện tử đều nằm trong phạm vi ứng dụng di động. Sự phổ biến của điện thoại thông minh, việc sử dụng internet ngày càng tăng và sử dụng các công nghệ như trí tuệ nhân tạo và máy học trong các ứng dụng di động đều cho thấy nhu cầu về ứng dụng dành cho thiết bị di động sẽ tăng trưởng trong tương lai.
 
Hình 2: Biểu đồ thị trường ứng dụng di động 2022-2030.


2.4.4.	Đánh giá
Hệ điều hành Android chiếm hơn 90% các tiện ích được xuất bản trên thị trường ứng dụng trên toàn thế giới. Nó tương thích với bất kì thiết bị nào. Do đó, Android cũng cấp cho nhà phát triển một khả năng mở rộng ấn tượng.
2.5.	Hệ cơ sở dữ liệu MySQL
2.5.1.	Tổng quan
My SQL là một hệ quản trị cơ sở dữ liệu mã nguồn mở (RDBMS) hoạt động theo mô hình client-server. My SQL được tích hợp apache, PHP. MySQL quản lý dữ liệu thông qua các cơ sở dữ liệu. Mỗi cơ sở dữ liệu có thể có nhiều quan hệ chứa dữ liệu.
 
Hình 3: Logo Hệ quản trị cơ sở dữ liệu MYSQL
2.5.2.	So Sánh với SQL Server
Tiêu chí	MySQL	SQL Server
Môi trường	MySQL có thể kết hợp với mọi ngôn ngữ lập trình khác, thông thường là PHP	SQL Server hoạt động tốt với .NET
Syntax	MySQL
·         SELECT age
·         FROM person
·         ORDER BY age ASC
LIMIT 1 OFFSET 2	Microsoft SQL Server
·         SELECT TOP 3 WITH TIES *
·         FROM person
ORDER BY age ASC
Bản chất	Là một phần mềm mã nguồn mở, chạy trên hơn 20 nền tảng bao gồm Linux, Windows, OS / X, HP-UX, AIX, Netware.	Là một phần mềm độc quyền được Microsoft đã xây dựng nhiều công cụ mạnh mẽ cho SQL Server, bao gồm các công cụ phân tích dữ liệu.
Storage engines	Nhiều loại engines được tạo ra cho MySQL. Điều này giúp lập trình viên MySQL linh hoạt dùng nhiều storage engine khác nhau cho bảng.	SQL server sử dụng một storage engine riêng được phát triển bởi Microsoft
Hủy Query	MySQL không cho phép hủy query giữa chừng	SQL Server cho phép hủy query giữa chừng
Bảo mật	Các chuyên gia về cơ sở dữ liệu giúp MySQL có tính năng bảo mật đặc biệt để dữ liệu được bảo mật tuyệt đối.	Công cụ bảo mật riêng – Microsoft Baseline Security Analyzer giúp tăng tính bảo mật cho SQL Server một cách triệt để
Chi phí	Miễn phí	Trả phí
IDEs	Dùng MySQL Workbench	Dùng Management Studio (SSMS)
Bảng 1: So sánh MYSQL và SQL Server.
2.6.	Thuật toán KNN (K-Nearest Neighbors)
2.6.1.	Định nghĩa
Thuật toán KNN (K-Nearest Neighbors) là một thuật toán học máy không giám sát được sử dụng trong các bài toán phân loại và dự đoán. Nguyên tắc hoạt động của KNN dựa trên việc xác định nhãn của một điểm dữ liệu mới dựa trên nhãn của các điểm dữ liệu xung quanh nó.
2.6.2.   Nguyên tắc hoạt động
Nguyên tắc hoạt động của KNN như sau:
•	Định nghĩa K và khoảng cách: K là số lượng láng giềng gần nhất mà chúng ta muốn sử dụng để dự đoán nhãn của một điểm dữ liệu mới. Khoảng cách được tính dựa trên một phương pháp đo khoảng cách như khoảng cách Euclid hoặc khoảng cách Manhattan.
•	Xác định K láng giềng gần nhất: Để dự đoán nhãn của một điểm dữ liệu mới, KNN tìm K điểm dữ liệu trong tập dữ liệu huấn luyện gần nhất với điểm đó dựa trên khoảng cách. Khoảng cách này có thể được tính bằng cách so sánh các đặc trưng của các điểm dữ liệu.
•	Xác định nhãn dự đoán: Sau khi xác định được K láng giềng gần nhất, KNN sẽ sử dụng đa số phiếu bầu (voting) để xác định nhãn dự đoán cho điểm dữ liệu mới. Các láng giềng gần nhất đóng vai trò như các phiếu bầu và nhãn của láng giềng xuất hiện nhiều nhất sẽ được chọn là nhãn dự đoán.
•	Đánh giá và dự đoán: Sau khi xác định nhãn dự đoán cho điểm dữ liệu mới, KNN có thể đánh giá độ chính xác của mô hình bằng cách so sánh nhãn dự đoán với nhãn thực tế của điểm dữ liệu.
KNN có thể được áp dụng vào nhiều loại bài toán phân loại và dự đoán, từ nhận dạng chữ viết tay đến hệ thống khuyến nghị. Điểm mạnh của KNN là dễ dàng hiểu và triển khai, đồng thời có khả năng xử lý các tập dữ liệu lớn. Tuy nhiên, KNN cũng có nhược điểm là đòi hỏi tính toán khoảng cách giữa các điểm dữ liệu, có thể ảnh hưởng đến hiệu suất với các tập dữ liệu lớn.
2.6.3. Ví dụ minh họa

- Bộ dữ liệu:
 
Hình 4: Bộ dữ liệu đặc trưng.
Hình trên là bộ dữ liệu chuẩn bị các đặc trưng sẵn cho các sản phẩm
- Chuẩn bị dữ liệu cho KNN
 
Hình 5: Gán nhãn cho dấu hiệu huấn luyện.
Hình trên là bộ dữ liệu huấn luyện cho mô hình KNN và gán nhãn cho dữ liệu huấn luyện dữ liệu
-Chúng ta đưa ra một số dữ liệu để Huấn luyện cho mô hình KNN
Với các nhãn
Gbd: giày đá bóng
Cxd: chưa xác định
Vcl: vợt cầu long

Sau khi có mô hình huấn luyện
Giả sử chúng ta hỏi rằng: “Tôi muốn tìm mua một cây vợt”
Thì vector(v9) ứng với câu nói trên là: [ 0 0 0 0 1 0 0 0]
Áp dụng công thức tính khoảng cách Mahattan ta tính được các giá trị sau
d(v9-v1) =5 
d(v9-v2) = 2
d(v9-v3) = 2
d(v9-v2) = 3
d(v9-v5) = 0
d(v9-v6) = 1

Từ đó chúng ta dựa vào mô hình KNN và đưa ra kết luận được vector v9 ứng với nhãn cxd
Tương tự thực hiện với những truy vấn khác

2.6.4. Ưu điểm và nhược điểm của thuật toán KNN
Ưu điểm của KNN:
•	KNN có cấu trúc đơn giản và dễ hiểu. Nó không yêu cầu giả định về phân phối của dữ liệu và dễ triển khai.
•	KNN là một thuật toán "lười" (lazy learning), nghĩa là nó không yêu cầu quá trình huấn luyện phức tạp. Mô hình được xây dựng ngay khi có dữ liệu cần dự đoán.
•	KNN thường hoạt động tốt với các tập dữ liệu nhỏ và khi dữ liệu có tính chất cụm, nghĩa là các điểm dữ liệu tương tự thường nằm cùng một khu vực.
•	KNN có thể áp dụng cho nhiều loại dữ liệu, bao gồm cả dữ liệu có tính chất không cấu trúc hoặc không đồng nhất.
Nhược điểm của KNN:
•	Với mỗi dự đoán, KNN phải tính khoảng cách đến tất cả các điểm dữ liệu trong tập huấn luyện, điều này có thể trở nên rất tốn kém khi số lượng điểm dữ liệu lớn.
•	KNN có thể bị ảnh hưởng bởi nhiễu và các đặc trưng có chiều cao khác nhau. Cần phải tiền xử lý dữ liệu một cách cẩn thận để giảm thiểu ảnh hưởng của các vấn đề này.
•	Trong các không gian đa chiều, việc xác định khoảng cách có thể trở nên không hiệu quả và dẫn đến hiện tượng "nguyên tắc chiều cao" (the curse of dimensionality).
•	KNN cần lưu trữ toàn bộ tập dữ liệu huấn luyện trong bộ nhớ, điều này có thể trở thành một vấn đề khi tập dữ liệu lớn.
Tổng quát, việc sử dụng KNN phụ thuộc lớn vào đặc điểm cụ thể của bài toán và tính chất của dữ liệu. Khi áp dụng đúng cách và với sự chăm sóc phù hợp, KNN có thể là một lựa chọn hiệu quả.

2.7.	Thuật toán maximum matching

2.7.1. Định nghĩa
Thuật toán Maximum Matching (Khớp cực đại) là một thuật toán được sử dụng trong xử lý ngôn ngữ tự nhiên và trích xuất thông tin từ văn bản. Nhiệm vụ chính của thuật toán là tìm các từ trong một câu sao cho tổng độ dài các từ được chọn là lớn nhất.
Phương pháp này dựa trên một từ điển tiếng Việt, gồm những từ và cụm từ sau đây gọi chung là thực thể. Có hai phương pháp Đối sánh thực thể dài nhất là đối sánh từ trái qua và đối sánh từ phải qua.


2.7.2. Các bước thực hiện
Dưới đây là mô tả cơ bản về thuật toán Maximum Matching:
1.	Đầu vào: Một câu hoặc một đoạn văn bản được chia thành các từ riêng biệt.
2.	Bước khớp: Bắt đầu từ đầu câu, thuật toán tìm kiếm từ có độ dài lớn nhất trong từ điển. Nếu từ tìm thấy trong từ điển, nó được coi là một khớp và được chọn là một từ trong kết quả. Nếu từ không tìm thấy trong từ điển, thuật toán tiếp tục tìm từ với độ dài giảm dần cho đến khi tìm thấy một từ trong từ điển. Quá trình này được lặp lại cho đến khi tất cả các từ trong câu đều được chọn.
3.	Kết quả: Kết quả của thuật toán là một danh sách các từ đã được chọn. Các từ này được coi là khớp cực đại vì tổng độ dài của chúng là lớn nhất có thể đạt được.

2.7.3. Ví dụ minh họa
Ví dụ: Rút trích thực thể của câu “Hôm nay thi tốt nghiệp” bằng giải thuật từ trái qua.
Giả sử trong từ điển của chúng ta có các thực thể: “hôm nay”, “hôm”, “nay”, “thi”, “thi tốt nghiệp”, “thi tốt”..
-	Kiểm tra xem có thực thể “Hôm nay thi tốt” không.
-	Nếu có thì dừng lại và kết thúc quá trình.
-	Nếu không có thì tách bớt âm tiết cuối ra, kiểm tra có thực thể “Hôm nay thi” trong kho ngữ liệu hay không.
-	Nếu có thì dừng lại và kiểm tra phần còn lại của câu (cụ thể ở đây là “tốt”).
-	Nếu không có thì tách bớt âm tiết cuối ra, kiểm tra có thực thể “Hôm nay” trong kho ngữ liệu hay không.
-	Nếu có thì dừng lại và kiểm tra phần còn lại của câu (cụ thể ở đây là “thi tốt”).
Với giải thuật trên ta có thể nhận được tập thực thể (tương ứng với một từ điển cụ thể): “hôm nay”, “thi tốt”.
Thuật toán đối sánh từ phải qua ngược với thuật toán trên là lấy chuỗi dài nhất từ cuối câu. Khi cắt chuỗi hay âm tiết thì cắt phần bên trái nhất đi, giữ lại phần bên phải. Khi kết thúc thuật toán ta phải đảo ngược thứ tự các thực thể để có được trật tự các thực thể như trong câu ban đầu.
Đối với tiếng Việt, độ chính xác của thuật toán đối sánh từ phải qua cao hơn thuật toán đối sánh từ bên trái qua.
Ví dụ: Xét câu “Ban công tác hoàn thành nhiệm vụ”.
Giả sử trong kho ngữ liệu có các thực thể: “ban”, “ban công”, “công tác”, “hoàn thành”, “nhiệm vụ”. 
Kết quả phân tích của giải thuật đối sánh từ trái qua là: “ban công”, “hoàn thành”, “nhiệm vụ”.
Kết quả phân tích của giải thuật đối sánh từ phải qua là: “nhiệm vụ”, “hoàn thành”, “công tác”, “ban”.  Thay đổi thứ tự các thực thể ta được “ban”, “công tác”, “hoàn thành”, “nhiệm vụ”.
Chúng ta nhận thấy kết quả từ giải thuật đối sánh từ phải tốt hơn rất nhiều giải thuật từ trái qua.


























Hình 6: Giải thuật tách thực thể từ trái qua.
Tuy nhiên, với những câu phức tạp như “Học sinh học sinh học” thì cả giải thuật đối sánh từ trái qua cũng như từ phải qua đều không thể có được kết quả chính xác. Hình dưới là lưu đồ giải thuật cho giải thuật đối sánh từ phải qua.




























Hình 7: Giải thuật tách thực thể từ phải qua

2.7.4. Ưu điểm và nhược điểm
Thuật toán Minimax Matching có ưu điểm và nhược điểm như sau:
Ưu điểm:
•	Độ chính xác: Thuật toán Minimax Matching sử dụng thông tin ngữ cảnh và xác suất xuất hiện để tính điểm cho các từ, từ đó giúp tăng độ chính xác trong quá trình phân đoạn từ.
•	Linh hoạt: Thuật toán có thể được điều chỉnh và tùy chỉnh để phù hợp với yêu cầu cụ thể của từng bài toán phân đoạn từ. Có thể thay đổi hàm tính điểm, sử dụng các thông tin ngữ cảnh khác nhau, hoặc kết hợp với các phương pháp khác để cải thiện hiệu suất.
•	Tính tổng quát: Minimax Matching không yêu cầu kiến thức ngôn ngữ cụ thể và có thể được áp dụng cho nhiều ngôn ngữ khác nhau.
Nhược điểm:
•	Phụ thuộc vào dữ liệu huấn luyện: Độ chính xác của thuật toán Minimax Matching phụ thuộc vào dữ liệu huấn luyện có sẵn. Nếu dữ liệu huấn luyện không đại diện cho đa dạng ngôn ngữ và ngữ cảnh, kết quả phân đoạn từ có thể không chính xác.
•	Đòi hỏi tài nguyên tính toán: Thuật toán Minimax Matching có thể đòi hỏi tài nguyên tính toán đáng kể, đặc biệt khi áp dụng cho các văn bản dài hoặc trong các ứng dụng thời gian thực.



 

CHƯƠNG 3: PHÂN TÍCH THIẾT KẾ HỆ THỐNG

3.1.	Khảo sát và phân tích hệ thống
3.1.1.	Phân tích hệ thống
-	Các nhóm chức năng hệ thống có thể chia làm các nhóm chức năng chính sau:
●	Nhóm chức năng chung: đăng nhập, xem thông tin cá nhân, chỉnh sửa thông tin cá nhân, đổi mật khẩu.
●	Nhóm chức năng cho người dùng: tìm kiếm sản phẩm, xem sản phẩm, thực hiện mua sản phẩm, đánh giá sản phẩm (bình luận), mô tả bằng ngôn ngữ tự nhiên để tìm kiếm sản phẩm quản lý
●	Nhóm chức năng dành cho người quản lý đơn đặt hàng.
●	Nhóm chức năng quản lý dành cho người quản trị bao gồm quản lý danh sách khách hàng, quản lý sản phẩm, quản lý……
-	Xác định các tác nhân hệ thống:
●	Khách hàng: người sử dụng hệ thống.
●	Nhân viên: người thực hiện các chức năng quản lý đơn hàng.
●	Admin: người điều hành, quản lý và theo dõi tất cả các hoạt động của hệ thống.
3.1.2.	Xác định các Use case và xây dựng Biểu Use case chi tiết
-	Tác nhân khách hàng có các use case sau:
+	Đăng ký.
+	Quản lý giỏ hàng.
+	Xem chi tiết sản phẩm.
+	Thêm sản phẩm vào giỏ hàng
+	Mua hàng.
+	Quản lý đơn hàng.
+	Đánh giá nhận xét về sản phẩm.
+	Tìm kiếm sản phẩm.
-	Nhóm chức năng nhân viên:
+	Quản lý đơn hàng đã đặt.
+	Quản lý hóa đơn nhập sản phẩm.
-	Nhóm chức năng admin: 
+	Quản lý khách hàng.
+	Quản lý sản phẩm.
+	Quản lý nhân viên.
+	Quản lý danh mục các loại hoạt động.
+	Quản lý môi trường sử dụng sản phẩm.
+	Quản lý danh mục sản phẩm.
+	Quản lý nhà cung cấp.
+	Quản lý đơn vị sản phẩm.
+	Quản lý nhãn hiệu.
+	Thống kê.
-	Ngoài ra, các thành viên trong hệ thống bao gồm khách hàng, nhân viên, admin có các use case như sau:
+	Đăng nhập, đăng xuất.
+	Quản lý thông tin cá nhân.
3.2.	Lược đồ usecase tổng quát
 
Hình 8: Lược đồ use case Tổng quát.
Các chức năng của chương trình được thể hiện trong lược đồ use case tổng quát được thể hiện trong Hình 4, trong hệ thống có các tác nhân nhân viên, quản trị viên và khách hang mỗi tác nhân sẽ tương tác với các chức năng cụ thể được mô tả ở trên. 
3.3.	Các use case trong hệ thống
3.3.1.	Use case của nhân viên
●	Use case Quản lý đơn đặt hàng
 
Hình 9:Biểu đồ Use case quản lý đơn đặt hàng.


Tên use case	Quản lý đơn đặt hàng
Tác nhân	Nhân viên.
Mô tả	Use case cho phép xem, cập nhật trạng thái, tìm kiếm đơn hàng khách hàng đã đặt hàng.
Tiền điều kiện	Nhân viên đã đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Nhân viên kinh doanh đăng nhập vào hệ thống xem danh sách đơn hàng đã đặt. Có thể tìm kiếm đơn hàng theo yêu cầu.
2.	Tìm kiếm đơn hàng nhân viên sẽ nhập các thông tin cần tìm kiếm tại ô tìm kiếm, sau                đó nhấn vào button “Tìm kiếm” hệ thống sẽ trả về danh sách các kết quả ứng với yêu cầu.
3.	Nhân viên thực hiện xem chi tiết từng đơn hàng và xác nhận đơn hàng, cập nhật trạng thái đơn hàng.
4.	Hệ thống tiếp nhận yêu cầu, xử lý thông tin và trả về thông báo cho nhân viên và gửi email thông báo cho khách hàng về trạng thái của đơn hàng sau khi được cập nhật.
5.	Kết thúc use case.
Ngoại lệ:
1.1.a. Không có đơn hàng nào ứng với nhu cầu tìm kiếm của nhân viên tương ứng với dữ liệu nhập vào.

Hậu điều kiện	Nhân viên cập nhật thành công trạng thái đơn hàng.
Bảng 2: Bảng Quản lý đơn đặt hàng.
3.3.2.	Use Case của Quản trị viên
Quản lý hóa đơn nhập sản phẩm 
 
Hình 10:Biểu đồ Use case quản lý hóa đơn nhập sản phẩm.
Use Case	Quản lý hóa đơn nhập sản phẩm
Tác nhân	Quản trị viên
Mô tả	Use case cho phép nhân viên thực hiện xem danh sách hóa hơn nhập sản phẩm, và tạo hóa đơn nhập sản phẩm.
Điều kiện	Nhân viên đã đăng nhập vào hệ thống.
Luồng sự kiện chính:
-	Xem danh sách hóa đơn nhập:

Luồng sự kiện chính	1.	Nhân viên có nhập khoảng thời gian muốn xem hóa đơn trong khoảng thời gian đó. Và không nhập thì sẽ trả ra danh sách toàn bộ hóa đơn.
2.	Hệ thống sẽ tiếp nhận và xử lý thông tin trả về kết quả như yêu cầu của nhân viên.
3.	Kết thúc use case.
Ngoại lệ	Không có

-	Tạo hóa đơn nhập sản phẩm:

Luồng sự kiện chính	1.	Nhân viên sẽ thêm từng sản phẩm với số lượng, giá tiền tương ứng.
2.	Hệ thống tiếp nhận yêu cầu, xử lý và thực hiện lưu thông tin vào CSDL sau đó trả về thông báo cho nhân viên.
3.	Kết thúc use case.
Ngoại lệ	2.1. Hệ thống gặp vấn đề khi xử lý dữ liệu đầu vào.
2.2. Thông báo kết quả tạo hóa đơn nhập sản phẩm thất bại.

Bảng 3: Bảng Quản lý hóa đơn nhập sản phẩm.

Use case quản lý sản phẩm
 
Hình 11:Biểu đồ Use case Quản lý sản phẩm.



















Use-case	Nội dung
Tên use case	Quản lý sản phẩm.
Tác nhân	Quản lý.
Mô tả	Use case cho phép người admin thực hiện các thao tác quản lý sản phẩm bao gồm: thêm, xem, chỉnh sửa, khóa sản phẩm. 
- Tạo sản phẩm:
 
Luồng sự kiện chính	1. Người dùng click vào nút “Thêm sản phẩm” dưới gốc phải màn hình.
2. Hệ thống hiển thị giao diện để nhập thông tin sản phẩm mới.
3. Nhập thông tin sản phẩm sau đó ấn Lưu.
4. Hệ thống tiếp nhận yêu cầu và xử lý thông tin cập nhật vào CSDL và trả thông báo thành công về màn hình. Nếu không thành công thì rẽ nhánh A1.
5. Kết thúc use-case.
Ngoại lệ	1. Thông báo lỗi và hiển thị form nhập lại các thông tin.  
2. Nếu người dùng thực hiện nhập lại thì quay lại bước 2 hoặc có thể hủy và thoát ra bên ngoài.
3. Kết thúc use-case.
 
  
- Sửa:
 
Luồng sự kiện chính	1. Nhấn chọn vào nút chỉnh sửa sản phẩm là icon bút chì ở gốc phải trên mỗi sản phẩm.
2. Hệ thống hiển thị chi tiết sản phẩm và chỉnh sửa các thông tin mong muốn và sau đó nhấn nút “Lưu”.
3. Hệ thống kiểm tra và tra về kết quả. Nếu thất bại thì rẽ nhánh A1. Thành công thì cập nhật thông tin và thông báo thành công.
4.Kết thúc use-case
Ngoại lệ	1. Thông báo lỗi hiển thị form nhập lại các thông tin.
2. Nếu người dùng nhập lại thì quay lại bước 2 hoặc hủy việc chỉnh sửa thoát ra ngoài.
3. Kết thúc use-case.
 
Khóa / Mở khóa:
 
Luồng sự kiện chính	1. Nhấn chọn vào nút khóa (mở khóa) sản phẩm.
2. Hệ thống hiển thị popup nhấn “Xác nhận” để lưu kết quả hoặc nhấn “Hủy” để hủy bỏ thao tác.
3. Hệ thống kiểm tra và tra về kết quả.
4. Kết thúc use-case

Ngoại lệ	Không
Bảng 4: Bảng đặc tả use case Quản lý sản phẩm.

Use case thống kê doanh thu
 
Hình 12:Biểu đồ Use case Thống kê.

Use-case	Nội dung
Tên use-case	Thống kê.
Tác nhân	Quản trị viên.
Mô tả	Use case cho phép admin có thể thống kê các sản phẩm bán chạy, xem được doanh thu cửa hàng và xuất báo cáo tương ứng.
Tiền điều kiện	Admin đã đăng nhập vào hệ thống.
Luồng sự kiện chính	1.	Khi Admin chọn xem thống kê doanh thu hoặc thống kê sản phẩm. 
2.	Form thống kê hiển thị. Tại select button chọn tháng và năm muốn xem thống kê sau đó ấn icon “Tìm kiếm”.
3.	Hệ thống sẽ hiển thị các thông tin cần thiết đúng với yêu cầu lên giao diện.
4.	Ấn button “Xuất File báo cáo” để xuất báo cáo dưới dạng Excel.
5.	Kết thúc use case.
Ngoại lệ	
Bảng 5: Bảng đặc tả use case Thống kê.
Use Case quản lý nhân viên
 
Sơ đồ 5: Usecase Quản lí nhân viên.

Tên use case	Quản lý nhân viên.
Tác nhân	Quản trị viên.
Mô tả	Use case cho phép admin thực hiện các chức năng tạo, tìm kiếm, xem và khóa tài khoản nhân viên.
Tiền điều kiện	Admin đang đăng nhập vào hệ thống.
-	Cấp tài khoản cho nhân viên:
Luồng sự kiện chính	1.	Sau khi ấn vào button “Cấp tài khoản cho nhân viên” sẽ hiển thị ra form nhập thông tin để cấp tài khoản cho nhân viên.
2.	Admin thực hiện nhập các thông tin cần thiết và sau đó ấn button “Lưu”.
3.	Hệ thống tiếp nhận yêu cầu, xử lý thông tin và cập nhật vào CSDL và trả về thông báo thành công cho admin. 
4.	Kết thúc use case.
Ngoại lệ	3.1. Hệ thống xử lý và báo về kết quả không thành công.
3.2. Hiển thị form nhập cho admin chỉnh sửa lại thông tin nếu muốn thực hiện tiếp thì quay lại bước 2.
3.3. Nếu không muốn cập nhật thì quay lại màn hình chính.
3.4. Kết thúc use case.
-	Chỉnh sửa thông tin nhân viên:

Luồng sự kiện chính	1.	Sau khi ấn icon “Bút chì” ở gốc phải mỗi nhân viên tương ứng. Hiển thị form chỉnh sửa thông tin nhân viên.
2.	Admin thực hiện chỉnh sửa các thông tin cần thiết rồi sau đó ấn button “Lưu”.
3.	Hệ thống tiếp nhận yêu cầu, xử lý thông tin và cập nhật vào CSDL và trả về thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	3.1. Hệ thống xử lý và báo về kết quả cập nhật không thành công.
3.2. Hiển thị lại form chỉnh sửa cho admin thực hiện nếu muốn thực hiện chỉnh sửa lại thì quay về bước 2.
3.3. Nếu không muốn chỉnh sửa thì quay lại màn hình chính.
3.4. Kết thúc use case.
-	Khóa/Mở khóa nhân viên:

Luồng sự kiện chính	1.	Nhấn chọn vào icon “Khóa/Mở khóa”
2.	Hiển thị hộp thoại xác nhận.
3.	Click “Xác nhận” để khóa/mở khóa
4.	Hệ thống sẽ tiếp nhận yêu cầu và xử lý thông tin cập nhật vào CSDL và thông báo kết quả cho admin.
5.	Kết thúc use-case.
Ngoại lệ	Không có
-	Tìm kiếm và xem thông tin nhân viên:

Luồng sự kiện chính	1.	Admin nhập thông tin vào Text button và ấn vào icon “Tìm kiếm”.
2.	Hệ thống tiếp nhận yêu cầu, xử lý và trả về danh sách các sản phẩm.
3.	Admin ấn vào thẻ card các sản phẩm để xem thông tin của từng sản phẩm.
4.	Kết thúc use case.
Ngoại lệ	Không có

Hậu điều kiện	Admin thực hiện cấp tài khoản, cập nhật thông tin cho nhân viên thành công. 
Bảng 6: Bảng đặc tả use case Quản lý nhân viên.
Usecase quản lý khách hàng
 
Hình 13: Biểu đồ Usecase Quản lý khách hàng.
Tên use case	Quản lý khách hàng.
Tác nhân	Quản trị viên.
Mô tả	Use case cho phép admin thực hiện khóa tài khoản khách hàng.
Tiền điều kiện	Admin đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Admin xem được danh sách tài khoản khách hàng trong hệ thống.
2.	Admin có thể tìm kiếm khách hàng khi nhập thông tin tìm kiếm và ấn icon “Tìm kiếm” hệ thống xử lý và trả về kết quả theo yêu cầu.
3.	Admin chọn chức năng khóa tài khoản người dùng.
4.	Hệ thống tiếp nhận yêu cầu và xử lý thông tin.
5.	Hệ thống kiểm tra xác nhận hợp hệ sẽ cập nhật vào CSDL và thông báo kết quả khóa thành công.
6.	Kết thúc use case.
Ngoại lệ: Không có
Hậu điều kiện	Không có.
Bảng 7: Bảng đặc tả use case Quản lý khách hàng.
Quản lý danh mục sản phẩm
 
Hình 14:Biểu đồ Use case Quản lý danh mục sản phẩm.
Tên use case	Quản lý danh mục sản phẩm.
Tác nhân	Admin.
Mô tả	Use case cho phép admin thực hiện các chức năng thêm, xóa, sửa danh mục sản phẩm.
Tiền điều kiện	Admin đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
-	Thêm danh mục:

Luồng sự kiện chính	1.	Admin chọn button “Thêm danh mục”.
2.	Hệ thống hiển thị form Thêm danh mục. Admin nhập tên danh mục sản phẩm tại textbutton và ấn “Lưu”.
3.	Hệ thống tiếp nhận và xử lý thông tin đồng thời lưu dữ liệu vào CSDL và thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	2.1. Không thể nhập trùng tên danh mục.

-	Chỉnh sửa danh mục:

Luồng sự kiện chính	1.	Tại mỗi thẻ danh mục sản phẩm click icon “Chỉnh sửa”.
2.	Hệ thống hiển thị form Chỉnh sửa danh mục. Admin nhập tên danh mục sản phẩm tại textbutton và ấn “Lưu”.
3.	Hệ thống tiếp nhận và xử lý thông tin đồng thời lưu dữ liệu vào CSDL và thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	2.1. Không thể nhập trùng tên danh mục.

-	Xóa danh mục:

Luồng sự kiện chính	1.	Tại mỗi thẻ danh mục sản phẩm click icon “Xóa”.
2.	Hệ thống hiển thị popup Xóa danh mục. Admin click chọn “Đồng ý” để xóa danh mục sản phẩm hoặc ấn “Hủy” để hủy thao tác xóa.
3.	Hệ thống tiếp nhận và xử lý thông tin đồng thời lưu dữ liệu vào CSDL và thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	2.1. Không thể xóa danh mục sản phẩm đã tồn tại trong danh sách sản phẩm.

Hậu điều kiện	Admin thực hiện được các chức năng thêm, xóa ,sửa danh mục sản phẩm thành công.
Bảng 8: Bảng đặc tả use case Quản lý danh mục sản phẩm.
Các chức năng: 
-	Quản lý nhãn hiệu
-	Quản lý môi trường sử dụng sản phẩm
-	Quản lý nhà cung cấp
-	Quản lý đơn vị sản phẩm
-	Quản lý danh mục các loại hoạt động
=> Tương tự chức năng Quản lý danh mục sản phẩm.
Quản lý banner
 
Hình 15:Biểu đồ Use case Quản lý banner.
Tên use case	Quản lý banner.
Tác nhân	Admin.
Mô tả	Use case cho phép admin thực hiện các chức năng thêm, xóa, sửa banner.
Tiền điều kiện	Admin đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
-	Thêm banner:

Luồng sự kiện chính	1.	Admin click button “Thêm banner”.
2.	Hệ thống hiển thị form Thêm danh mục. Admin nhập tên sản phẩm tại selectbutton và upload hình ảnh cho banner và ấn “Lưu”.
3.	Hệ thống tiếp nhận và xử lý thông tin đồng thời lưu dữ liệu vào CSDL và thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	2.1. Không thể tạo hai banner cùng lúc cho 1 sản phẩm.

-	Chỉnh sửa banner:

Luồng sự kiện chính	1.	Tại mỗi thẻ banner click icon “Chỉnh sửa”.
2.	Hệ thống hiển thị form Chỉnh sửa banner.  Admin nhập tên sản phẩm tại selectbutton và upload hình ảnh cho banner và ấn “Lưu”.
3.	Hệ thống tiếp nhận và xử lý thông tin đồng thời lưu dữ liệu vào CSDL và thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	2.1. Không thể tạo hai banner cùng lúc cho 1 sản phẩm.

-	Xóa banner:

Luồng sự kiện chính	1.	Tại mỗi thẻ banner click icon “Xóa”.
2.	Hệ thống hiển thị popup Xóa banner. Admin click chọn “Đồng ý” để xóa banner hoặc ấn “Hủy” để hủy thao tác xóa.
3.	Hệ thống tiếp nhận và xử lý thông tin đồng thời lưu dữ liệu vào CSDL và thông báo thành công cho admin.
4.	Kết thúc use case.
Ngoại lệ	Không có

Hậu điều kiện	Admin thực hiện được các chức năng thêm, xóa ,sửa banner thành công.
Bảng 9: Bảng đặc tả use case Quản lý banner.
3.3.3.	Use case của khách hàng
Use case mua hàng
  
Hình 16:Biểu đồ Use Case Mua hàng.

Tên use case	Mua hàng
Tác nhân	Khách hàng.
Mô tả	Use case cho phép khách hàng mua hàng tại hệ thống.
Tiền điều kiện	Khách hàng đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Sau khi khách hàng đã thêm thành công các sản phẩm cần mua vào “Giỏ hàng”. Hoặc chọn “Mua ngay” tại trang Chi tiết sản phẩm.
2.	Tại Form giỏ hàng có thể chọn mua tất cả sản phẩm trong giỏ hàng bằng cách nhấn checkbox “Tất cả”. Hoặc có thể mua từng sản phẩm thì click vào checkbox ở mỗi thẻ card sản phẩm. Thì sẽ hiện Tổng thanh toán ứng với số sản phẩm mình đã chọn.
3.	Nhấn button “Mua hàng” sẽ xuất hiện Form mua hàng ở đây đã có thông tin địa chỉ và số điện thoại nhận hàng. Khách hàng muốn thay đổi có thể chỉnh sửa theo ý muốn.
4.	Ấn button “Thanh toán” để chọn phương thức thanh toán bao gồm: Thanh toán khi nhận hàng và Thanh toán bằng ZaloPay. Nếu chọn “Thanh toán bằng ZaloPay” chuyển tới giao diện app ZaloPay.
5.	Sau khi chọn phương thức thì nhấn chọn button “Xác nhận phương thức thanh toán”.  
6.	Khi mua hàng thành công thì sẽ cập nhật lại giỏ hàng của khách hàng.
7.	Hệ thống sẽ tiếp nhận yêu cầu, xử lý thông tin sau đó lưu vào CSDL và chuyển về trang Đơn hàng đã đặt.
8.	Kết thúc use case.
Ngoại lệ:
4.1. Thanh toán ZaloPay bị lỗi không thể thanh toán.
Hậu điều kiện	Khách hàng mua hàng tại hệ thống thành công.
Bảng 10: Bảng đặc tả use case Mua hàng.

Quản lý đơn hàng
 
Hình 17: Biểu đồ Use case Quản lý đơn hàng.
Tên use case	Quản lý đơn hàng
Tác nhân	Khách hàng.
Mô tả	Use case cho phép khách hàng quan sát trạng thái đơn hàng đã đặt, hủy đơn hàng và xem danh sách đơn hàng đã mua thành công  tại hệ thống.
Tiền điều kiện	Khách hàng đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
-	Xem danh sách trạng thái đơn hàng và danh sách đơn hàng đã mua:

Luồng sự kiện chính	1.	Khi vào trang Trạng thái đơn hàng.
2.	Hiển thị Form danh sách các đơn hàng đã đặt và có thể quan sát trạng thái đơn hàng và có thể hủy đơn hàng.
3.	Click vào tab Đã mua để xem danh sách đơn hàng đã mua thành công để thực hiện tạo đánh giá.
4.	Kết thúc use case.
Ngoại lệ	Không có

-	Hủy đơn hàng: 

Luồng sự kiện chính	1.	Ở trang Trạng thái đơn hàng tương ứng mỗi sản phẩm sẽ có button “Hủy đơn mua” với trạng thái Đang chờ xác nhận.
2.	Click vào button “Hủy đơn hàng” để hủy đơn hàng mong muốn.
3.	Hệ thống tiếp nhận yêu cầu, xử lý và cập nhật dữ liệu vào CSDL sau đó thông báo kết quả cho khách hàng.
4.	Kết thúc use case.
Ngoại lệ	2.1. Đơn hàng ở trạng thái “Đang chờ xác nhận” thì mới có thể hủy.

Hậu điều kiện	Khách hàng mua hàng tại hệ thống sẽ quan sát được trạng thái đơn hàng và có thể hủy đơn hàng.
Bảng 11: Bảng đặt tả use case Quản lý đơn hàng.







Đánh giá sản phẩm
 
Hình 18:Biểu đồ Use case Đánh giá sản phẩm.
Tên use case	Đánh giá sản phẩm.
Tác nhân	Khách hàng.
Mô tả	Use case cho phép khách hàng đặt hàng thành công tại hệ thống thực hiện đánh giá sản phẩm đó.
Tiền điều kiện	Khách hàng đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Khi khách hàng click vào tab “Đánh giá” hiển thị danh sách những sản phẩm khách hàng đã đặt hàng thành công được nhận hàng và khách hàng sẽ có thể tạo đánh giá cho sản phẩm.
2.	Khi click vào từng sản phẩm trong danh sách thì hiện form để điền thông tin đánh giá bao gồm textbutton “Comment” và chọn số sao tương ứng.
3.	Khi nhập xong thì ấn “Gửi”.
4.	Hệ thống thống tiếp nhận yêu cầu, xử lý cập nhật dữ liệu vào CSDL. Trả thông báo tạo đánh giá thành công cho khách hàng.
5.	Kết thúc use case.
Ngoại lệ:
4.1. Hệ thống bị lỗi xử lý trả về thông báo tạo thất bại.
Hậu điều kiện	Khách hàng mua hàng tại hệ thống thành công.
Bảng 12: Bảng đặc tả use case Đánh giá sản phẩm.

Use case đăng ký đăng nhập
 
Hình 19:Biểu đồ Use case đăng ký tài khoản.

Tên use case	Đăng ký thành viên
Tác nhân	Khách hàng
Mô tả	Use case cho phép người dùng đăng ký tài khoản.
Tiền điều kiện	Không có
Chuỗi sự kiện chính:
1.	Khách hàng mở giao diện đăng ký tài khoản trên app.
2.	Nhập thông tin đăng ký tài khoản bao gồm username và mật khẩu và nhấn vào nút “Đăng ký”. 
3.	Hệ thống kiểm tra thông tin và xác nhận hợp lệ.
4.	Hệ thống cập nhật thông tin đăng ký vào CSDL và Chuyển tới màn hình đăng nhập và đăng nhập tài khoản vừa tạo vào hệ thống.
5.	Hệ thống kiểm tra và xác nhận hợp lệ. Tại đây khách hàng nhập các thông tin của tài khoản tương ứng. Rồi ấn nút “Lưu”
6.	Hệ thống cập nhật thông tin đăng ký vào CSDL chuyển tới trang chủ.
7.	Kết thúc use case
Ngoại lệ:
3.a. Hệ thống báo thông tin nhập không hợp lệ.
3.a.1. Hệ thống yêu cầu nhập lại thông tin đăng ký.
3.a.2. Người dùng nhập lại thông tin đăng ký.

Hậu điều kiện	Sau khi đăng ký thành công Khách hàng có thể đăng nhập vào hệ thống.
Bảng 13: Bảng đặc tả use case Đăng ký thành viên.
 
Hình 20:Biểu đồ Use Case đăng ký đăng nhập.

Tên use case	Đăng nhập
Tác nhân	Khách hàng
Mô tả	Use case cho phép người dùng đăng nhập vào hệ thống.
Tiền điều kiện	Không có
Chuỗi sự kiện chính:
1.	Người dùng chọn chức năng đăng nhập.
2.	Hiển thị Form đăng nhập và yêu cầu nhập đầy đủ thông tin.
3.	Khách hàng, nhân viên, admin nhập thông tin là “username” và “mật khẩu” và nhấn nút Đăng nhập.
4.	Hệ thống kiểm tra thông tin nhập vào và trả về thông báo.
5.	Use case kết thúc.
Ngoại lệ:
3.a. Hệ thống báo thông tin nhập không hợp lệ.
3.a.1. Hệ thống yêu cầu nhập lại thông tin đăng nhập.
3.a.2. Người dùng nhập lại thông tin đăng nhập.

Hậu điều kiện	Sau khi đăng nhập thành công hệ thống sẽ cung cấp các chức năng tương ứng với từng tác nhân.
Bảng 14: Bảng đặc tả use case Đăng nhập.

Usecase quản lý tài khoản cá nhân
 
Hình 21: Biểu đồ Use case quản lý tài khoản cá nhân.

Tên use case	Xem thông tin cá nhân
Tác nhân	Khách hàng, nhân viên, admin.
Mô tả	Use case cho phép xem thông tin cá nhân.
Tiền điều kiện	Khách hàng, nhân viên, admin đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Người dùng chọn chức năng xem thông tin cá nhân.
2.	Form thông tin cá nhân hiển thị và hiển thị ra thông tin cá nhân theo yêu cầu.
Hậu điều kiện	Người dùng có thể xem thông tin cá nhân.
Bảng 15: Bảng đặc tả use case Xem thông tin cá nhân.

Tên use case	Cập nhật thông tin cá nhân
Tác nhân	Khách hàng, nhân viên, admin.
Mô tả	Use case cho phép chỉnh sửa xem thông tin cá nhân.
Tiền điều kiện	Khách hàng, nhân viên, admin đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Hiển thị Form thông tin cá nhân, trên giao diện hiển thị thông tin cá nhân và chức năng chỉnh sửa thông tin cá nhân.
2.	Người dùng thực hiện chỉnh sửa các thông tin cá nhân và nhấn nút Lưu.
3.	Hệ thống kiểm tra thông tin vừa chỉnh sửa và xác nhận hợp lệ.
4.	Hệ thống cập nhật thông tin vào CSDL và thông báo cập nhật thành công cho người dùng.
5.	Use case kết thúc.
Ngoại lệ:
3.a. Hệ thống thông báo nhập thông tin không hợp lệ.
3.a.1. Hệ thống yêu cầu nhập lại thông tin.
3.a.2. Người dùng nhập lại thông tin và quay lại bước 2.
Hậu điều kiện	Người dùng chỉnh sửa thông tin cá nhân thành công.
Bảng 16: Bảng đặc tả use case Cập nhật thông tin cá nhân.
Use Case quản lý giỏ hàng
 
Hình 22: Biểu đồ Use case quản lý giỏ hàng.
Tên use case	Quản lý giỏ hàng.
Tác nhân	Khách hàng.
Mô tả	Use case cho phép khách hàng quản lý giỏ hàng của mình tại hệ thống bao gồm các chức năng thêm xóa sửa sản phẩm có trong giỏ hàng.
Tiền điều kiện	Khách hàng đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Khách hàng đang ở giao diện giỏ hàng của mình.
2.	Click button “Xóa” để xóa sản phẩm tương ứng ra khỏi giỏ hàng.
3.	Hệ thống tiếp nhận yêu cầu, xử lý thông tin và cập nhật dữ liệu vào CSDL và thông báo kết quả lên màn hình.
4.	Kết thúc use case.
Ngoại lệ:Không có
Hậu điều kiện	Người dùng cập nhật thành công thông tin các sản phẩm số lượng trong giỏ hàng .
Bảng 17: Bảng đặc tả use case Quản lý giỏ hàng.
Tìm kiếm sản phẩm
 
Hình 23:Biểu đồ Use case Tìm kiếm sản phẩm.
Tên use case	Tìm kiếm sản phẩm.
Tác nhân	Khách hàng, Admin.
Mô tả	Use case cho phép khách hàng tìm kiếm sản phẩm trong cửa hàng.
Tiền điều kiện	Khách hàng và admin đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Tại danh sách sản phẩm nhập dữ liệu cần vào Textbutton sau đó nhấn icon “Tìm kiếm”.
2.	Hệ thống tiếp nhận yêu cầu, xử lý và trả về kết quả theo yêu cầu.
3.	Kết thúc use case.
Ngoại lệ:Không có
Hậu điều kiện	Người dùng tìm kiếm được các sản phẩm theo nhu cầu của mình .
Bảng 18: Bảng đặc tả use case Tìm kiếm sản phẩm.





Xem danh sách sản phẩm
 
Hình 24:Biểu đồ Use case Xem danh sách sản phẩm.
Tên use case	Xem danh sách sản phẩm.
Tác nhân	Khách hàng.
Mô tả	Use case cho phép khách hàng tìm kiếm, xem thông tin chi tiết sản phẩm sau đó có thể thêm sản phẩm vào giỏ hàng.
Tiền điều kiện	Khách hàng đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Tại trang chủ hiển thị danh sách các sản phẩm trong cửa hàng. Khách hàng có thể tìm kiếm và xem chi tiết từng sản phẩm.
2.	Click vào từng sản phẩm để xem chi tiết sản phẩm. Trong này bao gồm thông tin của sản phẩm và những đánh giá của sản phẩm đó.
3.	Tại form chi tiết sản phẩm có thể thêm sản phẩm vào giỏ hàng với button “Thêm sản phẩm vào giỏ hàng” hoặc có thể click “Mua ngay” để mua trực tiếp sản phẩm đó.
4.	Kết thúc use case.
Ngoại lệ:Không có
Hậu điều kiện	Người dùng tìm kiếm được, xem và thêm vào giỏ hàng các sản phẩm theo nhu cầu của mình .
Bảng 19: Bảng đặc tả use case Xem danh sách sản phẩm.
Thêm sản phẩm vào giỏ hàng
 
Hình 25:Biểu đồ Use case Thêm sản phẩm vào giỏ hàng.
Tên use case	Thêm sản phẩm vào giỏ hàng.
Tác nhân	Khách hàng.
Mô tả	Use case cho phép khách hàng xem thông tin chi tiết sản phẩm sau đó có thể thêm sản phẩm vào giỏ hàng.
Tiền điều kiện	Khách hàng đang đăng nhập vào hệ thống.
Chuỗi sự kiện chính:
1.	Tại trang “Chi tiết sản phẩm” khách hàng click vào button “Thêm vào giỏ hàng” thì hiển thị popup sản phẩm đó.
2.	Tại popup khách hàng có thể điều chỉnh được số lượng sản phẩm muốn thêm thông qua hai icon “-” giảm đi và “+” tăng thêm.
3.	Hệ thống tiếp nhận thông tin và xử lý và trả về thông báo thành công cho khách hàng.
4.	Kết thúc use case.
Ngoại lệ:
3.1. Hệ thống xử lý và trả về kết quả không thành công.
Hậu điều kiện	Người dùng xem và thêm vào giỏ hàng các sản phẩm theo nhu cầu của mình .
Bảng 20: Bảng đặc tả use case Thêm sản phẩm vào giỏ hàng.

3.4.	Biểu đồ tuần tự các chức năng chính
3.4.1.	Khách hàng
Mua hàng
 
Hình 26: Biểu đồ tuần tự Mua hàng.
Ở hình trên mô tả tác vụ mua hàng của khách hàng bằng phương thức thanh toán điện tử
Đánh giá sản phẩm
 
Hình 27: Biểu đồ tuần tự Đánh giá sản phẩm.
Quản lý đơn hàng
 
Hình 28: Biểu đồ tuần tự Quản lý đơn hàng.
3.4.2.	Admin
Quản lý hóa đơn nhập sản phẩm
 
Hình 29: Biểu đồ tuần tự Quản lý hóa đơn nhập sản phẩm.
Thống kê
 
Hình 30: Biểu đồ tuần tự Thống kê. 
Quản lý sản phẩm
 
Hình 31: Biểu đồ tuần tự Quản lý sản phẩm.
3.4.3.	Nhân viên
Quản lý đơn đặt hàng
 
Hình 32: Biểu đồ tuần tự Quản lý đơn đặt hàng. 

CHƯƠNG 4: THIẾT KẾ DỮ LIỆU

4.1.	Mô hình thực thể quan hệ
 
Hình 33: Mô hình thực thể quan hệ (ERD)
Users(người dùng):
-	Gồm các trường: id, username, password, fullname, address, email, phone,, roleId, status, avatar_url, public_id
-	1 user chỉ có 1 role
-	1 user chỉ có 1 image
-	1 user có thể thêm nhiều cart_item
-	1 user có thể quản lý nhiều order
-	1 user có thể đánh giá nhiều sản phẩm
Product(Sản phẩm):
-	Gồm các trường: id, name, description, price, stock_quantity, categoryId, discount, active, image_url, public_id
-	1 product có thể được thêm vào nhiều cart_item
-	1 product có thể thuộc nhiều orderItem
-	1 product chỉ có một đơn vị, một hoạt động, một môi trường sử dụng, một danh mục sản phẩm, một nhãn hiệu sản phẩm, một nhà cung cấp, một banner
Category(danh mục sản phẩm):
-	Gồm các trường: id, name, active
-	1 Category có thể có nhiều sản phẩm
Order(đơn hang):
-	Gồm các trường: id, createdDate, customerId, orderAddress, status, staffId,, 
-	1 order chỉ được tạo bởi 1 user (khách hàng)
-	1 order có thể có nhiều order_item

OrderItem(chi tiết đơn hàng):
-	Gồm các trường: id, orderId, productId, quantity
-	1 orderdetails chỉ thuộc 1 order
-	1 orderdetails chỉ chứa 1 product
-	1 orderdetails tương ứng với 1 feedback

CartItem(giỏ hang):
-	Gồm các trường: id, productId, quantity, price_capital
-	1 cartItem chỉ thuộc 1 cart
-	1 cartItem chỉ chứa 1 product

Import_Product(phiếu nhập hàng)
-	Gồm các trường: id, productId, quantity, price_import, date_import
-	1 phiếu nhập sẽ có thể nhập nhiều sản phẩm


 
4.2.	Lược đồ cơ sở dữ liệu mức khái niệm
 
Hình 34: Lược đồ cơ sở dữ liệu mức khái niệm
Hình 30 là lược đồ cơ sở dữ liệu ở mức khái niệm mô tả rõ hơn về cách dữ liệu được tổ chức và liên kết với nhau ở mức trừu tượng không phụ thuộc vào bất kỳ hệ quản trị cơ sở dữ liệu cụ thể nào.
4.3.	Lược đồ cơ sở dữ liệu
 
Hình 35: Lược đồ cơ sở dữ liệu mức vật lý
Hình 31 mô tả lược đồ cơ sở dữ liệu mức vật lý của database MySQL, mô tả cách dữ liệu được tổ chức và lưu trữ trong cơ sở dữ liệu MySQL. 
4.3.	Các bảng dữ liệu
4.3.1.	Bảng User
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã người dùng
Username	Nvarchar(50)	No	Unique	Tên đăng nhập
Password	Nvarchar(50)	No		Mật khẩu
FullName	Nvarchar(255)	No		Tên người dùng
Address	Nvarchar(255)	Yes		Địa chỉ người dùng
Email	Nvarchar(255)	Yes		Email người dùng
Phone	Nvarchar(10)	No		Số điện thoại người dùng
AvatarUrl	Nvarchar(255)	Yes		Mã hình ảnh đại diện
Role_id	BigInt	No		Id vai trò người dùng
Birthday	Date			Ngày sinh
Status	Bit	No		Trạng thái tài khoản
PublicId	Nvarchar(50)	Yes		Id hình đại diện
Bảng 21: Bảng User.

4.3.2.	Bảng Product
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã sản phẩm
ProductName	Nvarchar(50)	No		Tên sản phẩm
Description	Nvarchar(2000)	Yes		Mô tả sản phẩm
Price	Float	No		Giá sản phẩm
StockQuantity	Int	No		Số lượng sản phẩm
CategoryId	Int	No	Foreign Key	Mã thương hiệu
Active	Bit	No		Trạng thái kinh doanh sản phẩm
Id_Activity	BigInt	No	Foreign Key	Mã hoạt động
Id_Brand	BigInt	No	Foreign Key	Mã nhãn hiệu
Id_Environment	BigInt	No	Foreign Key	Mã môi trường sử dụng
Id_supplier	BigInt	No	Foreign Key	Mã nhà cung cấp
Id_Unit	BigInt	No	Foreign Key	Mã đơn vị
Bảng 22: Bảng Product.

4.3.3.	Bảng Category
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã danh mục
Category_Name	Nvarchar(50)	No		Tên danh mục
Image_Url	Nvarchar(50)	No		Đường dẫn ảnh
Public_Id	Nvarchar(50)	No		Mã ảnh
Bảng 23: Bảng Category.
4.3.4.	Bảng CartItem
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã chi tiết giỏ hàng
Id_Customer	BigInt	No	Foreign Key	Mã khách hàng
productId	BigInt	No	Foreign Key	Mã sản phẩm
quantity	BigInt	No		Số lượng sản phẩm
Bảng 25: Bảng CartItem.

4.3.5.	Bảng Order
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã đơn hàng
CustomerId	BigInt	No	Foreign Key	Mã khách hàng tạo đơn
Order_Date	Date	No		Ngày mua hàng
Shipping_Date	Date	No		Ngày mua hàng
Shipping_Address	Nvarchar(300)	No		Địa chỉ giao hàng
Order_status	Int	No		Trạng thái đơn hàng
name_reciver	Nvarchar(500)	Yes		Tên người nhận
SDT	Nvarchar(11)	Yes		Số điện thoại người nhận
Bảng 26: Bảng Order.
4.3.6.	Bảng OrderItem
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã chi tiết hóa đơn
OrderId	BigInt	No	Foreign Key	Mã đơn hàng
ProductId	BigInt	No	Foreign Key	Mã sản phẩm
Quantity	BigInt	No		Số lượng
price	Float	No		Gía lúc mua
Bảng 27: Bảng OrderItem.
4.3.7.	Bảng Supplier
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã nhà cung cấp
Supplier_Name	Nvarchar(255)	No		Tên nhà cung cấp
Bảng 28: Bảng Supplier.

4.3.8.	Bảng Environment
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã
Environment_Name	Nvarchar(255)	No		Tên môi trường
Bảng 29: Bảng Environment.

4.3.9.	Bảng OrderStatus
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã trạng thái đơn hàng
OrderStatus_Name	Nvarchar(255)
	No		Tên trạng thái đơn hàng
OrderStatus_Detail	Nvarchar(255)
			Mô tả trạng thái đơn hàng
Bảng 30: Bảng OrderStatus.

4.3.10.	Bảng Banner
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã banner
Id_Product	BigInt 	No	Foreign Key	Mã sản phẩm
Url_image	Nvarchar(255)
		Foreign Key	Đường dẫn của ảnh
Bảng 31: Bảng Banner.

4.3.11.	Bảng Import_Product_Detail
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã chi tiết phiếu nhập
Id_Import_product	BigInt 	No	Foreign Key	Mã phiếu nhập
Id_product	BigInt 	No	Foreign Key	Mã sản phẩm
Price_import	Float	No		Giá nhập sản phẩm
quantity	Float	No		Số lượng sản phẩm nhập vào
Bảng 32: Bảng Import_Product_Detail.

4.3.12.	Bảng Import_Product
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã phiếu nhập
Id_admin	BigInt 	No	Foreign Key	Mã người nhập kho
Date_import	Nvarchar(255)
			Ngày nhập kho
Bảng 33: Bảng Import_Product.

4.3.13.	Bảng Evaluate
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã đánh giá
star	int 	No		Đánh giá sao
Id_orderItem	BigInt 		Foreign Key	Mã sản phẩm trong đơn hang đã mua
Id_Product	BigInt 		Foreign Key	Mã sản phẩm
comment	Nvarchar(255)
			Bình luận về sản phẩm đã mua
Bảng 34: Bảng Evaluate.

4.3.14.	Bảng Brand
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã nhãn hiệu
Brand_Name	Nvarchar(255)
	No		Tên nhãn hiệu
Bảng 35: Bảng Brand.

4.3.15.	Bảng Unit
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã đơn vị đo
Unit_Name	Nvarchar(255)
	No		Tên đơn vị đo
Bảng 36: Bảng Unit.

4.3.16.	Bảng Activity
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã hoạt động
Activity_Name	Nvarchar(255)
	No		Tên hoạt động
Bảng 37: Bảng Activity.

4.3.17.	Bảng Roles
Tên cột
Field	Kiểu dữ liệu
Data type	Null	Ràng buộc
Constraint	Mô tả
Description
Id	BigInt	No	Primary Key, Auto	Mã vai trò
Role_Name	Nvarchar(255)
	No		Tên vai trò
Bảng 38: Bảng Roles. 
CHƯƠNG 5: SẢN PHẨM MINH HỌA ĐỀ TÀI

5.1.	Giao diện khách hàng
5.1.2.	Trang chủ
 
Hình 36: Màn hình trang chủ
 
5.1.2.	Đăng nhập
 
Hình 37: Màn hình đăng nhập
 
5.1.3.	Đăng ký
 
Hình 38: Màn hình đăng ký
 
5.1.4.	Trang tìm kiếm sản phẩm
 
Hình 39: Màn hình tìm kiếm sản phẩm


 
5.1.5.	Chi tiết sản phẩm
 
Hình 40 :Màn hình chi tiết sản phẩm
 
5.1.6.	Giỏ hàng
 
Hình 41: Giỏ hàng
 
5.1.7.	Sửa thông tin cá nhân
 
Hình 42: Cập nhật thông tin cá nhân
 
5.1.8.	Thông tin cá nhân
 
Hình 43: Thông tin cá nhân
 
5.1.9.	Đơn hàng đã mua
 
Hình 44: Đơn hàng đã mua
5.2.0.	Đánh giá sản phẩm
 
Hình 45: Đơn hàng đã mua

 
5.2.	Giao diện nhân viên
5.2.1.	Quản lý đơn hàng
 
Hình 31: Theo dõi đơn hàng
5.2.2.	Xem chi tiết đơn hàng và xuất hóa đơn
 
Hình 32: Chi tiết đơn hàng và xuất hóa đơn
 
5.3.	Giao diện Admin
5.3.1.	Quản lí sản phẩm
 
Hình 46: Quản lí sản phẩm

5.3.2.	Quản lí nhà cung cấp
 
Hình 47 : Quản lí nhà cung cấp
 
5.3.3.	Quản lí nhân viên
 
Hình 48: Quản lí tài khoản nhân viên
5.3.4.	Thống kê doanh thu và xuất báo cáo
 
Hình 49: Thống kê doanh thu và xuất báo cáo
5.3.5.	Quản lý banner
 
Hình 50: Quản lý banner
5.3.6.	Quản lý thương hiệu
 
Hình 51 : Quản lý thương hiệu
5.3.7.	Quản lý danh mục sản phẩm
 
Hình 52 : Quản lý danh mục sản phẩm

5.3.8.	Quản lý môi trường sử dụng sản phẩm
 
Hình 53 : Quản lý môi trường sử dụng sản phẩm



  
CHƯƠNG 6: KẾT LUẬN
6.1.	Kết luận
6.1.1.	Những kết quả đạt được
-	Tìm hiểu được nghiệp vụ kinh doanh dụng cụ thể thao trong thực tế, biết sử dụng những nghiệp vụ những yêu cầu trong thực tế vào trong việc lập trình ứng dụng. 
-	Nghiên cứu hệ quản trị cơ sỡ dữ liệu MySQL, hiểu và nắm rõ các khái niệm cũng như cách sử dụng của Framework SpringBoot.
-	Nghiên cứu và hiểu rõ hơn về ứng dụng cách làm ra một ứng dụng di động, cách ứng dụng vận hành, cách hoạt động của ứng dụng.
-	Áp dụng xây dựng ứng dụng kinh doanh dụng cụ thể thao trực tuyến.
-	Học hỏi về các công cụ và kỹ thuật kiểm tra ứng dụng di động.
-	Hiểu hơn về công nghệ ReactJS
-	Áp dụng được phương thức thanh toán của bên thứ ba (ZaloPay) vào ứng dụng để thực hiện quá trình thanh toán hóa đơn.
6.1.2.	Hạn chế
-	Giao diện chưa có tính thẩm mỹ cao
-	Hiệu năng của app khi nhiều người dùng không được tốt.
-	Chưa có chức năng đổi trả hàng linh hoạt
-	Chưa có chương trình tích lũy điểm, khuyến mãi giảm giá
6.1.3.	Hướng phát triển
-	Tìm hiểu thêm công nghệ, phần mềm ứng dụng mới để tối ưu giao diện và tốc độ xử lý.   
-	Bổ sung thêm các chức năng như tìm kiếm sản phẩm bằng hình ảnh
-	Áp dụng thêm một số phương thức thanh toán thịnh hành như MoMo, ApplePay
-	Giao diện người dùng của ứng dụng có thể được thiết kế đẹp mắt và dễ sử dụng hơn.
-	Thêm chức năng nhận thông báo về các giảm giá khuyến mãi
-	Tìm hiểu và phát triển chức năng đổi trả hàng.

                                                                    
TÀI LIỆU THAM KHẢO

Tiếng Việt:
1.	Tập thể tác giả, Lập trình Java căn bản, Nhà xuất bản Xây dựng, 2021.
2.	Lê Hoàng Sơn, Giáo trình lập trình Android, Nhà phát hành Gieobooks, 2022

Tiếng Anh:
1.	Joshua Bloch, Efective Java (2001).
2.	Kathy Siera, Bert bates, Head First Java
3.	T. H. Chiang, J. S. Chang, M. Y. Lin, and K. Y. Su, “Statistical models for word segmentation and unknown word resolution,” in Proceedings of Rocling V Computational Linguistics Conference V, 1992, pp. 123–146

Danh mục các Website tham khảo:
1.	Học lập trình cơ bản miễn phí: https://laptrinhjavaweb.com/trang-chu
2.	Spring Boot: https://loda.me/courses/spring-boot
3.	Android Tutorial: https://www.tutorialspoint.com/android/index.htm
4.	Android Studio Tutorial: https://www.javatpoint.com/android-tutorial



















