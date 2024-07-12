package com.pettpro.data.repository.add_expence_income

import android.os.Build
import androidx.annotation.RequiresApi
import com.pettpro.domain.add_expence_income.ActualTimeRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class ActualTimeRepositoryImpl @Inject constructor() :
    ActualTimeRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getActualTime(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        return current
    }


}