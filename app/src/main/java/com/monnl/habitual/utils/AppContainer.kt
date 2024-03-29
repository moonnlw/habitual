package com.monnl.habitual.utils

import android.content.Context
import android.util.Log
import com.monnl.habitual.data.repos.HabitsRepositoryImpl
import com.monnl.habitual.data.room.LocalDatabase
import com.monnl.habitual.data.sources.LocalHabitsDataSource
import kotlinx.coroutines.*

class AppContainer(context: Context) {
    private val repositoryScope: CoroutineScope =
        CoroutineScope( Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            Log.e(javaClass.simpleName, exception.message.toString(), exception)
        })
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    val habitsRepository =
        HabitsRepositoryImpl(
            LocalHabitsDataSource(LocalDatabase.getDatabase(context).habitsDao),
            repositoryScope,
            ioDispatcher
        )
}