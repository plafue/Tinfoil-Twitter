package com.mill_e.twitterwrapper.util;

import android.webkit.WebView;

/**
 * Removes elemens from twitters mobile-friendly site using javascript.
 *  - "Install Android App" from log in prompt
 *  - "Install Android App" blue banner in the  "Home" section
 *  - "Who to Follow" list in the "Home" section
 *  - "Open App" button in the navigation bar, upper right
 *
 *  As the site uses a lot of AJAX, we will just check regularly and
 *  remove whatever we find. Could be optimized to be easier on the battery.
 */
public class AnnoyancesRemover {

    private static final String START = "javascript: window.setInterval(function(){";
    private static final String END   = "}, 800)";
    private static final String INSTALL_APP_PROMPT_DURIN_LOGIN = "if(document.title=='Log in'){document.getElementsByTagName('table')[0].innerHTML='';}";
    private static final String INSTALL_APP_PROMPT             = "document.getElementsByClassName('install-app-prompt-container')[0].innerHTML='';";
    private static final String INSTALL_WHO_TO_FOLLOW          = "document.getElementsByClassName('wtf')[0].innerHTML='';";
    private static final String OPEN_APP                       = "document.getElementsByClassName('launchapp')[0].innerHTML='';";

    /**
     * Remove annoyances from the WebView
     * @param view
     */
    public void removeAnnoyances(WebView view) {
        view.loadUrl(createJavascript());
    }

    private String createJavascript() {
        return START +
                INSTALL_APP_PROMPT_DURIN_LOGIN +
                INSTALL_APP_PROMPT +
                INSTALL_WHO_TO_FOLLOW +
                OPEN_APP +
                END;
    }
}
