**Поля класса**: 
закрепляем навык определения полей класса и задания им правильных типов данных. 
Рассмотрим следующие классы:

- Компания
  long id;              //он же налоговый номер
  String companyName;
  String companyType;
  int year;             //год основания, дата - это будет отдельный тип Data
  int employee;         //кол-во сотрудников

Address - плохая идея, адреса выносят в отдельный класс
------------------------------------------------------------
- *Дерево*
  long id;              
  String breed;         //порода, вид
  double height;        //рост, высота
  double diameter;
  boolean type;         //пригодность к чему то(хвойное, лиственное)
------------------------------------------------------------
- *Здание*
  long cadastreNumber;
  int floors;           //этажность
  boolean isLeaving;    //жилое или нет
  double square;        //площадь
  int yearBuilding;
  address - плохая идея, адреса выносят в отдельный класс
-----------------------------------------------------------
- *Письмо*
  String sender;
  String receiver;
  int postIndex;
  String city;
  String street;
  String houseNumber;
  double weight;
  double price;
  String type;
  boolean isLocal;
-----------------------------------------------------------

- *Пользователь*
  long customerId;
  String login;          //nickname
  String firstName;
  String lastName;
  String email;
  String phone;
  int age;
  boolean gender;
  String password;
  

Для каждого из классов делаем набор из 4-5 главных полей, определяем им типы.