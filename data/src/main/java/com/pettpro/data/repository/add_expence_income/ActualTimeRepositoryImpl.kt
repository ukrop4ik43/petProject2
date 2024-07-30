package com.pettpro.data.repository.add_expence_income

import android.os.Build
import androidx.annotation.RequiresApi
import com.pettpro.domain.add_expence_income.ActualTimeRepository
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class ActualTimeRepositoryImpl @Inject constructor() :
    ActualTimeRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getActualTime(): String {
        return SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.getDefault()).format(Date())
    }


}