package practice;

import java.util.Objects;

// viktor . goloviznin @ gmail.com
/*
1) @ exists and only one (done) -> @ только  одна
2) dot after @ (done) -> должна быть точка после @ минимум одна
3) after last dot minimum 2 symbols (done) -> после последней точки должно быть минимум 2 символа
4) alphabetic, digits, _ , - , . , @  ->  разрешены буквы алфавита и цифры и некоторые символы
 */
public class User {
    //поля класса
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            System.out.println(email + " isn't valid.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            System.out.println("Password not valid");
        }
    }


    private boolean validateEmail(String email) {
        int indexAt = email.indexOf('@');  // ищем индекс @
        if (indexAt <= 0 || indexAt != email.lastIndexOf('@')) {  // проверяем наличие @ и что она 1
            return false;  // тогда вернем false
        }
        if (email.indexOf('.', indexAt) == -1) {   //не нашлась ".", начиная с позиции @
            return false;
        }
        if (email.indexOf('.') >= email.length() - 2) { //после "." не меньше 2 значений
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
                    || c == '_' || c == '-' || c == '.' || c == '@')) { //проверка на допустимые символы
                return false;
            }

        }
        return true;
    }


    /*
    1) min 8 symbols
    2) min one symbol of uppercase
    3) min one symbol of lowercase
    4) min one digit
    5) min one special symbol (!%@*&)
     */
    private boolean validatePassword(String password) {
        String symbols = "!%@*&#^()_+-";
        boolean[] test = new boolean[5];
        if (password.length() >= 8) {
            test[0] = true;
        }
        for (int i = 0; i < password.length(); i++) { // выбираем из строки password символы по одному
            char c = password.charAt(i); // это текущий символ в строке password
            if (Character.isUpperCase(c)) {
                test[1] = true;
            }
            if (Character.isLowerCase(c)) {
                test[2] = true;
            }
            if (Character.isDigit(c)) {
                test[3] = true;
            }
            if (symbols.indexOf(c) >= 0) ;{
                test[4] = true;
            }
        }
        return test[0] && test[1] && test[2] && test[3] && test[4];
    }


    @Override
    public String toString() {
        return "User { " +
                "email = " + email +
                ", password = " + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(email, user.email)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}

