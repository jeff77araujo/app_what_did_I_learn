package com.app.whatdidilearn.data

import com.app.whatdidilearn.entities.ItemLearned
import com.app.whatdidilearn.entities.Level

class DatabaseItems {
    fun getAll(): List<ItemLearned> {
        val itemOne = ItemLearned(
                "Kotlin - Null safety",
                "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
                understandingLevel = Level.HIGH
        )

        val itemTwo = ItemLearned(
                "Layout editor",
                "O Design Editor exibe o layout em vários dispositivos e versões do Android." +
                            "É possível criar e editar um layout usando apenas componentes visuais",
                understandingLevel = Level.MEDIUM
        )

        val itemThree = ItemLearned(
                "Git",
                "É um sistema de controle de versão distribuido. Com ele é possível rastrear " +
                            "mudanças no código fonte durante o desenvolvimento de software's",
                understandingLevel = Level.LOW
        )

        val itemFour = ItemLearned(
                "GroupView",
                "É uma view especial que pode conter outras views (chamadas de filhos). " +
                            "É a classe base para layouts e containers de views",
                understandingLevel = Level.MEDIUM
        )

        val itemFive = ItemLearned(
                "View Binding",
                "View Binding é um recurso que facilita a programação de códigos que interagem com views ",
                understandingLevel = Level.MEDIUM
        )

        return listOf(itemOne, itemTwo, itemThree, itemFour, itemFive)

    }
}