package codelabs.room_with_a_view

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//The database class for Room must be abstract and extend RoomDatabase
@Database(entities = [Word::class], version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao()

    companion object {
        @Volatile
        private var INSTANCE : WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return INSTANCE as WordRoomDatabase
            }

        }
    }
}
