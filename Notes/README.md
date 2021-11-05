# Notes

Приложение, которое позволяет пользователям сохранять заметки и добавлять тэги к ним.

Основная тема: работа с библиотекой [Room](https://developer.android.com/training/data-storage/room) (обертка над базой данных [SQLite](https://ru.wikipedia.org/wiki/SQLite))

### Основные моменты

1. использование [Room](https://developer.android.com/training/data-storage/room): создание базы данных, написание запросов и организация отношения "один ко многим"
2. работа с <code>FragmentManager</code>, добавление кнопки *Home* для навигации назад
3. архитектура MVVM: <code>ViewModel</code> -> <code>Repository</code> -> <code>Database</code> 
4. передача параметров в конструктор <code>ViewModel</code>, в том числе объекта <code>SavedStateHandle</code>, который позволяет сохранять примитивные  данные, когда приложение было убито из-за нехватки памяти (<code>ViewModel</code> в данном случае полностью уничтожается)
5. использование [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) для асинхронного выполнения запросов в базу данных
6. передача данных между фрагментами через аргументы
7. работа с <code>ClipboardManager</code> для сохранения заметки в буфер обмена
8. создание раскрывающего меню для сортировки заметок
9. создание диалогового окна и передача результата обратно в родительский фрагмент диалога
10. изменение цветов приложения

<table>
  <tr>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen1.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen2.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen3.png" /></td>
  </tr>  
  <tr>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen4.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen5.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen6.png" /></td>
  </tr>
  <tr>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen7.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/Notes/screens/screen8.png" /></td>
    
  </tr>
</table>  
