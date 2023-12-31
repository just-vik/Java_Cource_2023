<a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html"> DateTimeFormatter</a>

____________________________________________________

# Exceptions, Try ... catch, throw

## Exceptions, Try ... catch, throw.

Ошибка в методе, прерывает его работы в точке происхождения ошибки, и разрушает весь стек функций.
При этом Java создает и "пробрасывает" специальный объект характеризующий ошибку.
Все такие объекты наследуют классу **Throwable**.

Все наследники Throwable делятся на две категории: **Error** и **Exception**.
Error - это ошибки с которыми ничего сделать нельзя. Например, нехватка памяти.
Вторая категория, Exception - исключительные ситуации вызванные некорректным состоянием программы.

Ошибки бывают двух типов: **checked** (проверяемые) и **unchecked** (непроверяемые).
Первый тип компилятор "видит" и заставляет программиста как-то на них отреагировать.
Как реагировать на непроверяемые ошибки (и реагировать ли вообще), решает сам разработчик.

Обработка ошибок осуществляется при помощи конструкции **try-catch-finally**.
В блоки try мы указываем, что делать если все нормально. В блоке catch обрабатываем ошибки.
Блок finally выполняется в любой случае.

Мы можем создавать свои ошибки и "бросать" их при помощи ключего слова throw.
Если мы хотим создать проверяемое исключение, то можно наследовать классу Exception.
Если непроверяемое, то наследуем классу RuntimeException.

Если мы столкнулись с проверяемым исключением, но не хотим его обрабатывать в данном методе при помощи
try-catch, и решили пробросить это исключение в вызывающий метод, то можно воспользоваться ключевым
словом throws в сигнатуре метода.
______________________

# Exceptions

Exception - исключение, особая ситуация (перевод с английского)

## Major reasons why an exception Occurs
* **Invalid user input - неправильный ввод пользователя (80-90% случаев)**
* Device failure - сломалось устройство, выключили питание и т.д.
* Loss of network connection - потеряли Интернет, Ethernet и т.д.
* Physical limitations (out of disk memory) - нехватка памяти ОЗУ, жестких дисков
* Opening an unavailable file - открытие недоступного файла
* * **Code errors - ошибки кода программистов**

### Differences between Error and Exception that is as follows:
* **Error:** An Error indicates a **serious problem** that a reasonable application
  should **not try to catch**.
* **Exception:** Exception indicates **conditions** that a reasonable application
  **might try to catch**.

Кострукция **try ... catch** используется в тот момент, когда программа завершает работу
некорректно, Code выхода из программы отличен от 0.

### Синтаксис
`try { // попытаться
//  Block of code to try

}
catch(Exception e) { // схватить
//  Block of code to handle errors
}`
#### Пояснения
The **try** statement allows you to define a block of code
to be tested for errors while it is being executed.

The **catch** statement allows you to define a block of code
to be executed, if an error occurs in the try block.
The **try and catch keywords come in pairs**:

Многие исключения и ошибки пользователя можно обрабатывать самому с помощью if , НО ЗАЧЕМ?
Разарботчики Java предоставляют стандартный инструментарий для этого -
это класс Throwable (потомок класса Object) и его методы.

Примеры:
1. Деление на 0;
2. Выход за пределы массива;
3. Проверка ввода пользователя на корректность.

Хорошая статья с примерами:
https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-java/

Алгоритм применения try ... catch
1. Ели программа падает (код окончания не равен 0) , работа с пользователем прекращается
2. то смотрим на дигностику - то, что печатается в момент падения программы, там есть указания на номера строк
   в коде, в которых происходят ошибки
3. На эти строки надо "одеть" конструкцию try ... catch

==============================================

# ENUM - кратко

Тип перечисления — это специальный тип данных, который позволяет переменной быть набором предопределенных констант.
Переменная должна быть равна одному из предопределенных для нее значений. Поскольку они являются константами,
имена полей перечисляемого типа пишутся большими буквами.

В языке программирования Java тип перечисления определяется с помощью ключевого слова enum.
Например, вы можете указать тип перечисления дней недели следующим образом:

	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}

Все перечисления неявно расширяют java.lang.Enum.
Вот ссылка на официальный Oracle туториал по перечисляемым типам:
<a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Enum</a>

**Область применения ENUM**
Задачи, в которых имеется конечный перечень значений, например:
- дни недели
- месяцы в году
- времена года
- роли пользователей в системе (USER, GUEST, ADMIN, MANAGER)
- ...
  Иначе пришлось бы заводить массив соответствующего типа под каждый такой список.

------------------------------------

# Java Time API

Java Time API, это набор классов и интерфейсов для работы с датой, временем, календарем.

## Применение, использование
Классы LocalDate, LocalTime, LocalDateTime предназначены для создания объектов связанных с датой,
временем, датой-временем, соответственно.
Объекты этих классов являются неизменными (immutable).
У этих классов нет публичных конструкторов.
Объекты этих классов создаются через статические методы.
Например, метод now() создает объект связанный с текущей датой или временем.
При помощи метода of можно создать объект связанный с конкретной датой или временем.

У объектов LocalDate, LocalTime, LocalDateTime есть множество геттеров, позволяющих получить
информацию о дате или времени.
Например, метод getDayOfYear вернет порядковый номер дня в году.
А метод getDayOfWeek вернет enum DayOfWeek связанный с днем недели.

Объекты LocalDate, LocalTime, LocalDateTime сравниваемы (Comparable).
Кроме того, при помощи методов isBefore, isAfter можно узнать дата идет до или после аргумента.

Методы plus, minus и их варианты позволяют прибавлять или вычитать из дат временные промежутки.
При помощи enum ChronoUnit можно определять о каких временных промежутках идет речь.
Например, ChronoUnit.HOURS - это часы, а ChronoUnit.MINUTES - минуты. И т. п.

У объектов ChronoUnit есть методы. Например ChronoUnit.YEARS.between() принимает две даты и возвращает
полное количество лет между ними.

## Преобразование дат в строки и обратно
Для преобразований дат в String и обратно необходимо определять формат даты и времени в соответствии с ISO 8601.
DateTimeFormatter это класс отвечающий за форматы. Он имеет предопределенные форматы в виде констант.
Или при помощи статического метода DateTimeFormatter.ofPattern() можно создать формат по шаблону.

Метод parse() у объектов даты, времени может создать объект из стринга в соответствии с указанным форматом.
Метод format() наоборот, преобразует объект в стринг в соответствии с заданным форматом.

## Полезные ссылки
Вот ссылка на официальный Oracle туториал по
<a href="https://docs.oracle.com/javase/tutorial/datetime/index.html"> Java Time API </a> и
ссылка на
<a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html"> DateTimeFormatter </a>