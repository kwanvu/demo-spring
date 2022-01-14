package web.demospringboot.database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.demospringboot.entity.BookEntity;
import web.demospringboot.entity.CategoryEntity;
import web.demospringboot.entity.UserEntity;
import web.demospringboot.repository.BookRepository;
import web.demospringboot.repository.CategoryRepository;
import web.demospringboot.repository.UserRepository;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, UserRepository userRepository, CategoryRepository categoryRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //initCategory
                CategoryEntity categoryA = new CategoryEntity("Giả tưởng & Khoa học viễn tưởng","A01",  null);
                logger.info("Insert data category: "+categoryRepository.save(categoryA));
                CategoryEntity categoryB = new CategoryEntity( "Huyền bí","B01", null);
                logger.info("Insert data category: "+categoryRepository.save(categoryB));
                CategoryEntity categoryC = new CategoryEntity( "Ly kì, Kinh dị","C01", null);
                logger.info("Insert data category: "+categoryRepository.save(categoryC));
                CategoryEntity categoryD = new CategoryEntity( "Lãng mạn","D01", null);
                logger.info("Insert data category: "+categoryRepository.save(categoryD));
                CategoryEntity categoryE = new CategoryEntity( "Thanh thiếu niên","E01", null);
                logger.info("Insert data category: "+categoryRepository.save(categoryE));
                CategoryEntity categoryF = new CategoryEntity("Trẻ em", "F01", null);
                logger.info("Insert data category: "+categoryRepository.save(categoryF));
                CategoryEntity categoryG = new CategoryEntity("Truyền cảm hứng, Tự lực, Tôn giáo","G01",  null);
                logger.info("Insert data category: "+categoryRepository.save(categoryG));
                CategoryEntity categoryH = new CategoryEntity("Tiểu sử, Tự truyện & Hồi ký","H01",  null);
                logger.info("Insert data category: "+categoryRepository.save(categoryH));
                //initBook
                BookEntity bookA = new BookEntity("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", 15.64f, "https://images-us.bookshop.org/ingram/9781501161933.jpg?height=500&v=v2", categoryB, null);
                logger.info("Insert data book: "+bookRepository.save(bookA));
                BookEntity bookB = new BookEntity("Cloud Cuckoo Land", "Anthony Doerr", 27.60f, "https://images-us.bookshop.org/ingram/9781982168438.jpg?height=500&v=v2-5e548f091c7c0e959bd9802dea0d8376", categoryC, null);
                logger.info("Insert data book: "+bookRepository.save(bookB));
                BookEntity bookC = new BookEntity("The Year of Magical Thinking", "Joan Didion", 14.72f, "https://images-us.bookshop.org/ingram/9781400078431.jpg?height=500&v=v2", categoryG, null);
                logger.info("Insert data book: "+bookRepository.save(bookC));
                //initUser: userA:pass:admin1
                UserEntity userA = new UserEntity("admin", "$2a$10$lNxq6wDY7imrYvB4IveHWeil1nxtfwOwNcCB8.2C6Sy9F27zVIZxe", "DemoSpring Admin", 8386.89f, 1, "ROLE_ADMIN", null);
                logger.info("Insert data user: "+userRepository.save(userA));
            }
        };
    }
}
