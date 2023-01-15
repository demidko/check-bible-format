# check-bible-format

Утилита для проверки библейских файлов на
соответствие [формату BibleQuote](https://github.com/demidko/BibleQuote/blob/main/src/main/kotlin/app/biblequote/utils/HtmlBibleReader.kt).

## Скачать

* [Для Windows](https://github.com/demidko/check-bible-format/releases/download/2023.01.15/check-bible-format.exe)
* [Для macOS](https://github.com/demidko/check-bible-format/releases/download/2023.01.15/check-bible-format-macos)
* [Для Linux](https://github.com/demidko/check-bible-format/releases/download/2023.01.15/check-bible-format-linux)

Может потребоваться разрешить утилите работу в вашей системе (или пометить файл как исполняемый).

## Пример использования

```shell
./check-bible-format stern.html
```

## Формат

Ожидается, что формат текста эталонного файла будет таким

```html
<h3>Книга (т. е. название)</h3>
<h4>Глава (т. е. число)</h4>
<p><sup>Номер стиха, например 1</sup> собственно текст стиха 1
<p><sup>Номер стиха, например 2</sup> собственно текст стиха 2

И так далее для всех последующих глав и стихов
```

Тег `<sup>` здесь необязателен, вместо него может сразу идти номер стиха (цифрой).  
Если программа споткнется на каком-то файле, то выдаст ошибку о том, что она ожидала увидеть и не увидела. Например,
такую

```text
Exception in thread "main" java.lang.IllegalStateException: Стих По Матфею 1:26 отсутствует
```

Это необязательно означает, что стих отсутствует, может быть, его в этом переводе вообще нет, или может
быть, предыдущий стих разбит на две строки, или вместо него идет ненужная справочная информация. В
таком случае, вам нужно самостоятельно найти проблемное место и
разобраться, исправить. 
