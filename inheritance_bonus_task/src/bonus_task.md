37. Бонусное задание 1 (необязательное)
    Добавить к задаче inheritance2 пункт:
8.Найти в отсортированном массиве ВСЕ покупки со стоимостью 5.00 BYN, для первоначального поиска использовав метод ``Arrays.binarySearch()``.
Желательно найти такое решение, которое после поиска позволяет выполнить задачу за один цикл.
Трюки типа ``Arrays.copyOfRange()`` не засчитываются, т.к. они реализованы через цикл.
То есть если быть максимально точным, то должен быть один цикл, и вычислительная сложность алгоритма после вызова метода ``Arrays.binarySearch()`` должна быть равна O(n).
Подсказка 1 - это решение существует)
    Подсказка 2
    ----------------- см. следующую строку -------------
    В чем смысл отрицательного значения метода ``binarySearch()``?
---------------------------------------------------------------
**Ответ.**
```java
public class Runner {

   public static void main(String[] args) {
      ...
      NumberDiscountPurchase purchase = new NumberDiscountPurchase(uniqueProduct, 1, new Byn(0)); // key
      ...
      System.out.println("Objects with a cost of 5 :");
      int search = Arrays.binarySearch(purchases, purchase);
      while (search >= 0 && search < purchases.length) {
         System.out.println(purchases[search]);
         search = search(purchases, search + 1, purchases.length - 1, purchase);
      }
   }

   private static int search(AbstractPurchase[] purchases, int fromPosition, int length, NumberDiscountPurchase purchase) {
      return Arrays.binarySearch(purchases, fromPosition, purchases.length - 1, purchase);
   }
}
```