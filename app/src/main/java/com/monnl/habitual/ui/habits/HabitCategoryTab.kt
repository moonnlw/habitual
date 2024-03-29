package com.monnl.habitual.ui.habits

import com.monnl.habitual.data.models.Habit
import com.monnl.habitual.data.models.HabitType

interface HabitCategoryTab {
    val text: String
    val filterPredicate: (Habit) -> Boolean
}

object GoodHabits : HabitCategoryTab {
    override val text = "Good habits"
    override val filterPredicate: (Habit) -> Boolean = { it.type == HabitType.Good }
}

object BadHabits : HabitCategoryTab {
    override val text = "Bad habits"
    override val filterPredicate: (Habit) -> Boolean = { it.type == HabitType.Bad }
}

val habitsScreenCategories = listOf(GoodHabits, BadHabits)