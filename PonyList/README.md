## PonyList

Демонстрирует работу со списком <code>RecyclerView</code> и адаптером <code>ListAdapter</code>.

Приложение имеет две кнопки: 1-ая удаляет элемент из списка, 2-ая добавляет его.

В обычном <code>RecyclerView.Adapter</code> вам нужно вручную говорить, какой элемент был удален из списка или изменён, а в <code>ListAdapter</code> это происходит автоматически, только вам нужно передать <code>DiffUtil.ItemCallback&lt;T&gt;</code> для проверки элементов на равенство.

Также в приложении применена [Open Source библиотека](https://github.com/wasabeef/recyclerview-animators) для анимации элементов списка.

<table>
  <tr>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/PonyList/screens/screen1.png" height=700 /></td>
    <td><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/PonyList/screens/screen2.png" height=700 /></td>
  </tr>
</table>

<img src="https://github.com/KiberneticWorm/LearningApps/blob/master/PonyList/screens/screen3.png" width="80%" />

<img src="https://github.com/KiberneticWorm/LearningApps/blob/master/PonyList/screens/screen4.gif" height=700 />
