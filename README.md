# check-bible-format

Утилита для проверки библейских файлов на
соответствие формату [BibleQuote](https://github.com/demidko/BibleQuote).

## Скачать

* [Для Java](https://github.com/demidko/check-bible-format/releases/download/2023.01.17/bible)

## Формат

Ожидается, что формат текста эталонного файла будет таким

```html
<h3>Книга (т. е. название)</h3>
<h4>Глава (т. е. число)</h4>
<p><sup>Номер стиха, например 1</sup> собственно текст стиха 1
<p><sup>Номер стиха, например 2</sup> собственно текст стиха 2
```

И так далее для всех последующих глав и стихов. Тег `<sup>` здесь необязателен, вместо него может сразу идти номер
стиха (цифрой). Вот пример файла, оформленного в полном соответствии с этим
форматом: [rst.html](https://raw.githubusercontent.com/demidko/BibleQuote/main/src/main/resources/bible/rst.html)

## Пример использования

В терминале (cmd, bash или PowerShell подойдут) откройте папку с программой и наберите

```shell
java -jar checkbible stern.html
```

Затем нужно нажать клавишу Enter. Вместо `stern.html` может идти любой файл для проверки. Все файлы для проверки
можно [найти здесь](https://github.com/demidko/BibleQuote/tree/main/src/main/resources/bible). Если программа споткнется
на каком-то файле, то выдаст ошибку о том, что она ожидала увидеть и не увидела. Например,
такую

```text
java.lang.IllegalStateException: Стих По Матфею 1:26 отсутствует
```

Это необязательно означает, что стих отсутствует, может быть, его в этом переводе вообще нет, или может
быть, предыдущий стих разбит на две строки, или вместо него идет ненужная справочная информация. В
таком случае, вам нужно самостоятельно найти проблемное место и
разобраться, исправить. Важно не забыть о том, что не должно остаться двойных пробелов, или непонятных названий книг.

## Названия книг

В некоторых переводах, обыкновенные назания книг заменены на более "экзотические". Это тоже нужно исправить.
Хотелось бы видеть везде такие названия: "Бытие", "Исход", "Левит", "Числа", "Второзаконие", "Иисус Навин", "Судьи", "
Руфь",  "1-я Царств", "2-я Царств", "3-я Царств", "4-я Царств", "1-я Паралипоменон", "2-я Паралипоменон",  "Ездра", "
Неемия", "Есфирь",  "Иов", "Псалтирь", "Притчи", "Екклесиаст", "Песнь Песней",  "Исаия", "Иеремия", "Плач Иеремии", "
Иезекииль", "Даниил", "Осия", "Иоиль", "Амос", "Авдий", "Иона", "Михей", "Наум", "Аввакум", "Софония", "Аггей", "
Захария", "Малахия", "По Матфею", "По Марку", "По Луке", "По Иоанну","Деяния",  "Иакова", "1-е Петра", "2-е Петра", "
1-е Иоанна", "2-е Иоанна", "3-е Иоанна", "Иуды", "Римлянам", "1-е Коринфянам", "2-е Коринфянам", "Галатам", "
Ефесянам", "Филлипийцам", "Колосянам", "1-е Фессалоникийцам", "2-е Фессалоникийцам", "1-е Тимофею", "2-е Тимофею", "
Титу", "Филимону", "Евреям",  "Откровение"
