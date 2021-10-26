## PersonalApp

Простое приложение, которое выводит аватарку и небольшое описание:

<table border="0">
  <tr style="border: none">
    <td style="border: none"><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/PersonalApp/screenshots/screen1.png" height="600px" /></td>
    <td style="border: none"><img src="https://github.com/KiberneticWorm/LearningApps/blob/master/PersonalApp/screenshots/screen2.png" height="600px" /></td>
  </tr>
</table>

Приложение имеет <code>MainActivity</code>, в которой определена основная логика приложения:

        // класс Name содержит в себе имя с тремя смайликами
        supportActionBar?.title = Name(this).str()

        // чтобы получить view в коде, нужно указать id для нее
        // получаем корневой элемент по id
        val root = findViewById<View>(R.id.root)

        // находим нашу кнопку и сразу указываем для нее слушатель события нажатия 
        findViewById<Button>(R.id.subscribe_button).setOnClickListener {
            // показываем всплывающее сообщение, что успешно подписались на блог :)
            Snackbar.make(root, R.string.subscribed, Snackbar.LENGTH_SHORT).show()
        }
        

Важное замечание: в моем приложении используется <code>RoundedImageView</code>, которое округляет любое изображение:

        // изображение с закругленными углами
        class RoundedImageView @JvmOverloads constructor(
            ctx: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0
        ) : AppCompatImageView(ctx, attrs, defStyleAttr) {

            // Kotlin расширение, переводит dp в пиксели
            private fun Int.dp() = context.resources.displayMetrics.density * this

            override fun draw(canvas: Canvas) {

                // создаем Path с закругленным прямоугольником
                val path = Path().apply {
                    val rectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
                    val radius = 100.dp()
                    addRoundRect(rectF, radius, radius, Path.Direction.CW)
                }

                // используем clipPath, чтобы изменить форму нашего view
                canvas.clipPath(path)

                super.draw(canvas)
            }

        }      
