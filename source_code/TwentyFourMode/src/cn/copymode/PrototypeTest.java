package cn.copymode;

import java.io.IOException;

public class PrototypeTest {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Book book1 = new Book();  //书籍类
        Author author = new Author(); //作者类
        author.setName("corn");
        author.setAge(100);
        book1.setAuthor(author);
        book1.setTitle("好记性不如烂博客");
        book1.setPageNum(230);

        Book book2 = book1.deepClone();  //深复制
        
        System.out.println("类比较 : "+(book1 == book2));  // false
        System.out.println("基本类型比较 : "+(book1.getPageNum() == book2.getPageNum()));   // true
        System.out.println("引用类型比较 : "+(book1.getTitle() == book2.getTitle()));        // false
        System.out.println("引用类型比较 : "+(book1.getAuthor() == book2.getAuthor()));        // false
        
    }
}
