package codelabs.room_with_a_view

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class WordsApplication : Application() {
    var scope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this,scope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}