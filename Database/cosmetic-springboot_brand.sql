-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cosmetic-springboot
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) DEFAULT NULL,
  `description` text,
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=MyISAM AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (35,'Jumiso','  Jumiso, đây là một hãng mỹ phẩm mới vừa ra mắt đến công chúng tại Hàn Quốc trong thời gian vừa qua. Một hãng còn mới mẻ với các tín đồ mê skincare ở Việt Nam chúng ta. Jumiso là một nhãn hiệu phụ của thương hiệu HelloSkin, chuyên cung cấp mặt nạ và các sản phẩm chăm sóc da khác. Hãng ưu tiên sự hài lòng của khách hãng trên hết','3ce.png'),(2,'COSRXX','Đội ngũ mỹ phẩm Cosrx tin rằng mỹ phẩm nên tìm kiếm ý nghĩa nhiều hơn là chỉ làm đẹp. Vì vậy, chúng tôi được dành để cho phép cá nhân với từng loại da để giải quyết vấn đề. Có được sự tự tin, và tìm thấy vẻ đẹp của riêng mình. Chúng tôi đã thu thập những gì khách hàng cần và muốn liên quan đến các loại da và mối quan tâm của họ kể từ năm 2002 và cuối cùng là Mỹ phẩm + RX = COSRX Cosmetics đã được thành lập.','cosrx.png'),(3,'Background','Black Rouge là một thương hiệu đến từ đất nước Hàn Quốc và được ra đời từ năm 2016. Tuy là một thương hiệu mỹ phẩm mới ra mắt những năm gần đây nhưng đã chinh phục thị trường nhờ chất lượng và sự sáng tạo mới lạ trong từng sản phẩm. Ngoài những dòng son gây bão trên thị trường thì hãng còn cho ra các dòng sản phẩm làm đẹp khác như: phấn mắt, high lighter, nhũ mắt,…','background.png'),(4,'Dr.Jart','Dành riêng cho mục tiêu trọn đời là làm hài lòng bệnh nhân, bác sĩ Jart đã kết hợp nền tảng y tế của mình với đội ngũ 21 bác sĩ da liễu lành nghề để phát triển thương hiệu chăm sóc da cùng tên của mình. Kể từ khi thành lập, dòng sản phẩm vũ trụ đầy đủ đã phát triển để trở thành một trong những thương hiệu chăm sóc da hàng đầu châu Á - Ceramidin. Phương pháp nguyên tắc của bác sĩ dựa trên việc sử dụng các thành phần được chứng nhận khoa học và kiến thức chuyên môn của ông để mang lại kết quả đáng chú ý. Mỗi công thức chăm sóc da đều được thử và kiểm tra để đảm bảo an toàn cho mọi loại da, ngay cả da siêu nhạy cảm, vì vậy mọi người đều có thể trải nghiệm nghệ thuật chăm sóc da với bác sĩ Jart.','drjart.png'),(5,'Merzi','Merzy là thương hiệu mỹ phẩm đến từ thiên đường làm đẹp Hàn Quốc. Merzy mang đến cho khách hàng các sản phẩm trang điểm chất lượng tốt với giá cả cực kì phải chăng, phù hợp cho nhiều đối tượng khác nhau và đặc biệt là học sinh, sinh viên. Phương châm của Merzy là mỗi người đều có những nét riêng và Merzy sẽ giúp các nàng làm nổi bật những điểm riêng biệt của mình.','merzy.png'),(6,'Innisfree','Innisfree là một thương hiệu sinh sau đẻ muộn của tập đoàn Amorepacific. Được thành lập từ năm 2000, Innisfree nhanh chóng phát triển mạnh mẽ và sớm vươn lên thương hiệu số 1 của mỹ phẩm Hàn Quốc','innisfree.png'),(7,'Laneige','Dựa trên nguyên tắc cơ bản rằng nước, nguồn sống, là chìa khóa để duy trì làn da trẻ trung và rạng rỡ, Laneige liên tục thiết lập các xu hướng làm đẹp mới và cung cấp các sản phẩm chất lượng cao thông qua đổi mới. Thương hiệu làm đẹp cao cấp Hàn Quốc dành cho phụ nữ trẻ được dành riêng để làm đẹp và thấm nhuần niềm tin vào những khách hàng tận tụy của mình','laneige.png'),(8,'Pripera','Được thành lập vào năm 2006, Peripera thu hút các cô gái nữ tính với bộ sưu tập trang điểm nhấn mạnh màu môi sáng, màu mắt và màu móng gợi ý sự lãng mạn. Các màu sắc bắt mắt được bổ sung bởi bao bì màu sắc bão hòa và trẻ trung không kém. Thương hiệu nhắm đến những người phụ nữ trẻ, độc lập, có ý thức mạnh mẽ về bản thân và là người trao giải cá nhân. Thiết kế nữ tính và phong cách lãng mạn chiếm được trái tim của phụ nữ với vẻ đẹp.','peripera.png'),(9,'Benton','Chúc mừng từ Benton Cosmetics. Tên và định nghĩa của Benton lấy động cơ từ bộ phim. Trường hợp tò mò của Benjamin nút HP Trong phim, Benjamin được sinh ra như một ông già và anh ta trở nên trẻ hơn và trẻ hơn khi thời gian trôi qua và cuối cùng chết khi còn là một đứa trẻ mới chào đời. Chúng tôi đánh giá cao sự quan tâm sâu sắc của bạn đến Benton. Cách duy nhất để đền đáp niềm tin của bạn là cho chúng tôi làm cho niềm tin sản phẩm xứng đáng. Chúng tôi sẽ làm hết sức mình trong việc thực hiện niềm tin của bạn vào chúng tôi. Chúng tôi muốn chúc bạn một cuộc sống khỏe mạnh và hạnh phúc.','benton.png'),(10,'Wellage',NULL,'wellage.png'),(11,'Neogen','THƯƠNG HIỆU HOÀN HẢO CHO LÀN DA NHẠY CẢM','neogen.png'),(12,'Barulab','Công ty mỹ phẩm Hàn Quốc được thành lập năm 2002 với sự ra mắt trung tâm làm đẹp chống lão hóa đầu tiên Farbe. Sau đó, với nhiều năm kinh nghiệm hoạt động trong lĩnh vực phẫu thuật thẩm mỹ như BK Plastic Surgery, May Clinic, v.v… công ty đã cho ra mắt thương hiệu Barulab. Baru có nghĩa là phương pháp cổ truyền Hàn Quốc đúng đắn ghép cùng với Lab có nghĩa là thí nghiệm, Barulab là một tổ hợp mang ý nghĩa một trung tâm nghiên cứu mỹ phẩm để sửa lại những gì không đúng đắn. Barulab nhận các giải thưởng trong ngành làm đẹp năm 2017 và 2018 như số 1 trong những hãng mới thành lập - Self Beauty Awards 2017, Korea Brand Awards 2017 trao bởi danh mục ‘mỹ phẩm chức năng’, Asia Model Association 2018 trao bởi Hãng Mỹ Phẩm Hàn Quốc Chính Thức Official Cosmetics Brand. Sản phẩm chính của Barulab gồm các sản phẩm dưỡng da như mặt nạ, kem, xịt khoáng và cả trang điểm như kem BB','barulab.png'),(13,'Real Barier',NULL,'realbarrier.png'),(14,'Klavuu','Một danh từ của các từ Thụy Điển cho \"rõ ràng\" và \"quan điểm\", Klavuu xây dựng các loại dưỡng ẩm sâu của nó để làm sạch và làm rõ làn da của bạn. Mỗi loại thuốc tiên được chế tác với sự pha trộn giữa ngọc trai và thực vật có nguồn gốc từ biển, khơi gợi tình yêu của đại dương đối với đại dương trong mỗi loại kem, mặt nạ và sữa tắm.','klavuu.png'),(15,'Pyunkang Yul','Pyunkang Yul là thương hiệu được ra mắt bởi Phòng khám Đông y Pyunkang nổi tiếng, một tổ chức nổi tiếng về điều trị rối loạn da dị ứng.','pyunkang.png'),(16,'Heimish','Heimish (phát âm HEY-mish) là cái tên có sức hấp dẫn lớn trong ngành làm đẹp tại Hàn Quốc dù cho tuổi đời còn non trẻ. Heimish ra mắt vào tháng 3 năm 2016 và đã nhanh chóng trở thành một hiện tượng trong trường phái cổ điển trên thế giới, ưu tiên những sản phẩm mang tính hữu cơ thân thiện cho làn da.','heimish.png'),(17,'By Ecom','BY ECOM là một thương hiệu mỹ phẩm nội địa Hàn Quốc được tạo nên bởi beauty blogger nổi tiếng và \"ngàn follower\" ở xứ sở Kim Chi - Ecom.Với slogan \"Tin vào sức mạnh của nguyên liệu lành tính\" và được tạo nên bởi một người sành sỏi về làm đẹp được giới trẻ Hàn Quốc tin tưởng, dòng sản phẩm chăm sóc da và trang điểm của thương hiệu By Ecom đều được làm từ các nguyên liệu lành tính và có công dụng làm cho da trở nên khỏe khoắn và rạng rỡ hơn.','byecom.png'),(66,'hoai testtttt','uuuuuu','avatar.jpg'),(67,'hhhhh','hhhh','49949980_2158066171123776_1966653340016181248_n.jpg'),(64,'Black Rouge','Black Rouge ...','3ce.png'),(68,'vvvvvvvvvvvvvvvvvvvvvvv','aaaaaaaaaaaaaaaaaa','3c.png');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-01  0:01:30
