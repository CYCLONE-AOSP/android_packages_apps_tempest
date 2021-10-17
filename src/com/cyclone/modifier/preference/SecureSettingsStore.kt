package com.cyclone.modifier.preference

import android.content.ContentResolver
import androidx.preference.PreferenceDataStore
import android.provider.Settings

class SecureSettingsStore(private val mContentResolver: ContentResolver) : PreferenceDataStore() {

    override fun getBoolean(key: String, defValue: Boolean): Boolean = getInt(key, if (defValue) 1 else 0) != 0

    override fun getFloat(key: String, defValue: Float): Float = Settings.Secure.getFloat(mContentResolver, key, defValue)

    override fun getInt(key: String, defValue: Int): Int = Settings.Secure.getInt(mContentResolver, key, defValue)

    override fun getLong(key: String, defValue: Long): Long = Settings.Secure.getLong(mContentResolver, key, defValue)

    override fun getString(key: String, defValue: String?): String? {
        val result = Settings.Secure.getString(mContentResolver, key)
        return result ?: defValue
    }

    override fun putBoolean(key: String, value: Boolean) {
        putInt(key, if (value) 1 else 0)
    } 

    override fun putFloat(key: String, value: Float) {
        Settings.Secure.putFloat(mContentResolver, key, value)
    }

    override fun putInt(key: String, value: Int) {
        Settings.Secure.putInt(mContentResolver, key, value)
    }

    override fun putLong(key: String, value: Long) {
        Settings.Secure.putLong(mContentResolver, key, value)
    }

    override fun putString(key: String, value: String?) {
        Settings.Secure.putString(mContentResolver, key, value)
    }
}