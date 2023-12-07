# Java Stream API

Java Stream API предоставляет множество методов для работы с последовательностями элементов данных. Вот краткий обзор основных методов Stream API:

### Создание потоков:

- `stream()` и `parallelStream()`
    - `stream()` создает последовательный поток элементов.
    - `parallelStream()` создает параллельный поток элементов.
- `of()`
    - Создает поток из переданных элементов.
- `generate()` и `iterate()`
    - `generate()` создает поток с бесконечной последовательностью, заданной Supplier'ом.
    - `iterate()` создает поток с бесконечной последовательностью, заданной начальным значением и функцией преобразования.

### Преобразование и фильтрация:

- `map()` и `flatMap()`
    - `map()` преобразует каждый элемент в другой объект.
    - `flatMap()` преобразует каждый элемент в поток объектов и объединяет их в один поток.
- `filter()`
    - Фильтрует элементы на основе заданного условия.
- `distinct()`
    - Удаляет дублирующиеся элементы из потока.

### Редукция:

- `reduce()`
    - Производит редукцию элементов с помощью заданной операции.
- `collect()`
    - Собирает элементы потока в коллекцию или другую структуру данных.

### Матчинг и поиск:

- `anyMatch()`, `allMatch()`, `noneMatch()`
    - Проверяют, соответствует ли хотя бы один элемент, все элементы или ни один элемент заданному условию.
- `findFirst()` и `findAny()`
    - `findFirst()` находит первый элемент в потоке.
    - `findAny()` находит любой элемент в потоке.

### Сортировка и ограничение:

- `sorted()`
    - Сортирует элементы потока.
- `limit()` и `skip()`
    - `limit()` ограничивает количество элементов в потоке.
    - `skip()` пропускает заданное количество элементов в потоке.

### Группировка и агрегация:

- `groupingBy()` и `partitioningBy()`
    - `groupingBy()` группирует элементы по заданному критерию.
    - `partitioningBy()` разделяет элементы на две группы по заданному условию.
- `count()`, `sum()`, `average()`, `min()`, `max()`
    - Выполняют агрегацию данных: подсчет, суммирование, вычисление среднего значения, поиск минимального и максимального значений.

### Создание и преобразование:

- `empty()`
    - Создает пустой поток.
- `concat()`
    - Объединяет два потока в один.
- `builder()`
    - Создает новый Builder для построения потока.

### Промежуточные операции:

- `peek()`
    - Позволяет выполнить заданное действие для каждого элемента потока без изменения самого потока.
- `unordered()`
    - Убирает упорядоченность элементов в потоке, если она была установлена.

### Генерация числовых потоков:

- `range()`, `rangeClosed()`
    - `range()` создает поток чисел в заданном диапазоне (не включая верхнюю границу).
    - `rangeClosed()` создает поток чисел в заданном диапазоне (включая верхнюю границу).

### Параллельная обработка:

- `isParallel()` и `sequential()`
    - `isParallel()` проверяет, является ли поток параллельным.
    - `sequential()` преобразует параллельный поток в последовательный.

### Создание специализированных потоков:

- `chars()`, `codePoints()`, `lines()`
    - Создают специализированные потоки для работы с символами, кодовыми точками или строками из текстовых данных.

### Соединение и разделение потоков:

- `joining()`
    - Соединяет строки из элементов потока в одну строку.
- `spliterator()`
    - Возвращает Spliterator для элементов потока.

### Создание коллекций:

- `toSet()`, `toList()`, `toMap()`
    - Преобразуют элементы потока в Set, List или Map соответственно.

### Операции по работе с Optional:

- `findFirst()`, `findAny()`
    - Возвращают Optional с первым/любым элементом потока.
- `orElse()`, `orElseGet()`, `orElseThrow()`
    - Позволяют получить значение из Optional в случае его наличия или вернуть указанное значение или сгенерировать исключение.

### Параллельные потоки и управление задачами:

- `forEachOrdered()`
    - Гарантирует, что операции forEach будут выполнены в заданном порядке.
- `parallel()`
    - Преобразует последовательный поток в параллельный.