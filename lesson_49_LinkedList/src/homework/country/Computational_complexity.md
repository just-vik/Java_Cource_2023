### Computational complexity methods
*size()* -  O(1) — константная

*add(E element)* - O(1) так как добавляем элемент в конец списка

*clear()* - O(1) кол-во операций не зависит от размера списка(обнуление ссылок на узлы)

*add(int index, E element)* -  O(n) линейная; перемещаемся по списку

*getNodeByIndex(int index)* -  O(n) линейная 

*get(int index)* - O(n) линейная (в зависимости от расположения индекса)

*indexOf(Object o)* -  O(n) линейная 

*lastIndexOf(Object o)* - O(n) линейная 

*remove(int index)* - O(n) линейная 

*set(int index, E element)* - O(n) линейная 

*iterator()* - перебор по всем элементам O(1)