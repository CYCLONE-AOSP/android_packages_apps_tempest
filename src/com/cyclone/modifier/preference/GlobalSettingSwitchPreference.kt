package com.cyclone.modifier.preference

import android.content.Context
import android.util.AttributeSet

import androidx.preference.SwitchPreference

class GlobalSettingSwitchPreference : SwitchPreference {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle)

    init {
        setPreferenceDataStore(GlobalSettingsStore(context.contentResolver))
    }

    override fun onSetInitialValue(restoreValue: Boolean, defaultValue: Any?) {
        val def = defaultValue as Boolean
        setChecked(if (restoreValue) getPersistedBoolean(def) else def)
    }
}