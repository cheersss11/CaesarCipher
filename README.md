# Проект CaesarCipher
CaesarCipher – це Java-програма, яка виконує шифрування та розшифрування текстових файлів за допомогою шифру Цезаря. Програма підтримує три режими: ENCRYPT, DECRYPT і BRUTE_FORCE, які дозволяють шифрувати текст із заданим ключем, розшифровувати текст з відомим ключем та автоматично підбирати ключ методом brute-force.

## Функції програми
Шифрування (ENCRYPT): Зашифровує текст у файлі з використанням шифру Цезаря та зберігає результат у новому файлі з позначкою [ENCRYPTED].
Розшифрування (DECRYPT): Розшифровує текст у зашифрованому файлі з відомим ключем та зберігає результат з позначкою [DECRYPTED].
Brute-force (BRUTE_FORCE): Пробує всі можливі ключі для розшифрування тексту та зберігає результати в новий файл із позначкою [BRUTEFORCED].

## Структура проєкту

1. Клас CaesarCipher Методи:

   encrypt(String text, int key): Шифрує текст, зсуваючи кожен символ на задану кількість позицій (ключ).
   decrypt(String text, int key): Розшифровує текст, зсуваючи кожен символ у зворотному напрямку на зазначений ключ.
   bruteForce(String encrypted): Перебирає всі можливі ключі для розшифрування тексту.

1. Клас FileService Методи:

   readFile(String filePath): Зчитує текст із файлу.
   writeFile(String filePath, String content, String suffix): Записує текст у новий файл із зазначеним суфіксом.
   addSuffix(String filePath, String suffix): Додає суфікс до імені файлу перед розширенням (якщо воно є).

1. Клас CLI Методи:

   parseArguments(String[] args): Обробляє аргументи командного рядка, визначаючи режим роботи програми, шлях до файлу та ключ (якщо він потрібен).

1. Клас Runner Методи:

   main(String[] args): Точка входу до програми. Обробляє аргументи та виконує відповідну команду.
   executeCommand(String command, String filePath, int key, CaesarCipher cipher, FileService fileService): Виконує задану команду (шифрування, розшифрування або brute-force).

## Інструкції з використання

Збірка проєкту Для збору проєкту використовуйте Maven. Виконайте команду: mvn clean package Це створить файл CaesarCipher.jar у папці target.

Запуск програми Програма підтримує три команди, кожна з яких запускається з аргументами командного рядка.

## Приклади команд

1. Шифрування
   ```bash
   java -jar target/CaesarCipher.jar encrypt "D:\path\to\file.txt" 3
   ```
   Ця команда зашифрує файл file.txt з ключем 3 та збереже результат у файлі file[ENCRYPTED].txt.

1. Розшифрування
   ```bash
   java -jar target/CaesarCipher.jar decrypt "D:\path\to\file[ENCRYPTED].txt" 3
   ```
   Ця команда розшифрує файл file[ENCRYPTED].txt з ключем 3 та збереже результат у файлі file[DECRYPTED].txt.

1. Brute-force
   ```bash
   java -jar target/CaesarCipher.jar bruteforce "D:\path\to\file[ENCRYPTED].txt"
   ```
   Ця команда підбере ключі для файлу file[ENCRYPTED].txt методом brute-force та збереже результати у файлі file[BRUTEFORCED].txt.

## Примітки

Програма підтримує лише шифрування та розшифрування символів зі строки
```java
ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»"':!? ".
```
Програма зберігає оригінальне форматування тексту (пробіли, великі літери та розділові знаки) при шифруванні та розшифруванні.
Якщо ключ надто великий, програма автоматично коригує його за довжиною алфавіту.
