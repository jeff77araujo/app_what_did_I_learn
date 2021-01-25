package com.app.whatdidilearn.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.app.whatdidilearn.entities.LearnedItem
import com.app.whatdidilearn.entities.UnderstandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseItems: RoomDatabase() {

    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        // Singleton para evitar que multiplas instâncias do banco de dados sejam abertas ao mesmo tempo
        @Volatile
        private var INSTANCE: DatabaseItems? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DatabaseItems {
            // se INSTANCE não é nulo, então retorna ela mesma,
            // se INSTANCE é nula, então cria uma instancia do banco
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseItems::class.java,
                    "learned_item_database"
                )
//                    .addCallback(DatabaseItemsCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        fun getAll(): List<LearnedItem> {
            val itemOne = LearnedItem(
                "Kotlin - Null safety",
                "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
                understandingLevel = UnderstandingLevel.HIGH
            )

            val itemTwo = LearnedItem(
                "Layout editor",
                "O Design Editor exibe o layout em vários dispositivos e versões do Android." +
                        "É possível criar e editar um layout usando apenas componentes visuais",
                understandingLevel = UnderstandingLevel.MEDIUM
            )

            val itemThree = LearnedItem(
                "Git",
                "É um sistema de controle de versão distribuido. Com ele é possível rastrear " +
                        "mudanças no código fonte durante o desenvolvimento de software's",
                understandingLevel = UnderstandingLevel.LOW
            )

            val itemFour = LearnedItem(
                "GroupView",
                "É uma view especial que pode conter outras views (chamadas de filhos). " +
                        "É a classe base para layouts e containers de views",
                understandingLevel = UnderstandingLevel.MEDIUM
            )

            val itemFive = LearnedItem(
                "View Binding",
                "View Binding é um recurso que facilita a programação de códigos que interagem com views ",
                understandingLevel = UnderstandingLevel.MEDIUM
            )

            return listOf(itemOne, itemTwo, itemThree, itemFour, itemFive)
        }
    }

    private class DatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch { populateDatabase(database.learnedItemDao()) }
            }
        }
        suspend fun populateDatabase(dao: LearnedItemDao) {
            val itemOne = LearnedItem(
                    "Kotlin - Null safety",
                    "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
                    understandingLevel = UnderstandingLevel.HIGH
            )

            val itemTwo = LearnedItem(
                    "Layout editor",
                    "O Design Editor exibe o layout em vários dispositivos e versões do Android." +
                            "É possível criar e editar um layout usando apenas componentes visuais",
                    understandingLevel = UnderstandingLevel.MEDIUM
            )

            val itemThree = LearnedItem(
                    "Git",
                    "É um sistema de controle de versão distribuido. Com ele é possível rastrear " +
                            "mudanças no código fonte durante o desenvolvimento de software's",
                    understandingLevel = UnderstandingLevel.LOW
            )

            val itemFour = LearnedItem(
                    "GroupView",
                    "É uma view especial que pode conter outras views (chamadas de filhos). " +
                            "É a classe base para layouts e containers de views",
                    understandingLevel = UnderstandingLevel.MEDIUM
            )

            val itemFive = LearnedItem(
                    "View Binding",
                    "View Binding é um recurso que facilita a programação de códigos que interagem com views ",
                    understandingLevel = UnderstandingLevel.MEDIUM
            )
            dao.insert(itemOne)
            dao.insert(itemTwo)
            dao.insert(itemThree)
            dao.insert(itemFour)
            dao.insert(itemFive)
        }
    }
}