package practice;

import Homework.sentensies.User;

public class UserAppl {
    public static void main(String[] args) {

        User user=new User("peter@mail.com","Qw1234567");//создаем пользователя
        System.out.println(user);

        user.setPassword("Qw1234");
        System.out.println(user);


    }
}
