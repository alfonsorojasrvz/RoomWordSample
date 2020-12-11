package codelabs.room_with_a_view

import android.app.Application

class WordsApplication : Application() {

    val database by lazy { WordRoomDatabase.getDatabase(this) }
    val repository by lazy { WordRepository(database.wordDao()) }
}