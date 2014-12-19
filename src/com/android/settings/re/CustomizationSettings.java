
package com.android.settings.re;

mport com.android.internal.logging.MetricsLogger;

import android.os.Bundle;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import java.util.Locale;
import android.text.TextUtils;
import android.view.View;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

public class CustomizationSettings extends SettingsPreferenceFragment implements
        OnPreferenceChangeListener {

    private static final String KEY_BRIEFINGWIDGET = "briefingwidget";
    private static final String KEY_BRIEFINGWIDGET_PACKAGE_NAME = "com.re.briefingwidget";
	
    private PreferenceScreen mBriefingWidget;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.re_customization);

        PreferenceScreen prefSet = getPreferenceScreen();
		
    // mBriefingWidget 
    	mBriefingWidget = (PreferenceScreen) findPreference(KEY_BRIEFINGWIDGET);
        if (!Utils.isPackageInstalled(getActivity(), KEY_BRIEFINGWIDGET_PACKAGE_NAME)) {
            prefSet.removePreference(mBriefingWidget);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {

		// preference changes here
        return false;
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsLogger.APPLICATION;
    }
}