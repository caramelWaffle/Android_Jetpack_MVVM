import android.content.Context

abstract class Contextor {

    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }

        fun getContext(): Context {
            return context
        }
    }
}