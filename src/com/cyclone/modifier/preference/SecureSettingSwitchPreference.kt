package com.cyclone.modifier.preference

import android.content.Context
import android.util.AttributeSet

import androidx.preference.SwitchPreference

class SecureSettingSwitchPreference : SwitchPreference {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle)

    init {
        setPreferenceDataStore(SecureSettingsStore(context.contentResolver))
    }

    override fun onSetInitialValue(restoreValue: Boolean, defaultValue: Any?) {
        val def = defaultValue as Boolean
        setChecked(if (restoreValue) getPersistedBoolean(def) else def)
    }
}