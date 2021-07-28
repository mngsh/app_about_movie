Данное приложение показывает рейтинг фильмов, краткое описание и т.д., аналог https://www.kinopoisk.ru/ https://www.imdb.com/
Для получения данных о фильмах используется бесплатный сервис The Movie DB. 

## Цель данного проекта: 

- изучении стека технологий для создания клиент-серверного приложения.

## В проекте используются следующие библиотеки и фрэймворки:

- Groupie для построения сложных списков на базе RecyclerView. [Ссылка](https://github.com/lisawray/groupie)
- Android Navigation для навигации между экранами. [Подробнее](https://developer.android.com/guide/navigation/navigation-getting-started)
- [ViewPager 2.0](https://developer.android.com/training/animation/vp2-migration)
- Retrofit для работы REST API (https://square.github.io/retrofit/)
- RxJava для реактивного программирования (https://github.com/ReactiveX/RxAndroid)
- Dagger 2 для внедрения зависимостей (https://developer.android.com/training/dependency-injection/dagger-android)
- Kotlin Coroutines (https://kotlinlang.org/docs/coroutines-guide.html#table-of-contents)
- Clean architecture
- MVVM

## Этапы реализации проекта:

1. Реализовать UI приложения.
2. Внедрить Retrofit, без использования архитектурных компонентов (весь код реализован в UI).
3. Внедрить в проект RxJava.
4. Использовать ORM Room для кэштрования данных.
5. Разбить приложение на основании паттерна Clean architecture.
6. Добавить Live Data и MVVM.
7. Внедрение зависимостей Dagger 2.
8. Попробовать реализовать Kotlin coroutines.
