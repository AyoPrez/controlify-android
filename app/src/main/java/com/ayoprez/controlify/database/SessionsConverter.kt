package com.ayoprez.controlify.database

import androidx.room.TypeConverter
import com.ayoprez.controlify.model.Session
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SessionsConverter {

    companion object {
        @TypeConverter
        @JvmStatic
        fun fromSessionsListToStoredString(valueList: ArrayList<Session>?): String? {
            if (valueList == null) {
                return null
            }
            val gson = Gson()
            val type = object : TypeToken<List<Session>>() {

            }.type
            return gson.toJson(valueList, type)
        }

        @TypeConverter
        @JvmStatic
        fun fromStoredStringToListOfSessions(sessions: String?): ArrayList<Session>? {
            if (sessions == null) {
                return null
            }
            val gson = Gson()
            val type = object : TypeToken<List<Session>>() {}.type
            return gson.fromJson(sessions, type)
        }
    }
}